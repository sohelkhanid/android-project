package com.monir.searchmistry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sohel on 3/23/2018.
 */

public class CustomAddapter extends BaseAdapter {
    int[] mistryType;
    String[] mistry;
    Context context;
    private LayoutInflater inflater;

    CustomAddapter(Context context,String[] mistry,int[] mistryType){
        this.context=context;
        this.mistry=mistry;
        this.mistryType=mistryType;

    }

    @Override
    public int getCount() {
        return mistry.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.mistry,parent,false);
        }
       ImageView imageView=(ImageView) convertView.findViewById(R.id.imageViewIdMistryType);
        TextView textView=(TextView) convertView.findViewById(R.id.mistryTextViewId);

        imageView.setImageResource(mistryType[position]);

        textView.setText(mistry[position]);
        return convertView;
    }
}
