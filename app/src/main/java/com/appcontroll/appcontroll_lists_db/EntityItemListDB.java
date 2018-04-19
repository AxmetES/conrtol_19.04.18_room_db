package com.appcontroll.appcontroll_lists_db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by АхметжановЕ on 19.04.2018.
 */

@Database(entities = {EntityItemList.class}, version = 1)
public abstract class EntityItemListDB extends RoomDatabase {
    public abstract EntityItemListDAO getEntityDao();
}
