package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;

/**
 * 基础异常抽象类
 */
public abstract class BaseException extends Throwable {
    private String message;
    private StatusCode errorCode;

    public abstract StatusCode getErrorCode();

    public abstract String getMessage();

}
