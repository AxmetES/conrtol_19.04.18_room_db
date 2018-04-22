package com.appcontroll.appcontroll_lists_db;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.TextView;

import com.appcontroll.appcontroll_lists_db.Activitys.SecondActivity;
import com.appcontroll.appcontroll_lists_db.Entitys.EntityItemList;

import java.util.List;

/**
 * Created by АхметжановЕ on 19.04.2018.
 */

public class ListAdaper extends RecyclerView.Adapter<ListAdaper.ViewHolder>{
    private final Context context;
    private final List<EntityItemList> listItems;

    public ListAdaper(Context context, List<EntityItemList> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.list_ltem,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdaper.ViewHolder holder, int position) {
        final EntityItemList entityItemList = listItems.get(position);
        holder.ma_list_tw.setText(entityItemList.getListName());
        holder.ma_list_tw.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("id", entityItemList.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView ma_list_tw;
         ViewHolder(View itemView) {
            super(itemView);
            ma_list_tw = itemView.findViewById(R.id.ma_list_tw);
        }
    }
}


