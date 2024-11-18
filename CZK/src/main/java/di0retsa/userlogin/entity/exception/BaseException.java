package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;

public abstract class BaseException extends Throwable {
    public static String message;
    public static StatusCode errorCode;
}
