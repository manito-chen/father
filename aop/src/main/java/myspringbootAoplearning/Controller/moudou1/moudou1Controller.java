package myspringbootAoplearning.Controller.moudou1;

import myspringbootAoplearning.utils.annotation.log.SystemControllerLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName moudou1Controller
 * @Description TODO
 * @Author 维C银翘片
 * @Date 2021/03/31  21/54
 * @Version 1.0
 * @Return
 **/

@RestController
@RequestMapping("hello")
public class moudou1Controller {


    @SystemControllerLog(description = "登陆")
    @GetMapping("h1")
    public  String  hello(){

        return "hello world 登陆";
    }

    @SystemControllerLog(description = "注销")
    @GetMapping("h2")
    public  String  hello1(){

        return "注销";
    }
    @SystemControllerLog(description = "管理")
    @GetMapping("h4")
    public  String  hello2(){

        return "hello world 管理";
    }
    @SystemControllerLog(description = "功能1")
    @GetMapping("h5")
    public  String  hello3(){

        return "hello world 功能1";
    }
}
