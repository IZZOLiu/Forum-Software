package di0retsa.userlogin.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVO {
    private String token;
    private String username;
    @JSONField(name = "user_id")
    private String userId;
    private String message;
}
