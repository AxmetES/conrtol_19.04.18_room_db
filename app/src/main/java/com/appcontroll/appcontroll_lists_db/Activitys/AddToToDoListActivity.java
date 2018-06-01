package com.appcontroll.appcontroll_lists_db.Activitys;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;
import com.appcontroll.appcontroll_lists_db.R;

import java.util.Calendar;

public class AddToToDoListActivity extends AppCompatActivity {

    Button addBtn;
    EditText etToDoText;
    TextView etDateBtn,etName;
    Calendar mCurrentDate;
    int day,month,year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_to_do_list);
        setTitle("Add to Do List");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        final String message = getIntent().getExtras().getString("ListName");
        Toast.makeText(AddToToDoListActivity.this,"ListName"  +  message,Toast.LENGTH_LONG).show();

        etToDoText = (EditText)findViewById(R.id.add_edit_toDolist);
        etDateBtn = (TextView) findViewById(R.id.add_date_toDolist);
        etName = (TextView) findViewById(R.id.list_name_add_tv);
        etName.setText(message);

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

                String toDoTextTe = etToDoText.getText().toString();
                String toDoDateTe = etDateBtn.getText().toString();
                String toDoWonerId = etName.getText().toString();
                TodoList todoList = new TodoList();
                todoList.setToDoText(toDoTextTe);
                todoList.setTodoDate(toDoDateTe);
                todoList.setOwnerId(toDoWonerId);
                EntityItemListDB.getAppDB(getApplicationContext()).getDoListDao().insertAll(todoList);
                startActivity(new Intent(AddToToDoListActivity.this, SecondActivity.class).putExtra("ListName", todoList.getOwnerId()));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}