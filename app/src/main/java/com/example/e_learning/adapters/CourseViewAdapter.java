package com.example.e_learning.adapters;

import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.e_learning.R;
import com.example.e_learning.beans.ItemBeam;

import java.util.List;

/*
* 从课程列表跳到该课程的具体内容页面，是课程列表的adapter
* */

public class CourseViewAdapter extends RecyclerView.Adapter<CourseViewAdapter.InnerHolder> {

    private final List<ItemBeam> mData;
    private OnItemClickListener mOnItemClickListener;


    public CourseViewAdapter(List<ItemBeam> data){
        this.mData = data;
    }

    //这个方法用于创建条目View
    @NonNull
    @Override
    public CourseViewAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //传进去的view是条目的界面
        //两个步骤
        //1、拿到view
        //2、创建InnerHolder
        View view = View.inflate(parent.getContext(),R.layout.item_courselist_view,null);
        return new InnerHolder(view);
    }


    //这个方法是用于绑定holder的，一般用来设置数据
    @Override
    public void onBindViewHolder(InnerHolder holder,int position){
          //在这里设置数据
//        holder.setData(mData.get(position),position);


        holder.setData(mData.get(position),position);


//        if (mOnItemClickListener != null)
//        {
//            holder.itemView.setOnClickListener(new OnClickListener()
//            {
//                @Override
//                public void onClick(View v)
//                {
//                    int pos = holder.getLayoutPosition();
//                    mOnItemClickListener.onItemClick(holder.itemView, pos);
//                }
//            });
//        }
    }

    //返回条目个数
    @Override
    public int getItemCount(){
        if(mData != null){
            return mData.size();
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
        this.mOnItemClickListener = listener;
    }


    public  class InnerHolder extends RecyclerView.ViewHolder{
        private  ImageView mIcon;
        private  TextView mtitle;
        private  TextView mSchool;
        private int mPosition;

        //这个方法用于设置数据
        public  void setData(ItemBeam itemBeam,int position){

            mPosition = position;

            //开始设置数据
            mIcon.setImageResource(itemBeam.icon);
            mtitle.setText(itemBeam.title);
            mSchool.setText(itemBeam.school);
        }

        public InnerHolder(View itemView){
            super(itemView);

            //找到条目的控件
             mIcon = itemView.findViewById(R.id.course_list_view_icon);
             mtitle = itemView.findViewById(R.id.course_list_view_title) ;
             mSchool = itemView.findViewById(R.id.course_list_view_school);


             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if (mOnItemClickListener != null) {
                         mOnItemClickListener.OnItemClick(mPosition);
                     }
                 }
             });
        }




    }


}
