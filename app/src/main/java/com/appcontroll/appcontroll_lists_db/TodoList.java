package com.appcontroll.appcontroll_lists_db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by АхметжановЕ on 19.04.2018.
 */

@Entity(foreignKeys = @ForeignKey(
        entity = EntityItemList.class,
        parentColumns = "id",
        childColumns = "ownerId"
))
public class TodoList {
    @PrimaryKey int id;
    String toDoText;
    String ownerId;

    public TodoList() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getToDoText() {
        return toDoText;
    }
    public void setToDoText(String toDoText) {
        this.toDoText = toDoText;
    }
    public String getOwnerId() {return ownerId;}
    public void setOwnerId(String ownerId) {this.ownerId = ownerId;}
    }

