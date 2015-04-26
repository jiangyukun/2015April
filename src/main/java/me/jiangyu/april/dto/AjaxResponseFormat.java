package me.jiangyu.april.dto;

import me.jiangyu.april.core.Constants;

/**
 * Created by jiangyukun on 4/23/15.
 */
public class AjaxResponseFormat {
    public static final AjaxResponseFormat DEFAULT = new AjaxResponseFormat();

    private String code;
    private String message;
    private Object data;

    public AjaxResponseFormat() {
        this(Constants.Code.OK, Constants.SUCCESS, null);
    }

    public AjaxResponseFormat(String code) {
        this(code, null, null);
    }

    public AjaxResponseFormat(String code, String message) {
        this(code, message, null);
    }

    public AjaxResponseFormat(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
