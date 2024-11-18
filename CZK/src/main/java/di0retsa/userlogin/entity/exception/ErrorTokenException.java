package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * token错误异常
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "token解析失败")
public class ErrorTokenException extends BaseException {
    private final String message = "token解析失败";
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
