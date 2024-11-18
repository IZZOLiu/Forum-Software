package di0retsa.userlogin.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "szu.forum.encrypt")
public class EncryptProperties {
    /**
     * 密钥
     */
    private String secretKey;

    /**
     * 加密算法
     */
    private String cipherInstance;
}
