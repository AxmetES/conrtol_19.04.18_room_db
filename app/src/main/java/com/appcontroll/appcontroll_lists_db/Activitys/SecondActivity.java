package com.appcontroll.appcontroll_lists_db.Activitys;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;
import com.appcontroll.appcontroll_lists_db.R;

import java.util.ArrayList;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    int year_x,month_x,day_x;
    static final int DILOG_ID = 0;
    TextView dl_text,dl_date_text;

    private RecyclerView detailsRecyclerView;
    private ArrayList<TodoList> todoLists;
    public Callback callback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        Intent intent = getIntent();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
