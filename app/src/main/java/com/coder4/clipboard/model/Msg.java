package com.coder4.clipboard.model;

import java.util.Date;

/**
 * Created by lihy on 15/10/13.
 */
public class Msg {
    private String msg;
    private long timestamp;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
