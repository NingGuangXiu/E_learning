package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.e_learning.adapters.CourseViewAdapter;
import com.example.e_learning.adapters.MyCourseViewAdapter;
import com.example.e_learning.beans.Datas;
import com.example.e_learning.beans.ItemBeam;

import java.util.ArrayList;
import java.util.List;

public class my_course extends AppCompatActivity {


    private RecyclerView course_list;
    private List<ItemBeam> mData;
    private MyCourseViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_course);


        //找到控件
        course_list=(RecyclerView)this.findViewById(R.id.course_list_view);



        //准备数据
        initData();

        //设置默认的显示样式为ListView的效果
        showList(true, false);
    }


    //这个方法用于初始化数据
    private void initData(){

        //创建数据组合
        mData=new ArrayList<>();

        for (int i = 0; i< Datas.icons.length;){
            //创建数据对象
            ItemBeam data = new ItemBeam();
            data.icon = Datas.icons[i];
            data.title = Datas.titles[i];
            data.school = Datas.schools[i];
            //添加到集合里头
            mData.add(data);
            i=i+2;
        }

    }



    private void initListener(){
        adapter.setOnItemClickListener(new MyCourseViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {


                int key;
                key = position + 1;

                //这里处理条目的点击事件，该干嘛干嘛，跳转的就跳转...
//                Toast.makeText(my_course.this,"你点击的是第" + key + "个条目",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(my_course.this,lesson.class);

                Bundle bundle = new Bundle();
                bundle.putString("icon","@drawable/android");
                bundle.putString("name","安卓移动开发");
                bundle.putString("school","北京交通大学");
                bundle.putString("teacher","曾立刚");
                bundle.putString("introduction","Android是一种基于Linux的自由及开放源代码的操作系统，Android 分为四个层，从高层到低层分别是应用程 序层、应用程序框架层、系统运行库层和 Linux 内核层。谷歌公司推出了开源的Android 系统，现在应用非常广泛，开发环境不会受到各种条条框框的限制，开发者任意修改开放的源代码来实现与开发各种实用的手机App软件，具有高级图形显示、界面友好等特点。");
                bundle.putString("time","2019-07-28");
                intent.putExtras(bundle);


             if (key==2){
                    bundle.putString("icon","@drawable/sql");
                    bundle.putString("name","数据库系统");
                    bundle.putString("school","南京");
                    bundle.putString("teacher","李恩斯");
                    bundle.putString("introduction","数据库系统的个体含义是指一个具体的数据库管理系统软件和用它建立起来的数据库；它的学科含义是指研究、开发、建立、维护和应用数据库系统所涉及的理论、方法、技术所构成的学科。在这一含义下，数据库系统是软件研究领域的一个重要分支，常称为数据库领域。");
                    bundle.putString("time","2019-02-18");
                    intent.putExtras(bundle);
                }
                else if (key==3){
                    bundle.putString("icon","@drawable/os");
                    bundle.putString("name","操作系统");
                    bundle.putString("school","清华大学");
                    bundle.putString("teacher","赵芳");
                    bundle.putString("introduction","操作系统是管理计算机硬件与软件资源的计算机程序，同时也是计算机系统的内核与基石。操作系统需要处理如管理与配置内存、决定系统资源供需的优先次序、控制输入设备与输出设备、操作网络与管理文件系统等基本事务。操作系统也提供一个让用户与系统交互的操作界面。");
                    bundle.putString("time","2018-10-02");
                    intent.putExtras(bundle);
                }

                startActivity(intent);
            }
        });
    }


    private void showList(boolean isVertical,boolean isReverse){

        //RecyclerView需要设置样式，其实就是设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器来控制设置水平还是垂直
        layoutManager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        //设置标准（正向）还是方向的
        layoutManager.setReverseLayout(isReverse);

        course_list.setLayoutManager(layoutManager);
        //创建适配器
        adapter = new MyCourseViewAdapter(mData);
        //设置到RecyclerView里头
        course_list.setAdapter(adapter);

        //初始化事件
        initListener();

    }

}
