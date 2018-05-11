package com.appcontroll.appcontroll_lists_db.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;
import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;

import java.util.Date;
import java.util.List;

@Dao
public interface ToDoListDAO {

    @Insert
    void insertAll(TodoList todoList);

    @Delete
    void delete(TodoList todoList);

    @Query("SELECT * FROM listnametb")
    public List<EntityItemList> getlistnametb();

    @Query("SELECT * FROM todolisttb ORDER BY todo_date")
    public List<TodoList> getDate();

    @Query("SELECT * FROM todolisttb")
    public List<TodoList> getAllToDoItems();

    @Query("SELECT * FROM todolisttb WHERE todo_text LIKE :todo_text")
    List<TodoList> getTodoList (String todo_text);
}
