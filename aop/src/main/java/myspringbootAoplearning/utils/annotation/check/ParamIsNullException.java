package myspringbootAoplearning.utils.annotation.check;

/**
 * @ClassName ParamIsNullException
 * @Description TODO
 * @Author 维C银翘片
 * @Date 2021/04/13  16/38
 * @Version 1.0
 * @Description
 * 该异常继承 RuntimeException，并定义了两个成员属性、重写了 getMessage() 方法
 * 之所以自定义该异常，而不用现有的 org.springframework.web.bind.MissingServletRequestParameterException 类，
 * 是因为 MissingServletRequestParameterException为Checked 异常,在动态代理过程中，
 * 很容易引发 java.lang.reflect.UndeclaredThrowableException 异常。
 **/
public class ParamIsNullException extends RuntimeException {
    private final String parameterName;
    private final String parameterType;

    public ParamIsNullException(String parameterName, String parameterType) {
        super("");
        this.parameterName = parameterName;
        this.parameterType = parameterType;
    }

    @Override
    public String getMessage(){
        return "Required " + this.parameterType + " parameter \'" + this.parameterName + "\' must be not null !";
    }

    public String getParameterName() {
        return this.parameterName;
    }

    public String getParameterType() {
        return this.parameterType;
    }
}
