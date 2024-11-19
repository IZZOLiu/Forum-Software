package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 非法学号异常
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "非法学号，请检查学号")
public class IllegalStuIdException extends BaseException{
    private final String message = "非法学号，请检查学号";
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
