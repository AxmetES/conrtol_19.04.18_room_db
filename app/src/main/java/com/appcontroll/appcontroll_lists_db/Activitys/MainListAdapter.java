package com.appcontroll.appcontroll_lists_db.Activitys;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontroll.appcontroll_lists_db.EntityItemListDB;
import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;
import com.appcontroll.appcontroll_lists_db.R;

import java.util.List;

class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder>{
    private final Context context;
    private List<EntityItemList> entityItemLists;

    public MainListAdapter(Context context, List<EntityItemList> entityItemLists) {
        this.context = context;
        this.entityItemLists = entityItemLists;
    }

    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ltem_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MainListAdapter.ViewHolder holder, final int position) {
        final EntityItemList entityRowName = entityItemLists.get(position);

        holder.listName.setText(entityItemLists.get(position).getListName());
        holder.listName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("ListName", entityRowName.getListName());
                context.startActivity(intent);
            }
        });
        holder.listMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context,holder.listMenuBtn);
                popupMenu.inflate(R.menu.option_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        entityItemLists.remove(position);
                        EntityItemListDB.getAppDB(context).getEntityDao().delete(entityRowName);
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
        return entityItemLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView listName;
        public ImageButton listMenuBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            listName = itemView.findViewById(R.id.ma_list_tw);
            listMenuBtn = (ImageButton) itemView.findViewById(R.id.list_item);
        }
    }
}
