package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;

/**
 * token错误异常
 */
public class ErrorTokenException extends BaseException {
    public static String message = "token解析失败";
    public static StatusCode errorCode = StatusCode.CLIENT_ERROR;
}
