package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;

/**
 * 非法密码异常
 */
public class IllegalPasswordException extends BaseException{
    public static String message = "请输入长度为8-20位且包含数字和字母的密码";
    public static StatusCode errorCode = StatusCode.CLIENT_ERROR;
}
