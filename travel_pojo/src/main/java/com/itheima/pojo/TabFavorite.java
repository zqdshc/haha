package com.itheima.pojo;

import java.io.Serializable;
import java.util.Date;

public class TabFavorite extends TabFavoriteKey implements Serializable {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}