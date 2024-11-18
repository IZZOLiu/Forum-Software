package di0retsa.userlogin.entity.exception;

import di0retsa.userlogin.entity.StatusCode;

/**
 * 用户已存在异常（注册时）
 */
public class UserExistException extends BaseException {
    public static String message = "该学号已被注册过，请直接登录";
    public static StatusCode errorCode = StatusCode.CLIENT_ERROR;
}
