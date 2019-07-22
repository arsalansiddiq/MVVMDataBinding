package com.raaziatariq.mvvmdatabinding.core.realm.table;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class IDTable extends RealmObject {

    @PrimaryKey
    @Index
    private int ids;
    private String numbers;
    private Date timeout;
    private String devIds;

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public Date getTimeout() {
        return timeout;
    }

    public void setTimeout(Date timeout) {
        this.timeout = timeout;
    }

    public String getDevIds() {
        return devIds;
    }

    public void setDevIds(String devIds) {
        this.devIds = devIds;
    }
}
