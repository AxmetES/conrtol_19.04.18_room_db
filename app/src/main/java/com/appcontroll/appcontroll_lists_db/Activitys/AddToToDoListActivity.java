package com.appcontroll.appcontroll_lists_db.Activitys;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;
import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;
import com.appcontroll.appcontroll_lists_db.R;

import java.util.Calendar;
import java.util.Date;

public class AddToToDoListActivity extends AppCompatActivity {

    Button addBtn;
    EditText etDoListName;
    TextView etDateBtn;
    Calendar mCurrentDate;
    int day,month,year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_to_do_list);
        setTitle("Add to Do List");

        etDoListName = (EditText)findViewById(R.id.add_edit_toDolist);
        etDateBtn = (TextView) findViewById(R.id.add_date_toDolist);

        mCurrentDate = Calendar.getInstance();
        day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);
        month = month+1;

        etDateBtn.setText(day+"/"+month+"/"+year);

        etDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddToToDoListActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        etDateBtn.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        addBtn = (Button)findViewById(R.id.add_toDolist_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String toDoListText = etDoListName.getText().toString();

                TodoList todoList = new TodoList();
                todoList.setToDoText(toDoListText);

                EntityItemListDB.getAppDB(getApplicationContext()).getDoListDao().insertAll(todoList);
                todoList.setToDoText("");

                startActivity(new Intent(AddToToDoListActivity.this, SecondActivity.class));
            }
        });
    }
}