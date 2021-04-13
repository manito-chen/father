package myspringbootAoplearning.Controller.moudou1;

import myspringbootAoplearning.utils.annotation.check.paramCheck;
import myspringbootAoplearning.utils.ret.R;
import myspringbootAoplearning.utils.ret.RetCode;
import myspringbootAoplearning.utils.ret.RetResult;
import org.apache.lucene.util.fst.Util;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author 维C银翘片
 * @Date 2021/04/13  17/07
 * @Version 1.0
 * @Return
 *
 * 测试访问 http://localhost:8080/hello1，此时只有 @RequestParam 注解，如果不加 name 参数，会请求得到一个异常：
 * 并且控制台会报 MissingServletRequestParameterException: Required String parameter 'name' is not present] 异常
 * 如果访问 http://localhost:8080/hello2?name=，此时使用的是我们自定义的 @ParamCheck 注解，此时没有参数输入，那么也会捕获输入的异常：
 *如果访问 http://localhost:8080/hello3?name=，此时既有参数存在校验，又有我们自定义的 ParamCheck 不为空校验，所以此时访问不加参数会抛出异常：
 *
 * 测试总结：
 *
 * 当参数名为空时，分别添加两个注解的接口都会提示参数不能为空
 * 当参数名不为空，值为空时，@RequestParam注解不会报错，但@ParamCheck注解提示参数'name'的值为空
 *
 *
 * 经过以上的测试也验证了 @RequestParam 只会验证对应的参数是否存在，而不会验证值是否为空
 * ParamCheck 还可以进行拓展，比如参数值长度、是否含有非法字符等校验
 *
 **/
@RestController
public class HelloController {
    /**
     * 测试@RequestParam注解
     *
     * @param name 测试参数
     * @return 包装结果
     */
    @GetMapping("/hello1")
    public RetResult<String> hello1(@RequestParam String name) {
        return R.makeOKRsp("Hello," + name);
    }

    /**
     * 测试@ParamCheck注解
     *
     * @param name 测试参数
     * @return 包装结果
     */
    @GetMapping("/hello2")
    public RetResult<String> hello2(@paramCheck String name) {
        return R.makeOKRsp("Hello," + name);
    }

    /**
     * 测试@ParamCheck与@RequestParam一起时
     *
     * @param name 测试参数
     * @return 包装结果
     */
    @GetMapping("/hello3")
    public RetResult<String> hello3(@paramCheck @RequestParam String name) {
        return R.makeRsp(RetCode.SUCCESS.getCode(),"请求成功", "Hello," + name);
    }
}
