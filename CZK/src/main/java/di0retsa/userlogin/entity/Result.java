package di0retsa.userlogin.entity;

import cn.hutool.json.JSONUtil;
import lombok.Data;

/**
 * 响应结果类
 */
@Data
public class Result<T> {
    /**
     * 返回信息
     */
    private String message;

    /**
     * 状态码
     */
    private Integer statusCode;

    /**
     * 相应实体
     */
    private T data;

    public static <T> String success(){
        Result<T> result = new Result<T>();
        result.statusCode = Integer.parseInt(StatusCode.SUCCESS.toString());
        result.message = "操作成功";
        return JSONUtil.toJsonStr(result);
    }

    public static <T> String success(T object){
//        Result<T> result = new Result<T>();
//        result.status = StatusCode.SUCCESS;
//        result.message = "操作成功";
//        result.data = object;
        return JSONUtil.toJsonStr(object);
    }

    public static <T> String error(StatusCode statusCode, String message){
        Result<T> result = new Result<T>();
        result.statusCode = Integer.parseInt(statusCode.toString());
        result.message = message;
        return JSONUtil.toJsonStr(result);
    }
}
