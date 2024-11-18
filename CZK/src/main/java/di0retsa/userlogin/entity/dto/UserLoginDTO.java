package di0retsa.userlogin.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserLoginDTO {
    @JsonProperty("stu_id")
    private String stuId;
    private String password;

    /**
     * 判断密码是否合法
     * @return
     */
    public Boolean isLegalPassword(){
        String password = this.getPassword();
        // 密码长度必须大于等于8位 小于等于20位
        if(password.length() < 8 || password.length() > 20){
            return false;
        }
        // 密码必须包含字母和数字
        password = password.toLowerCase();
        Boolean hasNum = false;
        Boolean hasChar = false;
        for (int i = 0; i < password.length(); i++) {
            if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z'){
                hasChar = true;
            } else if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                hasNum = true;
            }
            if(hasChar && hasNum){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断学号是否合法
     * @return
     */
    public  Boolean isLegalStuId(){
        String stuId = this.getStuId();
        if(stuId.length() != 10){
            return false;
        }
        // 学号只能包含数字（应该还有更多校验？）
        for (int i = 0; i < 10; i++) {
            if(stuId.charAt(i) < '0' || stuId.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
}
