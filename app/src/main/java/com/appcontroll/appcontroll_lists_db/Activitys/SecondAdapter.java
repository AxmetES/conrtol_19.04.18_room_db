package com.appcontroll.appcontroll_lists_db.Activitys;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.SupportActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;
import com.appcontroll.appcontroll_lists_db.R;

import java.util.List;

class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder>{
    private List<TodoList> todoLists;
    private Context context;
    FloatingActionButton fab;


    public SecondAdapter(List<TodoList> todoLists, Context context) {
        this.todoLists = todoLists;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_details_rv,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TodoList todoList = todoLists.get(position);
        holder.dl_text.setText(todoList.getToDoText());
        holder.dl_date_text.setText((CharSequence) todoList.getTodoDate());
        holder.dl_date_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    @Override
    public int getItemCount() {
       return todoLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView dl_text,dl_date_text;

        public ViewHolder(View itemView) {
            super(itemView);
            dl_text = (TextView) itemView.findViewById(R.id.dl_text);
            dl_date_text = (TextView) itemView.findViewById(R.id.dl_date_text);
        }
    }
}
