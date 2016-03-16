package com.example.administrator.jsongson.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.jsongson.R;
import com.example.administrator.jsongson.bean.Tag;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/16.
 */
public class TagListAdapter extends BaseAdapter {

    private Context c;
    private ArrayList<Tag> list;

    public TagListAdapter(Context c, ArrayList<Tag> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (holder == null){
            convertView = View.inflate(c, R.layout.tag_item_list,null);
            //实例化holder
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.tv);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Tag tag = list.get(position);
        holder.tv.setText(tag.getTitle()+"\n"+tag.getCount());
        return convertView;
    }

    class ViewHolder{
        TextView tv;
    }
}
