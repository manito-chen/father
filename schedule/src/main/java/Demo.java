import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author 维C银翘片
 * @Date 2021/04/19  16/31
 * @Version 1.0
 * @Return
 **/


@SpringBootApplication
@EnableScheduling
public class Demo {
    public static void main(String[] args) {
        SpringApplication.run(Demo.class,args);
    }

}
