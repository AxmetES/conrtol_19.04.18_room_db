package com.appcontroll.appcontroll_lists_db.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.TodoList;
import com.appcontroll.appcontroll_lists_db.R;

import java.util.List;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder>{
    private final Context context;
    private List<TodoList> todoLists;



    public SecondAdapter(Context context, List<TodoList> todoLists) {
        this.context = context;
        this.todoLists = todoLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_details_rv,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final TodoList todoList = todoLists.get(position);
        holder.dl_text.setText(todoList.getToDoText());
        holder.dl_date.setText(todoList.getTodoDate());
        holder.dl_detail_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,holder.dl_detail_item);
                popupMenu.inflate(R.menu.option_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        todoLists.remove(position);
                        EntityItemListDB.getAppDB(context).getDoListDao().delete(todoList);
                        notifyDataSetChanged();
                        Toast.makeText(context,"list deleted", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
       return todoLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView dl_text;
        public TextView dl_date;
        public ImageButton dl_detail_item;


        public ViewHolder(View itemView) {
            super(itemView);
            dl_text = (TextView) itemView.findViewById(R.id.dl_text);
            dl_date = (TextView) itemView.findViewById(R.id.dl_date);
            dl_detail_item = (ImageButton)itemView.findViewById(R.id.dl_detail_item);

        }
    }
}
