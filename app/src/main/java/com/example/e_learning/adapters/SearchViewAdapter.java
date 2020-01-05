package com.example.e_learning.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_learning.R;
import com.example.e_learning.beans.ItemBeam2;

import java.util.List;

/*
* 从搜索列表跳转到书本具体内容页，是搜索列表的adapter
* */

public class SearchViewAdapter extends RecyclerView.Adapter<SearchViewAdapter.InnerHolder> {

    private final List<ItemBeam2> sData;
    private OnItemClickListener sOnItemClickListener;
    public SearchViewAdapter(List<ItemBeam2> Data) {
        this.sData = Data;
    }

    @NonNull
    @Override
    public SearchViewAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //传进去的view是条目的界面
        //两个步骤
        //1、拿到view
        //2、创建InnerHolder
        View view = View.inflate(parent.getContext(), R.layout.item_searchlist_view,null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(InnerHolder holder, int position){
        //在这里设置数据
        holder.setData(sData.get(position),position);
    }

    //返回条目个数
    @Override
    public int getItemCount(){
        if(sData != null){
            return sData.size();
        }
        return 0;
    }

    public interface OnItemClickListener {
        void OnItemClick( int position );

    }

    public void setOnItemClickListener( OnItemClickListener listener){
        //设置一个监听，其实，就是要设置一个接口，一个回调的接口
        this.sOnItemClickListener = listener;
    }

    public  class InnerHolder extends RecyclerView.ViewHolder{
        private ImageView sIcon;
        private TextView book;
        private  TextView sSchool;
        private int sPosition;


        //这个方法用于设置数据
        public  void setData(ItemBeam2 itemBeam, int position){

            sPosition = position;

            //开始设置数据
            sIcon.setImageResource(itemBeam.icon);
            book.setText(itemBeam.book);
            sSchool.setText(itemBeam.school);
        }

        public InnerHolder(View itemView){
            super(itemView);

            //找到条目的控件
            sIcon = itemView.findViewById(R.id.search_list_view_icon);
            book = itemView.findViewById(R.id.search_list_view_title) ;
            sSchool = itemView.findViewById(R.id.search_list_view_school);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (sOnItemClickListener != null) {
                        sOnItemClickListener.OnItemClick(sPosition);
                    }
                }
            });
        }
    }

}
