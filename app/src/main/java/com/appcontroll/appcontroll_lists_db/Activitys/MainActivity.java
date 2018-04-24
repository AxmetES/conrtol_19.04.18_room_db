package com.appcontroll.appcontroll_lists_db.Activitys;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;
import com.appcontroll.appcontroll_lists_db.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;
    List<EntityItemList> entityItemLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.ma_list_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainListAdapter(entityItemLists);
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