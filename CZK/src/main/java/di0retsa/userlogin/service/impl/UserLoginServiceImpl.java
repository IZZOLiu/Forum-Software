package di0retsa.userlogin.service.impl;

import cn.hutool.core.util.StrUtil;
import di0retsa.userlogin.entity.User;
import di0retsa.userlogin.entity.dto.UserLoginDTO;
import di0retsa.userlogin.entity.exception.*;
import di0retsa.userlogin.entity.vo.UserLoginVO;
import di0retsa.userlogin.mapper.UserMapper;
import di0retsa.userlogin.service.UserLoginService;
import di0retsa.userlogin.util.EncryptUtil;
import di0retsa.userlogin.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService {
    private final EncryptUtil encryptUtil;

    private final JWTUtil jwtUtil;

    private final UserMapper userMapper;

    private static Boolean LegalTest(UserLoginDTO userLoginDTO) throws Throwable {
        // 非空检验
        if (userLoginDTO == null || StrUtil.isBlank(userLoginDTO.getStuId()) || StrUtil.isBlank(userLoginDTO.getPassword())) {
            throw new TextIsBlankException();
        }
        // 密码合法性检验
        if (!userLoginDTO.isLegalPassword()) {
            throw new IllegalPasswordException();
        }
        // 学号合法性检验
        if (!userLoginDTO.isLegalStuId()){
            throw new IllegalStuIdException();
        }
        return Boolean.TRUE;
    }

    @Override
    public UserLoginVO userLogin(UserLoginDTO userLoginDTO) throws Throwable {
        LegalTest(userLoginDTO);
        // 查询用户是否存在
        User user = userMapper.getByStuId(userLoginDTO.getStuId());
        if (!Objects.nonNull(user)) {
            throw new UserNonException();
        }
        // 检验密码
        String storePassword = encryptUtil.encrypt(userLoginDTO.getPassword().getBytes(), Cipher.ENCRYPT_MODE);
        if (!storePassword.equals(user.getPassword())) {
            throw new ErrorPasswordException();
        }
        // 生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getUserId());
        claims.put("username", user.getUsername());
        claims.put("role", user.getRole());

        String jwtToken = jwtUtil.createJWT(user.getRole(), claims);
        return UserLoginVO.builder()
                .userId(user.getUserId())
                .token(jwtToken)
                .message("登陆成功!")
                .username(user.getUsername())
                .build();
    }

    @Override
    public User userRegister(UserLoginDTO userLoginDTO) throws Throwable {
        LegalTest(userLoginDTO);
        // 查询用户是否存在
        User user = userMapper.getByStuId(userLoginDTO.getStuId());
        if (Objects.nonNull(user)) {
            throw new UserExistException();
        }
        User newUser = User.builder()
                .stuId(userLoginDTO.getStuId())
                .password(encryptUtil.encrypt(userLoginDTO.getPassword().getBytes(),Cipher.ENCRYPT_MODE))
                .username(userLoginDTO.getStuId()) // 默认用户名与学号一致
                .role(0)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        userMapper.insert(newUser);
        return newUser;
    }
}
