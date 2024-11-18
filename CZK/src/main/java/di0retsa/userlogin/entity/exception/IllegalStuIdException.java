package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;

/**
 * 非法学号异常
 */
public class IllegalStuIdException extends BaseException{
    public static String message = "非法学号，请检查学号";
    public static StatusCode errorCode = StatusCode.CLIENT_ERROR;
}
