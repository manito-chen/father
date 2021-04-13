package myspringbootAoplearning.utils.annotation.log;

import myspringbootAoplearning.utils.IPUtil;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 * @ClassName SystemLogAspect
 * @Description TODO
 * @Author 维C银翘片
 * @Date 2021/04/12  23/00
 * @Version 1.0
 * @Return
 **/
@Aspect
@Component
@SuppressWarnings("all")//告诉编译器忽略指定的警告，不用在编译完成后出现警告信息。
public class SystemLogAspect {

//    @Resource  数据库操作


    private static final Logger logger = (Logger) LoggerFactory.getLogger(SystemLogAspect.class);

    // service 切点
    @Pointcut("@annotation(myspringbootAoplearning.utils.annotation.log.SystemServiceLog)")
    public void serviceAspect(){

    }
    // controller 切点
    @Pointcut("@annotation(myspringbootAoplearning.utils.annotation.log.SystemControllerLog)")
    public void controllerAspect(){

    }

    @Around("controllerAspect()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        //1.请求开始
        logger.info("=====请求进入======");
        long start=System.currentTimeMillis();
        //2.获取注解对象
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature=(MethodSignature)signature;
        Method method = methodSignature.getMethod();
        SystemControllerLog controllerLog = method.getAnnotation(SystemControllerLog.class);
        //3.获取注解属性
        String value = controllerLog.description();
        //4.获取request
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //5.记录日志
        logger.info("请求链接：{}",request.getRequestURL().toString());
        logger.info("请求类型：{}",request.getMethod());
        logger.info("请求IP：{}", IPUtil.getIpAdress(request));
        logger.info("user描述：{}", request.getAttribute("user"));
        logger.info("请求描述：{}",value);



        //6.执行
        Object object=joinPoint.proceed();
        //7.请求结束
        long end=System.currentTimeMillis();
        logger.info("请求用时：{}毫秒",(end-start));
        logger.info("=====请求结束======");
        return object;
    }



}
