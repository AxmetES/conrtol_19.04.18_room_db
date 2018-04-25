package com.appcontroll.appcontroll_lists_db.Entitys;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by АхметжановЕ on 19.04.2018.
 */

@Entity(tableName = "todolisttb",
        foreignKeys = @ForeignKey(
        entity = EntityItemList.class,
        parentColumns = "id",
        childColumns = "ownerId"
))
public class TodoList {
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "todo_text")
    private String toDoText;

    @ColumnInfo(name = "ownerId")
    private String ownerId;

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

