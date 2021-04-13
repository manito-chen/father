package myspringbootAoplearning.utils.annotation.check;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*  参数不能为空注解，作用于方法参数上
 * @Author 维c银翘片
 * @Description TODO
 * @Date 2021/4/13 16:32
 * @Param
 * @Return
 **/
/*
          // TYPE类型可以声明在类上或枚举上或者是注解上
                 TYPE,
          // FIELD声明在字段上
                FIELD,
          // 声明在方法上
                 METHOD,
          // 声明在形参列表中
                PARAMETER,
          // 声明在构造方法上
                CONSTRUCTOR,
          // 声明在局部变量上
                LOCAL_VARIABLE,
 **/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface paramCheck {
    /**
     * 是否非空,默认不能为空
     */
    boolean notNull() default true;
}
