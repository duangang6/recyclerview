package com.example.music0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, Object>> list;
    private OnItemClickListener mOnItemClickListener;

    public RecyclerViewAdapter(Context context, ArrayList<HashMap<String, Object>> list) {
        // 构造方法
        this.context = context;
        this.list = list;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建界面
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        // 创建内部类mViewHolder生成每一个节点包含的内容
        mViewHolder viewHolder = new mViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // 绑定节点position为序号
        ((mViewHolder)holder).imageView.setImageResource((Integer)list.get(position).get("img"));
        ((mViewHolder)holder).title.setText((String)list.get(position).get("title"));
        ((mViewHolder)holder).info.setText((String)list.get(position).get("info"));
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView, position); // 2
                }
            });
        }
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    private class mViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title, info;

        public mViewHolder(View view) {
            // 定义每一个节点包含的内容
            super(view);
            imageView =  view.findViewById(R.id.musictubiao);
            title=view.findViewById(R.id.musicbiaoti);
            info=view.findViewById(R.id.musicgeshou);
        }
    }
}