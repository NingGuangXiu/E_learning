package com.example.e_learning.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.beans.ItemBeam1;

import java.util.List;
/*
* adapter:从书的章节跳到书的每一章节的具体内容，是书本章节列表的adapter
* */
public class ChapterViewAdapter extends RecyclerView.Adapter<ChapterViewAdapter.InnerHolder> {

    private final List<ItemBeam1> cpData;
    private OnItemClickListener cpOnItemClickListener;


    public ChapterViewAdapter(List<ItemBeam1> cpData) {
        this.cpData = cpData;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.item_booklist_view,null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(cpData.get(position),position);

    }

    @Override
    public int getItemCount() {
        if (cpData != null){
            return cpData.size();
        }
        return 0;
    }

    //编写回调的步骤
    //1、创建这个接口
    //2、定义接口内部的方法
    //3、提供设置接口的方法（其实是外部实现）
    //4、接口方法的调用


    public interface OnItemClickListener {
        void OnItemClick( int position );

    }

    public void setOnItemClickListener( OnItemClickListener listener){
        //设置一个监听，其实，就是要设置一个接口，一个回调的接口
        this.cpOnItemClickListener = listener;
    }


    public class InnerHolder extends RecyclerView.ViewHolder {

        private TextView chapter_name;
        private int cpPosition;

        //这个方法用于设置数据
        public  void setData(ItemBeam1 itemBeam,int position){

            cpPosition = position;

            //开始设置数据
            chapter_name.setText(itemBeam.Chapter_Name);
        }

        public InnerHolder(@NonNull View itemView) {
            super(itemView);

            chapter_name = itemView.findViewById(R.id.book_chapter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cpOnItemClickListener != null){
                        cpOnItemClickListener.OnItemClick(cpPosition);
                    }
                }
            });
        }
    }
}
