package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androiddemo.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class PagerViewAdapter extends PagerAdapter {
    LayoutInflater li = null;
    Context ctx = null;
    int[] arr = {1,2,3};
    public PagerViewAdapter(Context ctx){
        this.ctx = ctx;
        li = LayoutInflater.from(ctx);
    }
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View item = li.inflate(R.layout.view_pager_item,null);
        TextView name =  item.findViewById(R.id.pagerName);
        name.setText("轮播" + String.valueOf(position));
        container.addView(item);
        return item;
    }

    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
