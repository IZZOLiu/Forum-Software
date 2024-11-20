package di0retsa.userlogin.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT Token工具类配置属性
 */
@Data
@Component
@ConfigurationProperties(prefix = "szu.forum.jwt")
public class JWTProperties {
    /**
     * 管理端员工生成jwt令牌相关配置
     * 密钥
     * 过期时间
     *
     */
    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;
    private String adminTokenPrefix;

    /**
     * 用户端微信用户生成jwt令牌相关配置
     */
    private String userSecretKey;
    private long userTtl;
    private String userTokenName;
    private String userTokenPrefix;

}
