package com.appcontroll.appcontroll_lists_db.Entitys;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

/**
 * Created by АхметжановЕ on 19.04.2018.
 */

@Entity
public class EntityItemList {

    private ArrayList<EntityItemList> lists;

    @PrimaryKey int id;
    private String listName;

    public EntityItemList() {
    }

    public EntityItemList(String listName, int id) {
        this.listName = listName;
        this.id = id;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getListName() {
        return listName;
    }
    public void setListName(String listName) {
        this.listName = listName;
    }

}

