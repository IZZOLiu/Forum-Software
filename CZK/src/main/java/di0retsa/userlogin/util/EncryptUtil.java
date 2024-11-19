package di0retsa.userlogin.util;

import di0retsa.userlogin.entity.EncryptProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * 加密工具类
 */
@RequiredArgsConstructor
@Component
public final class EncryptUtil {
    private final EncryptProperties encryptProperties;

    /**
     * 加密/解密 隐私数据
     * @param text 文本 opMode 操作数，请用Cipher类定义的参数 加密 = 1； 解密 = 2
     * @return
     * @throws Throwable
     */
    public String encrypt(byte[] text, int opMode) throws Throwable {
        String cipherInstance = encryptProperties.getCipherInstance();
        byte[] secretKey = encryptProperties.getSecretKey().getBytes(StandardCharsets.UTF_8);
        if(secretKey.length != 16){
            throw new Throwable();
        }
        SecretKeySpec key = new SecretKeySpec(secretKey, "AES");
        Cipher cipher = Cipher.getInstance(cipherInstance);
        cipher.init(opMode, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(text));
    }

}
