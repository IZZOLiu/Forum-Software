package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;

/**
 * 参数为空异常
 */
public class TextIsBlankException extends BaseException {
    public static String message = "用户名和密码不能为空";
    public static StatusCode errorCode = StatusCode.CLIENT_ERROR;
}
