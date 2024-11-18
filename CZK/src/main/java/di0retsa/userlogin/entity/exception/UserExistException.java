package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 用户已存在异常（注册时）
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "该学号已被注册过，请直接登录")
public class UserExistException extends BaseException {
    private final String message = "该学号已被注册过，请直接登录";
    private final StatusCode errorCode = StatusCode.CLIENT_ERROR;

    @Override
    public StatusCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
