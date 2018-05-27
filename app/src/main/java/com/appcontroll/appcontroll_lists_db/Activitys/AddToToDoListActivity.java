package com.appcontroll.appcontroll_lists_db.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;
import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;
import com.appcontroll.appcontroll_lists_db.R;

public class AddToToDoListActivity extends AppCompatActivity {

    Button addBtn,deleteBtn;
    EditText editText;
    EditText etDoListName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_to_do_list);
        setTitle("Add to Do List");

        etDoListName = (EditText)findViewById(R.id.add_edit_toDolist);
        addBtn = (Button)findViewById(R.id.add_tolist_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String toDoListName = etDoListName.getText().toString();

                TodoList todoList = new TodoList();
                todoList.setToDoText(toDoListName);

                EntityItemListDB.getAppDB(getApplicationContext()).getDoListDao().insertAll(todoList);
                todoList.setToDoText("");

                startActivity(new Intent(AddToToDoListActivity.this, MainActivity.class));
            }
        });
    }
}