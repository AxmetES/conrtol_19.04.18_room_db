package com.appcontroll.appcontroll_lists_db.Activitys;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;
import com.appcontroll.appcontroll_lists_db.R;

import static com.appcontroll.appcontroll_lists_db.Activitys.MainActivity.adapter;

public class AddToMainListActivity extends AppCompatActivity{
    Button addBtn, deleteBtn;

    EditText etListName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_main_list);
        setTitle("Add to list");

        etListName = (EditText)findViewById(R.id.add_edit_tolist);
        addBtn = (Button)findViewById(R.id.add_tolist_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String listName = etListName.getText().toString();

                EntityItemList entityItemList = new EntityItemList();
                entityItemList.setListName(listName);

                MainActivity.appDB.getEntityDao().insertAll(entityItemList);
                entityItemList.setListName("");

                startActivity(new Intent(AddToMainListActivity.this, MainActivity.class));

            }
        });
    }
}
