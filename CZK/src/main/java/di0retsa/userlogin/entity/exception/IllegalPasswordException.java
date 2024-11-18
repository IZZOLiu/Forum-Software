package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 非法密码异常
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "请输入长度为8-20位且包含数字和字母的密码")
public class IllegalPasswordException extends BaseException{
    private final String message = "请输入长度为8-20位且包含数字和字母的密码";
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
