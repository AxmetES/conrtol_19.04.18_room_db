package com.appcontroll.appcontroll_lists_db.Activitys;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.provider.DocumentsContract;

import com.appcontroll.appcontroll_lists_db.EntityItemListDB;

import android.app.Application;

public class App extends Application {
    public static App instance;
    private EntityItemListDB database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this,EntityItemListDB.class,"database")
                .build();

    }
    public static App getInstance(){
        return instance;
    }
    public EntityItemListDB getDatabase(){
        return database;
    }
}
