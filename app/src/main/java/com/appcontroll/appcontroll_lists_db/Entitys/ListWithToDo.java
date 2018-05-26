package com.appcontroll.appcontroll_lists_db.Entitys;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class ListWithToDo {
    @Embedded
    public EntityItemList entityItemList;
    @Relation(parentColumn = "id", entity = TodoList.class, entityColumn = "ownerId")
    public List<TodoList> todoLists;

}
