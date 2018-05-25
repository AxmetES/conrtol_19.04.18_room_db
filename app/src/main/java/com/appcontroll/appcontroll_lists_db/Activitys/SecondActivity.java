package com.appcontroll.appcontroll_lists_db.Activitys;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;
import com.appcontroll.appcontroll_lists_db.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity{
    TextView dl_text,dl_date_text;
     static DatePickerDialog datePickerDialog;

    private RecyclerView detailsRecyclerView;
    RecyclerView.Adapter detailAdapter;
    private ArrayList<TodoList> todoLists;
    TextView date;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView)findViewById(R.id.dl_text);
        date = (TextView)findViewById(R.id.dl_date_text);

        Bundle bundle= getIntent().getExtras();
        String message = bundle.toString();
        Toast.makeText(SecondActivity.this,"message"+ message,Toast.LENGTH_LONG).show();

        detailsRecyclerView = findViewById(R.id.sa_detail_rv);
        detailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailAdapter = new SecondAdapter(EntityItemListDB.getAppDB(getApplicationContext()).getDoListDao().getTodoListByListName(message), getApplicationContext());
        detailsRecyclerView.setAdapter(detailAdapter);


//        date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               getDatePicker();
//            }
//        });



    }

    private void getDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(SecondActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {
                date.setText(dayOfMonth+" "+(month+1)+" "+year);
            }
        },year,month,dayOfMonth);
        datePickerDialog.show();
    }

}
