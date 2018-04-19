package com.appcontroll.appcontroll_lists_db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;
import java.util.UUID;

/**
 * Created by АхметжановЕ on 19.04.2018.
 */

@Entity
public class EntityItemList {
    @PrimaryKey UUID id;
    private String listName;

    List<TodoList> todoLists;

    public EntityItemList(String listName, UUID id) {
        this.listName = listName;
        this.id = id;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
