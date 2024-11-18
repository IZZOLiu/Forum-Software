package di0retsa.userlogin;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("di0retsa.userlogin.mapper")
public class UserLoginApplication {
    public static void main(String[] args){
        SpringApplication.run(UserLoginApplication.class);
        log.info("UserLogin Server Started.");
    }
}
