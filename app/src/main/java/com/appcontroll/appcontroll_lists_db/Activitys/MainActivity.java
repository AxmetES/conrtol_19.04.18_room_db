package com.appcontroll.appcontroll_lists_db.Activitys;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.appcontroll.appcontroll_lists_db.Adapters.MainListAdapter;
import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;
import com.appcontroll.appcontroll_lists_db.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    static RecyclerView.Adapter adapter;
    FloatingActionButton fab;
    List<EntityItemList> entityItemLists;
    final int MENU_DELETE = 1;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.ma_list_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MainListAdapter(getApplicationContext(), EntityItemListDB.getAppDB(getApplicationContext()).getEntityDao().getAllEntity());
        recyclerView.setAdapter(adapter);

        fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddToMainListActivity.class));
            }
        });
        registerForContextMenu(recyclerView);

        //fragmentContainer = (FrameLayout) findViewById(R.id.main_menu_fragment_conteiner);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_settings){
            changeFragment();
        }
        if(item.getItemId() == R.id.menu_about){
            changeFragment();
        }
        if(item.getItemId() == R.id.menu_app_exit){
            changeFragment();
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeFragment(){
        android.app.Fragment fragment = new android.app.Fragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.color_change_fragment, fragment);
        ft.commit();
    }
}