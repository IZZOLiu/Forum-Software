package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 密码错误异常
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "密码错误，请检查密码")
public class ErrorPasswordException extends BaseException {
    private final String message = "密码错误，请检查密码";
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
