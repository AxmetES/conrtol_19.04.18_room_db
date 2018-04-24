package com.appcontroll.appcontroll_lists_db.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;
import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;

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

    @Query("SELECT * FROM listnametb")
    List<EntityItemList> getAllEntity();

    @Query("SELECT * FROM listnametb WHERE list_name LIKE :listName")
    List<EntityItemList> getListName(String listName);

    @Query("SELECT * FROM todolisttb WHERE ownerId IS :ownerId")
    List<TodoList> getToDoListForOwnerId(String ownerId);           //ERROR??
}
