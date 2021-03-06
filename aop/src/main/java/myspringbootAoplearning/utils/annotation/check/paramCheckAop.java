package myspringbootAoplearning.utils.annotation.check;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
/**
 * @ClassName paramCheckAop
 * @Description TODO
 * @Author 维C银翘片
 * @Date 2021/04/13  16/42
 * @Version 1.0
 * @Return
 **/

@Aspect
@Component
public class paramCheckAop {
    private static final Logger logger = LoggerFactory.getLogger(paramCheckAop.class);

    /**
     * 定义有一个切入点，范围为 controller 包下的类
     */
    @Pointcut("execution(public * myspringbootAoplearning.Controller..*.*(..))")
    public void checkParam(){

    }

    /**
     * 检查参数是否为空
     *
     * @param pjp 连接点
     * @return 对象
     * @throws Throwable 异常
     */
    @Around("checkParam()")
    public Object doAround(ProceedingJoinPoint pjp)throws Throwable{
        MethodSignature signature = ((MethodSignature) pjp.getSignature());
        //得到拦截的方法
        Method method = signature.getMethod();
        //获取方法参数注解，返回二维数组是因为某些参数可能存在多个注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (parameterAnnotations.length == 0) {
            return pjp.proceed();
        }
        //获取方法参数名
        String[] paramNames = signature.getParameterNames();
        //获取参数值
        Object[] paramValues = pjp.getArgs();
        //获取方法参数类型
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (int j = 0; j < parameterAnnotations[i].length; j++) {
                //如果该参数前面的注解是ParamCheck的实例，并且notNull()=true,则进行非空校验
                if (parameterAnnotations[i][j] != null && parameterAnnotations[i][j] instanceof paramCheck && ((paramCheck) parameterAnnotations[i][j]).notNull()) {
                    paramIsNull(paramNames[i], paramValues[i], parameterTypes[i] == null ? null : parameterTypes[i].getName());
                    break;
                }
            }
        }
        return pjp.proceed();

    }

    /**
     * 参数非空校验，如果参数为空，则抛出ParamIsNullException异常
     *
     * @param paramName  参数名称
     * @param value   参数值
     * @param parameterType 参数类型
     */
    private void paramIsNull(String paramName, Object value, String parameterType) {
        if (value == null || "".equals(value.toString().trim())) {
            throw new ParamIsNullException(paramName, parameterType);
        }
    }
    @Before("checkParam()")
    public void doBefore(JoinPoint joinPoint) {

    }

    /**
     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     *
     * @param joinPoint 连接点
     */
    @AfterReturning("checkParam()")
    public void doAfterReturning(JoinPoint joinPoint) {
    }
}
