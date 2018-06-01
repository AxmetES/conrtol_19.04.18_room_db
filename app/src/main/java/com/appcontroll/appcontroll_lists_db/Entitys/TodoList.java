package com.appcontroll.appcontroll_lists_db.Entitys;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by АхметжановЕ on 19.04.2018.
 */

@Entity(tableName = "todolisttb",
        foreignKeys = @ForeignKey(
        entity = EntityItemList.class,
        parentColumns = "list_name",
        childColumns = "ownerId"))
public class TodoList {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "todo_text")
    private String toDoText;

    @ColumnInfo(name = "todo_date")
    private String todoDate;

    @ColumnInfo(name = "ownerId")
    private String ownerId;

    public TodoList(int id, String toDoText, String todoDate, String ownerId) {
        this.id = id;
        this.toDoText = toDoText;
        this.todoDate = todoDate;
        this.ownerId = ownerId;
    }

    public TodoList() {
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getToDoText() { return toDoText; }
    public void setToDoText(String toDoText) {
        this.toDoText = toDoText;
    }

    public String getTodoDate() {
        return todoDate;
    }
    public void setTodoDate(String todoDate) {
        this.todoDate = todoDate;
    }

    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}

