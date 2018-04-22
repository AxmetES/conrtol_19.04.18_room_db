package com.appcontroll.appcontroll_lists_db.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.appcontroll.appcontroll_lists_db.R;

public class AddToMainListActivity extends AppCompatActivity implements View.OnClickListener {
    Button addBtn, deleteBtn;
    EditText etListName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_main_list);
        setTitle("Add to list");

        addBtn = (Button)findViewById(R.id.add_tolist_btn);
        addBtn.setOnClickListener(this);
        deleteBtn = (Button)findViewById(R.id.delete_tolist_btn);
        deleteBtn.setOnClickListener(this);

        etListName = (EditText)findViewById(R.id.add_edit_tolist);


    }

    @Override
    public void onClick(View v) {
        String listName  = etListName.getText().toString();

        switch (v.getId()){
            case R.id.add_tolist_btn:
            //todo
                break;
            case R.id.delete_tolist_btn:
                //todo
                break;
        }

    }
}
