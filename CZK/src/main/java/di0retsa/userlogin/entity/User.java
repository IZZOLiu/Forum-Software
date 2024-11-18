package di0retsa.userlogin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户信息类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class User {
    /**
     * 学号（10位数字）
     */
    private String stuId;

    /**
     * 密码（至少八位，包含字母和数字）
     */
    private String password;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色
     */
    private Integer role;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
