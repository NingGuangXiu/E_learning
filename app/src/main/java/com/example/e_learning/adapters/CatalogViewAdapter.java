package com.example.e_learning.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.beans.ItemBean2;

import java.util.List;

/*
* 从课程大纲的教程列表跳到该教程的具体内容页，是教程列表的adapter
* */

public class CatalogViewAdapter extends RecyclerView.Adapter<CatalogViewAdapter.InnerHolder> {

    private final List<ItemBean2> cData;
    private OnItemClickListener  cOnItemClickListener;

    public CatalogViewAdapter(List<ItemBean2> cData) {
        this.cData = cData;
    }


    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //传进去的view是条目的界面
        //两个步骤
        //1、拿到view
        //2、创建InnerHolder
        View view = View.inflate(parent.getContext(), R.layout.item_lessoncatalog_view,null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
         //在这里设置数据
        holder.setData(cData.get(position),position);
    }

    @Override
    public int getItemCount() {
        if(cData != null){
            return cData.size();
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
        this.cOnItemClickListener = listener;
    }




    public class InnerHolder extends RecyclerView.ViewHolder {

        private TextView cName;
        private int cPosition;

        //这个方法用于设置数据
        public  void setData(ItemBean2 itemBean2,int position){

            cPosition = position;

            //开始设置数据
            cName.setText(itemBean2.Name);
        }

        public InnerHolder(@NonNull View itemView) {
            super(itemView);

            //找到条目的控件
            cName = itemView.findViewById(R.id.catalog_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cOnItemClickListener != null) {
                        cOnItemClickListener.OnItemClick(cPosition);
                    }
                }
            });

        }
    }
}
