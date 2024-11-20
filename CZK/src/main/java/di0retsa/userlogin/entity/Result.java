package di0retsa.userlogin.entity;

import cn.hutool.json.JSONUtil;
import di0retsa.userlogin.entity.exception.BaseException;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

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
    private Integer status;

    /**
     * 响应实体
     */
    private T data;

    /**
     * 成功响应 无返回结果
     * @return
     * @param <T>
     */
    public static <T> ResponseEntity<String> success(){
        Result<T> result = new Result<T>();
        result.status = Integer.parseInt(StatusCode.SUCCESS.toString());
        result.message = "操作成功";
        return ResponseEntity
                .ok()
                .body(JSONUtil.toJsonStr(result));
    }

    /**
     * 成功响应 返回对应实体类的JSON串
     * @param object 返回实体
     * @return object.toJSONStr
     * @param <T>
     */
    public static <T> ResponseEntity<String> success(T object){
//        Result<T> result = new Result<T>();
//        result.status = StatusCode.SUCCESS;
//        result.message = "操作成功";
//        result.data = object;
        return ResponseEntity
                .ok()
                .body(JSONUtil.toJsonStr(object));
    }

    /**
     * 失败响应 返回对应的错误信息和错误码
     * @param ex 自定义异常类
     * @return
     * @param <T>
     */
    public static <T> ResponseEntity<String> error(BaseException ex){
        Result<T> result = new Result<T>();
        result.status = ex.getErrorCode().getCode();
        result.message = ex.getMessage();
        return ResponseEntity
                .status(result.status)
                .body(JSONUtil.toJsonStr(result));
    }
}
