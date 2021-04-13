package myspringbootAoplearning.utils.annotation.log;


import java.lang.annotation.*;

@Target({ElementType.PARAMETER,ElementType.METHOD})//作用在参数和方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {

    String description() default "";

}
