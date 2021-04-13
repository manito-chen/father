package myspringbootAoplearning.utils.ret;

import lombok.Data;

/**
 * @ClassName RetResult
 * @Description TODO
 * @Author 维C银翘片
 * @Date 2021/04/13  15/35
 * @Version 1.0
 * @Return
 **/

public class RetResult<T> {
    public int code;
    private String  msg;
    private T data;



    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
