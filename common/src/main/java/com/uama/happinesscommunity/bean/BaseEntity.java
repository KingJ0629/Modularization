package com.uama.happinesscommunity.bean;

import java.io.Serializable;

/**
 * Created by DWCloud on 2016/5/17.
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -9059609995608994497L;
    private String status;
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
