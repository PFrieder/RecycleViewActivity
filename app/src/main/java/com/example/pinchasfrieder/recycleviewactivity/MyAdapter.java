package com.example.pinchasfrieder.recycleviewactivity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Pinchas Frieder on 6/24/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {


    private LayoutInflater inflater;
    View view;
    List<Info> data = Collections.emptyList();

    public MyAdapter(Context context, List<Info> data) {

        inflater = LayoutInflater.from(context);
        this.data = data;
        l();


    }

    public void l() {
        Log.d("a new MyAdapter object", "was invoked ");
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("onCreateViewHolder", "was invoked " + viewType);
        view = inflater.inflate(R.layout.row, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Log.d("onBindViewHolder", "was invoked " + position);
        Info current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
        if ((position + 1) % 3 == 0) {
            view.setBackgroundColor(Color.GREEN);
        } else if ((position + 1) % 3 == 1) {
            view.setBackgroundColor(Color.RED);
        } else view.setBackgroundColor(Color.BLUE);


    }

    @Override
    public int getItemCount() {
        Log.d("getItemCount", "was invoked " + data.size());
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;


        public MyHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textView);
            icon = (ImageView) itemView.findViewById(R.id.imageView);
            log();

        }

        public void log() {
            Log.d("a new MyHolder object", "was invoked ");
        }
    }
}

