package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;
/**
 * 密码错误异常
 */
public class ErrorPasswordException extends BaseException {
    public static String message = "密码错误，请检查密码";
    public static StatusCode errorCode = StatusCode.CLIENT_ERROR;
}
