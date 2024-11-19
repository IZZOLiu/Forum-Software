package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;
import lombok.Getter;

public abstract class BaseException extends Throwable {
    private String message;
    private StatusCode errorCode;

    public abstract StatusCode getErrorCode();

    public abstract String getMessage();

}
