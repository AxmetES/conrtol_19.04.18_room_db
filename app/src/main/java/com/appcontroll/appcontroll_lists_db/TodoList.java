package com.appcontroll.appcontroll_lists_db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.UUID;

/**
 * Created by АхметжановЕ on 19.04.2018.
 */

@Entity
class TodoList {
    @PrimaryKey UUID id;
    String toDoText;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getToDoText() {
        return toDoText;
    }

    public void setToDoText(String toDoText) {
        this.toDoText = toDoText;
    }
}
