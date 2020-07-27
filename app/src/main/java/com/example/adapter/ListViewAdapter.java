package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androiddemo.R;
import com.example.model.ListData;

public class ListViewAdapter extends BaseAdapter {
    private ListData<String> listData = null;
    private LayoutInflater li = null;
    private View layout = null;
    public ListViewAdapter(ListData<String> list, Context ctx){
        li = LayoutInflater.from(ctx);
        listData = list;
    }
    public void add(){
        listData.add("列表项" + listData.getSize());
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return listData.getSize();
    }

    @Override
    public Object getItem(int i) {
        return listData.getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh = null;
        if(view != null){
            vh = (ViewHolder)view.getTag();
            vh.tv.setText(listData.getItem(i));
        }else{
            view = li.inflate(R.layout.list_item,null);
            vh = new ViewHolder();
            vh.tv = view.findViewById(R.id.title);
            vh.tv.setText(listData.getItem(i));
            view.setTag(vh);
        }
        return view;
    }

    class ViewHolder{
        TextView tv = null;
    }
}
