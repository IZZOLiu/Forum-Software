package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 用户不存在异常（登陆时）
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "该用户不存在，请先注册")
public class UserNonException extends BaseException {
    private final String message = "该用户不存在，请先注册";
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
