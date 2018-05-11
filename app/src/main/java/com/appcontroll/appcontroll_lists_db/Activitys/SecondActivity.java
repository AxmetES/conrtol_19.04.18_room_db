package com.appcontroll.appcontroll_lists_db.Activitys;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontroll.appcontroll_lists_db.R;

public class SecondActivity extends AppCompatActivity {
    int year_x,month_x,day_x;
    static final int DILOG_ID=0;

    TextView dl_text,dl_date_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showDialog();

        Intent intent = getIntent();

    }
    public void showDialog(){

        dl_date_text= findViewById(R.id.dl_date_text);
        dl_date_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DILOG_ID);
            }
        });


    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DILOG_ID){
            return new DatePickerDialog(this,dpickerListner, year_x,month_x,day_x);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpickerListner=
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int manthOfYear, int dayOfTheMonth) {
                    year_x = year;
                    month_x = manthOfYear;
                    day_x = dayOfTheMonth;
                    Toast.makeText(SecondActivity.this, year_x +"/"+ month_x +"/"+ day_x,Toast.LENGTH_SHORT).show();
                }
            };
}
