package com.appcontroll.appcontroll_lists_db.Activitys;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;
import com.appcontroll.appcontroll_lists_db.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    static EntityItemListDB appDB;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;
    List<EntityItemList> entityItemLists;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            appDB = Room.databaseBuilder(getApplicationContext(),EntityItemListDB.class,"mainlistdatabase")
                    .allowMainThreadQueries()
                    .build();

       // appDB.getEntityDao().getAllEntity();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.ma_list_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MainListAdapter(context, appDB.getEntityDao().getAllEntity());
        recyclerView.setAdapter(adapter);

        fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddToMainListActivity.class));

            }
        });
    }
}