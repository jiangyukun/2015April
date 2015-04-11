package me.jiangyu.april.dto;

import me.jiangyu.april.core.Constants;

/**
 * Created by jiangyukun on 15/4/11.
 */
public class DtoReturned {
    private String state = Constants.SUCCESS;
    private Object data;


    public DtoReturned() {

    }

    public DtoReturned(String state) {
        this.state = state;
    }

    public DtoReturned(Object data) {
        this.data = data;
    }

    public DtoReturned(Object data, String state) {
        this.data = data;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
