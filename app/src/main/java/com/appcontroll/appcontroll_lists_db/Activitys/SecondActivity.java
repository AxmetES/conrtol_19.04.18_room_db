package com.appcontroll.appcontroll_lists_db.Activitys;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontroll.appcontroll_lists_db.Adapters.SecondAdapter;
import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;
import com.appcontroll.appcontroll_lists_db.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity{

    RecyclerView detailsRecyclerView;
    RecyclerView.Adapter detailAdapter;
    private ArrayList<TodoList> todoLists;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        final int message = getIntent().getExtras().getInt("ListId");
        final String message2 = getIntent().getExtras().getString("ListName");
        Toast.makeText(SecondActivity.this,"id"  +  message,Toast.LENGTH_LONG).show();
        Toast.makeText(SecondActivity.this,"name"  +  message2,Toast.LENGTH_LONG).show();

        detailsRecyclerView = findViewById(R.id.sa_detail_rv);
        detailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        detailAdapter = new SecondAdapter(getApplicationContext(), EntityItemListDB.getAppDB(getApplicationContext()).getDoListDao().fromToDoById(message));
        detailsRecyclerView.setAdapter(detailAdapter);


        fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,AddToToDoListActivity.class);
                intent.putExtra("ListId ", message);
                intent.putExtra("ListName", message2);
                Toast.makeText(SecondActivity.this,"id"  +  message + "name" + message2,Toast.LENGTH_LONG).show();
                SecondActivity.this.startActivity(intent);
//              startActivity(new Intent(SecondActivity.this, AddToToDoListActivity.class));

            }
        });
//        date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               getDatePicker();
//            }
//        });
    }
}
