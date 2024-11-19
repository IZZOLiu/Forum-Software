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
     * 相应实体
     */
    private T data;

    public static <T> ResponseEntity<String> success(){
        Result<T> result = new Result<T>();
        result.status = Integer.parseInt(StatusCode.SUCCESS.toString());
        result.message = "操作成功";
        return ResponseEntity
                .ok()
                .body(JSONUtil.toJsonStr(result));
    }

    public static <T> ResponseEntity<String> success(T object){
//        Result<T> result = new Result<T>();
//        result.status = StatusCode.SUCCESS;
//        result.message = "操作成功";
//        result.data = object;
        return ResponseEntity
                .ok()
                .body(JSONUtil.toJsonStr(object));
    }

    public static <T> ResponseEntity<String> error(BaseException ex){
        Result<T> result = new Result<T>();
        result.status = ex.getErrorCode().getCode();
        result.message = ex.getMessage();
        return ResponseEntity
                .status(result.status)
                .body(JSONUtil.toJsonStr(result));
    }
}
