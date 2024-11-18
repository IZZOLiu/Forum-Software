package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;

/**
 * 用户不存在异常（登陆时）
 */
public class UserNonException extends BaseException {
    public static String message = "该用户不存在，请先注册";
    public static StatusCode errorCode = StatusCode.CLIENT_ERROR;
}
