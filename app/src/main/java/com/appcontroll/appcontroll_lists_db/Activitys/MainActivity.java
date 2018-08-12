package com.appcontroll.appcontroll_lists_db.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

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
    private MainMenuFragment colorChangeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Constant.theme);
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


        colorChangeFragment = new MainMenuFragment();
        fragmentContainer = (FrameLayout) findViewById(R.id.main_fragment_layout);


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
            changeFragment(colorChangeFragment);
        }
        if(item.getItemId() == R.id.menu_about){

        }
        if(item.getItemId() == R.id.menu_app_exit){

        }
        return super.onOptionsItemSelected(item);
    }

    public void changeFragment(MainMenuFragment fragment){

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_fragment_layout, fragment);
        ft.commit();
        getSupportActionBar().setTitle("Change Color");
    }
}