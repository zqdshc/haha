package com.itheima.pojo;

import java.io.Serializable;

public class TabFavoriteKey implements Serializable {
    private Integer rid;

    private Integer uid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}