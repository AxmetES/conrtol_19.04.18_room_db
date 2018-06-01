package com.appcontroll.appcontroll_lists_db.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.appcontroll.appcontroll_lists_db.Adapters.SecondAdapter;
import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;
import com.appcontroll.appcontroll_lists_db.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecyclerView detailsRecyclerView;
    RecyclerView.Adapter detailAdapter;
    private ArrayList<TodoList> todoLists;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        final String message = getIntent().getExtras().getString("ListName");
        detailsRecyclerView = findViewById(R.id.sa_detail_rv);
        detailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailAdapter = new SecondAdapter(getApplicationContext(), EntityItemListDB.getAppDB(getApplicationContext()).getDoListDao().fromToDoByOwnerId(message));
        detailsRecyclerView.setAdapter(detailAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,AddToToDoListActivity.class);
                intent.putExtra("ListName", message);
                Toast.makeText(SecondActivity.this,"ListName"  +  message,Toast.LENGTH_LONG).show();
                SecondActivity.this.startActivity(intent);
            }
        });

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
