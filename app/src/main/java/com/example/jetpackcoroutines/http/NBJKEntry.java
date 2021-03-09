package com.example.jetpackcoroutines.http;

import java.util.List;


public class NBJKEntry {

    /**
     * code : 1
     * msg : 身份证格式不正确！
     * data : []
     */

    private Integer code;
    private String msg;
    private List<?> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
