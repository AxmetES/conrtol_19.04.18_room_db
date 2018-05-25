package com.appcontroll.appcontroll_lists_db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.appcontroll.appcontroll_lists_db.DAO.EntityItemListDAO;
import com.appcontroll.appcontroll_lists_db.DAO.ToDoListDAO;
import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;
import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;

/**
 * Created by АхметжановЕ on 19.04.2018.
 */

@Database
(entities = {EntityItemList.class, TodoList.class}, version = 1)
public abstract class EntityItemListDB extends RoomDatabase {
    private static EntityItemListDB INSTANCE;
    public abstract EntityItemListDAO getEntityDao();
    public abstract ToDoListDAO getDoListDao();
    public static EntityItemListDB getAppDB(Context context){
        if (INSTANCE ==null){
            INSTANCE =
                    Room.databaseBuilder(context,EntityItemListDB.class,"mainlistdatabase")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
    public static void destroyInstance()
    {
        INSTANCE = null;
    }
}
