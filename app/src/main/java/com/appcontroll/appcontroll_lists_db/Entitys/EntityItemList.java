package com.appcontroll.appcontroll_lists_db.Entitys;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by АхметжановЕ on 19.04.2018.
 */

@Entity(tableName = "listnametb")
    public class EntityItemList {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "list_name")
    private String listName;

    public EntityItemList() {
    }

    public EntityItemList(String listName) {
        this.listName = listName;
    }

    public String getListName() {
        return listName;
    }
    public void setListName(String listName) {
        this.listName = listName;
    }
}

