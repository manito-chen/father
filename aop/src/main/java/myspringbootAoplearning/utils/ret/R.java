package myspringbootAoplearning.utils.ret;

/**
 * @ClassName R
 * @Description TODO
 * @Author 维C银翘片
 * @Date 2021/04/13  15/41
 * @Version 1.0
 * @Return
 **/
public class R {

    private static final String SUCCESS="success";
    private static final String FAIL="fail";
    public static <T> RetResult<T> makeOKRsp() {
        RetResult<T> tRetResult = new RetResult<T>();
        tRetResult.setCode(RetCode.SUCCESS).setMsg(SUCCESS);
        return tRetResult;
    }

    public static <T> RetResult<T> makeErrRsp() {
        RetResult<T> tRetResult = new RetResult<T>();
        tRetResult.setCode(RetCode.FAIL).setMsg(FAIL);
        return tRetResult;
    }


    public static <T> RetResult<T> makeOKRsp(T data) {
        RetResult<T> tRetResult = new RetResult<T>();
        tRetResult.setCode(RetCode.SUCCESS).setMsg(SUCCESS);
        tRetResult.setData(data);
        return tRetResult;
    }

    public static <T> RetResult<T> makeErrRsp(T data) {
        RetResult<T> tRetResult =new RetResult<T>();
        tRetResult.setCode(RetCode.FAIL).setMsg(FAIL);
        tRetResult.setData(data);
        return tRetResult;
    }

    public static <T> RetResult<T> makeRsp(int code, String msg) {
        RetResult<T> tRetResult =new RetResult<T>();
        tRetResult.setCode(code);
        tRetResult.setMsg(msg);
        return tRetResult ;
    }

    public static <T> RetResult<T> makeRsp(int code, String msg, T data) {
        RetResult<T> tRetResult = new RetResult<T>();
        tRetResult.setCode(code);
        tRetResult.setMsg(msg);
        tRetResult.setData(data);
        return tRetResult;
    }

    /**
     * 请求异常返回结果
     *
     * @param <T> 泛型
     * @return 包装对象
     */
    public static <T> RetResult<T> exception() {
        RetResult<T> tRetResult = new RetResult<T>();
        tRetResult.setCode(RetCode.INTERNAL_SERVER_ERROR);
        tRetResult.setMsg("服务异常");

        return tRetResult;
    }

}
