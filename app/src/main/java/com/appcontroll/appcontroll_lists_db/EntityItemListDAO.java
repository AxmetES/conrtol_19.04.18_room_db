package com.appcontroll.appcontroll_lists_db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by АхметжановЕ on 19.04.2018.
 */

@Dao
public interface EntityItemListDAO {
    @Insert
    void insertAll(EntityItemList entityItemList);

    @Delete
    void delete(EntityItemList entityItemList);

    @Query("SELECT * FROM entityitemlist")
    List<EntityItemList> getAllEntity();

    @Query("SELECT * FROM entityitemlist WHERE listName LIKE :listName")
    List<EntityItemList> getListName(String listName);

    @Query("SELECT * FROM todolist WHERE ownerId IS :listName")
    List<TodoList> getToDoListForOwner(String ownerId);
}
