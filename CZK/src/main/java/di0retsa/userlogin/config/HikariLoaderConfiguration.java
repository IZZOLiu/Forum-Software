package di0retsa.userlogin.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 项目启动时完成Hikari连接池的初始化，加快第一次请求的速度
 */
@Component
public class HikariLoaderConfiguration implements ApplicationRunner {
    private final HikariDataSource hikariDataSource;

    public HikariLoaderConfiguration(HikariDataSource hikariDataSource) {
        this.hikariDataSource = hikariDataSource;
    }

    @Override
    @Autowired
    public void run(ApplicationArguments args) throws Exception {
        hikariDataSource.getConnection();
    }
}
