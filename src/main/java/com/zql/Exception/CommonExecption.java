package com.zql.Exception;

/**
 * @author: create
 * @description:
 * @date: 2019-8-22
 */
public class CommonExecption extends RuntimeException{
    private static final long serialVersionUID = -7671210108471143215L;
    private String code;
    private String msg;

    public CommonExecption(String code, Throwable t, String msg) {
        super(t);
        this.code = code;
        this.msg = msg;
    }

    public CommonExecption(String code, String msg) {
        this(code, (Throwable)null, msg);
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.msg;
    }
}
