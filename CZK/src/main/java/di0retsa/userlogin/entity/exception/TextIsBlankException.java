package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 参数为空异常
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "用户名和密码不能为空")
public class TextIsBlankException extends BaseException {
    private final String message = "用户名和密码不能为空";
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
