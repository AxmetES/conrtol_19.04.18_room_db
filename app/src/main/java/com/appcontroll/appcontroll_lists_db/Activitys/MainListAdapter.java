package com.appcontroll.appcontroll_lists_db.Activitys;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;
import com.appcontroll.appcontroll_lists_db.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder>{
    List<EntityItemList> entityItemLists;

    public MainListAdapter(List<EntityItemList> entityItemLists) {
        this.entityItemLists = entityItemLists;
    }

    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ltem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainListAdapter.ViewHolder holder, int position) {
        holder.listName.setText(entityItemLists.get(position).getListName());
    }

    @Override
    public int getItemCount() {
        return entityItemLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView listName;
        public ViewHolder(View itemView) {
            super(itemView);
            listName = itemView.findViewById(R.id.ma_list_tw);
        }
    }
}
