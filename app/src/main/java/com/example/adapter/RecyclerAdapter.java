package com.example.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androiddemo.R;
import com.example.model.ListData;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ListData<String> listData = null;

    public RecyclerAdapter(ListData<String> list){
        listData = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View view = null;
        public TextView tv = null;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            tv = itemView.findViewById(R.id.title);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(listData.getItem(position));
    }

    @Override
    public int getItemCount() {
        return listData.getSize();
    }
}
