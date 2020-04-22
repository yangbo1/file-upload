package com.yb.fileupload.common;

/**
 * @description:
 * @author: yangbo
 * @time: 2020/4/20 10:43
 */
public class Result {

    private Integer code;


    private Object data;

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static Result ok() {
        return new Result(Constants.OK, null);
    }
    public static Result ok(Object data) {
        return new Result(Constants.OK, data);
    }
    public static Result error(Object data) {
        return new Result(Constants.ERROR, data);
    }
    public static Result error() {
        return new Result(Constants.ERROR, null);
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
