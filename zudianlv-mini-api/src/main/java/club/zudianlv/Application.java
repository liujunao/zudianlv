package club.zudianlv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yinren
 * @date 2019/5/1
 */
@SpringBootApplication
@MapperScan(basePackages = "club.zudianlv.mapper")
@ComponentScan(basePackages = {"club.zudianlv", "org.n3r.idworker"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);    }
}
