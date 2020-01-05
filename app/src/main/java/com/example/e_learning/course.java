package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_learning.adapters.CourseViewAdapter;
import com.example.e_learning.beans.Datas;
import com.example.e_learning.beans.ItemBeam;
import com.example.e_learning.course_info.course_info;

import java.util.ArrayList;
import java.util.List;

//import static com.example.e_learning.R.id.course_list_view;

public class course extends AppCompatActivity {

    private RecyclerView course_list;
    private List<ItemBeam> mData;
    private CourseViewAdapter adapter;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);


        //找到控件
        course_list=(RecyclerView)this.findViewById(R.id.course_list_view);



        //准备数据
        initData();

        //设置默认的显示样式为ListView的效果
        showList(true, false);



        Button button15=null;
        button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(course.this, course.class);
                startActivity(intent);
            }
        });


        Button button14=null;
        button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(course.this, search.class);
                startActivity(intent);
            }
        });


        Button button12=null;
        button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(course.this, personal.class);
                startActivity(intent);
            }
        });
    }

    //这个方法用于初始化数据
    private void initData(){

        //创建数据组合
        mData=new ArrayList<>();

        for (int i = 0; i< Datas.icons.length; i++){
            //创建数据对象
            ItemBeam data = new ItemBeam();
            data.icon = Datas.icons[i];
            data.title = Datas.titles[i];
            data.school = Datas.schools[i];
            //添加到集合里头
            mData.add(data);
        }

    }



    private void initListener(){
        adapter.setOnItemClickListener(new CourseViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {


                int key;
                key = position + 1;
                course_info course =new course_info();
//                String icon;
//                String name;
//                String  school;
//                String teacher;
//                String introduction;
//                String time;

                //这里处理条目的点击事件，该干嘛干嘛，跳转的就跳转...
                Toast.makeText(course.this,"你点击的是第" + key + "个条目",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(course.this,lesson.class);

                Bundle bundle = new Bundle();
                bundle.putString("icon","@drawable/android");
                bundle.putString("name","安卓移动开发");
                bundle.putString("school","北京交通大学");
                bundle.putString("teacher","曾立刚");
                bundle.putString("introduction","Android是一种基于Linux的自由及开放源代码的操作系统，Android 分为四个层，从高层到低层分别是应用程 序层、应用程序框架层、系统运行库层和 Linux 内核层。谷歌公司推出了开源的Android 系统，现在应用非常广泛，开发环境不会受到各种条条框框的限制，开发者任意修改开放的源代码来实现与开发各种实用的手机App软件，具有高级图形显示、界面友好等特点。");
                bundle.putString("time","2019-07-28");
                intent.putExtras(bundle);

                if(key==2){
                    bundle.putString("icon","@drawable/english");
                    bundle.putString("name","商务英语");
                    bundle.putString("school","北京理工大学");
                    bundle.putString("teacher","张益达");
                    bundle.putString("introduction","商务英语（BUSINESS ENGLISH ）是以适应职场生活的语言要求为目的，内容涉及到商务活动的方方面面。商务英语课程不只是简单地对学员的英文水平、能力的提高，它更多地是向学员传授一种西方的企业管理理念、工作心理，甚至是如何和外国人打交道，如何和他们合作、工作的方式方法，以及他们的生活习惯等，从某种程度上说是包含在文化概念里的。");
                    bundle.putString("time","2019-09-01");
                    intent.putExtras(bundle);
                }
                else if (key==3){
                    bundle.putString("icon","@drawable/sql");
                    bundle.putString("name","数据库系统");
                    bundle.putString("school","南京");
                    bundle.putString("teacher","李恩斯");
                    bundle.putString("introduction","数据库系统的个体含义是指一个具体的数据库管理系统软件和用它建立起来的数据库；它的学科含义是指研究、开发、建立、维护和应用数据库系统所涉及的理论、方法、技术所构成的学科。在这一含义下，数据库系统是软件研究领域的一个重要分支，常称为数据库领域。");
                    bundle.putString("time","2019-02-18");
                    intent.putExtras(bundle);
                }
                else if (key==4){
                    bundle.putString("icon","@drawable/computer");
                    bundle.putString("name","计算机网络");
                    bundle.putString("school","广西大学");
                    bundle.putString("introduction","计算机网络也称计算机通信网。关于计算机网络的最简单定义是：一些相互连接的、以共享资源为目的的、自治的计算机的集合。若按此定义，则早期的面向终端的网络都不能算是计算机网络，而只能称为联机系统（因为那时的许多终端不能算是自治的计算机）。但随着硬件价格的下降，许多终端都具有一定的智能，因而“终端”和“自治的计算机”逐渐失去了严格的界限。若用微型计算机作为终端使用，按上述定义，则早期的那种面向终端的网络也可称为计算机网络。");
                    bundle.putString("time","2019-05-23");
                    bundle.putString("teacher","王易凯");
                    intent.putExtras(bundle);
                }
                else if (key==5){
                    bundle.putString("icon","@drawable/os");
                    bundle.putString("name","操作系统");
                    bundle.putString("school","清华大学");
                    bundle.putString("teacher","赵芳");
                    bundle.putString("introduction","操作系统是管理计算机硬件与软件资源的计算机程序，同时也是计算机系统的内核与基石。操作系统需要处理如管理与配置内存、决定系统资源供需的优先次序、控制输入设备与输出设备、操作网络与管理文件系统等基本事务。操作系统也提供一个让用户与系统交互的操作界面。");
                    bundle.putString("time","2018-10-02");
                    intent.putExtras(bundle);
                }
                else if (key==6){
                    bundle.putString("icon","@drawable/web");
                    bundle.putString("name","web开发");
                    bundle.putString("school","上海交通大学");
                    bundle.putString("teacher","高源");
                    bundle.putString("introduction","Web技术涉及的内容相当广泛，本书涵盖了其中诸多方面，如：HTML标识语言、Java、Applet、CGI、脚本语言、ASP和JSP技术等。本书取材得当、覆盖面广、实例丰富、图文并茂，既可作为计算机专业本、专科学生学习和掌握Web技术的教科书，也可以作为广大 Web技术爱好者学习和应用Web技术的参考书，同时也有一些web开发技术的网站有时间去看看。");
                    bundle.putString("time","2019-12-31");
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
        adapter = new CourseViewAdapter(mData);
        //设置到RecyclerView里头
        course_list.setAdapter(adapter);

        //初始化事件
        initListener();

    }

}
