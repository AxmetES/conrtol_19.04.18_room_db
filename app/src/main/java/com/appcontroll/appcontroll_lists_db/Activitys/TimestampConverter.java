package com.appcontroll.appcontroll_lists_db.Activitys;

import android.arch.persistence.room.TypeConverter;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.net.ParseException;
import android.provider.SyncStateContract;

import java.sql.Date;

public class TimestampConverter {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
    return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
