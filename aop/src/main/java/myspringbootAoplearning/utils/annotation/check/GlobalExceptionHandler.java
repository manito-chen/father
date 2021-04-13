package myspringbootAoplearning.utils.annotation.check;

import myspringbootAoplearning.utils.annotation.check.myException.CustomException;
import myspringbootAoplearning.utils.ret.R;
import myspringbootAoplearning.utils.ret.RetCode;
import myspringbootAoplearning.utils.ret.RetResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author 维C银翘片
 * @Date 2021/04/13  17/25
 * @Version 1.0
 * @Return
 *
 * 全局异常处理器
 **/


public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 参数为空异常处理
     *
     * @param ex 异常
     * @return 返回的异常
     */
    @ExceptionHandler({MissingServletRequestParameterException.class, ParamIsNullException.class})
    public RetResult<String> requestMissingServletRequest(Exception ex) {
        LOGGER.error("request Exception:", ex);
        return R.makeRsp(RetCode.FAIL.getCode(), ex.getMessage());
    }

    /**
     * 特别说明： 可以配置指定的异常处理,这里处理所有
     *
     * @param request 请求
     * @param e  异常体
     * @return 返回的异常
     */
    @ExceptionHandler(value = Exception.class)
    public RetResult<String> errorHandler(HttpServletRequest request, Exception e) {
//        LOGGER.error("request Exception:", e);
//        return R.exception();

        if(e instanceof CustomException) {
            CustomException ex = (CustomException)e;
            LOGGER.info("自定义业务异常：msg：" + ex.getMessage() + "，log：" + ex.getLog(), e);
            return R.makeRsp(ex.getCode(), ex.getMessage(),null);
//        }else if(e instanceof MethodArgumentNotValidException) {
//            MethodArgumentNotValidException ex = (MethodArgumentNotValidException)e;
//            LOGGER.error("参数校验异常：msg：" + ex.getBindingResult().getFieldError().getDefaultMessage());
//            return R.makeRsp(RetCode.WRONG_PARAM.getCode(),
//                    RetCode.WRONG_PARAM.getMsg() + "："
//                            + ex.getBindingResult().getFieldError().getDefaultMessage(), null);
        }else{
            LOGGER.error("统一系统异常：msg：" + e.getMessage(), e);
            return R.exception();
        }


    }

}