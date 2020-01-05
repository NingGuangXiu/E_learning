package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_learning.adapters.CatalogViewAdapter;
import com.example.e_learning.beans.Datas;
import com.example.e_learning.beans.ItemBean2;

import java.util.ArrayList;
import java.util.List;

public class lesson extends AppCompatActivity {



    private RecyclerView catalog_list;
    private List<ItemBean2> cData;
    private CatalogViewAdapter cadapter;
    ImageView imageView;
    TextView course_name;
    TextView course_school;
    TextView course_teacher_name;
    TextView course_introduction;
    TextView course_start_time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Intent intent = getIntent();//获取intent对象
        Bundle bundle = intent.getExtras();//获取传递的数据包
        bundle.getString("icon");
        bundle.getString("name");
        bundle.getString("school");
        bundle.getString("teacher");
        bundle.getString("introduction");
        bundle.getString("time");



        //找到控件
        catalog_list=this.findViewById(R.id.lesson_catalog);
        //准备数据
        initData();
        //设置默认的显示样式为ListView的效果
        showList(true, false);

        imageView=(ImageView)findViewById(R.id.lesson_icon);
        course_name=(TextView) findViewById(R.id.lesson_name);
        course_school=(TextView)findViewById(R.id.lesson_school);
        course_teacher_name=(TextView)findViewById(R.id.lesson_teacher_name);
        course_introduction=(TextView)findViewById(R.id.lesson_introduction);
        course_start_time=(TextView)findViewById(R.id.lesson_start_time);

        imageView.setImageResource(Datas.icons[1]);
        course_name.setText(bundle.getString("name"));
        course_school.setText(bundle.getString("school"));
        course_teacher_name.setText(bundle.getString("teacher"));
        course_introduction.setText(bundle.getString("introduction"));
        course_start_time.setText(bundle.getString("time"));

        if (bundle.getString("name").equals("安卓移动开发")){
            imageView.setImageResource(Datas.icons[0]);
        }
        else if (bundle.getString("name").equals("商务英语")){
            imageView.setImageResource(Datas.icons[1]);
        }
        else if (bundle.getString("name").equals("数据库系统")){
            imageView.setImageResource(Datas.icons[2]);
        }
        else if (bundle.getString("name").equals("计算机网络")){
            imageView.setImageResource(Datas.icons[3]);
        }
        else if (bundle.getString("name").equals("操作系统")){
            imageView.setImageResource(Datas.icons[4]);
        }
        else if (bundle.getString("name").equals("web开发")){
            imageView.setImageResource(Datas.icons[5]);
        }

        Button add_lesson = null;
        add_lesson = (Button) findViewById(R.id.join_lesson);
        add_lesson.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(lesson.this , my_course.class);
                startActivity(intent);
            }

        });


    }

    //这个方法用于初始化数据
    private void initData() {

        //创建数据组合
        cData = new ArrayList<>();

        for (int i = 0; i < Datas.Catalog_Name.length; i++) {
            //创建数据对象
            ItemBean2 data = new ItemBean2();
            data.Name = Datas.Catalog_Name[i];
            //添加到集合里头
            cData.add(data);
        }
    }

    private void initListener(){
        cadapter.setOnItemClickListener(new CatalogViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {

                int key;
                key = position + 1;

                //这里处理条目的点击事件，该干嘛干嘛，跳转的就跳转...
                Toast.makeText(lesson.this,"你点击的是第" + key + "个条目",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(lesson.this,charter.class);

                intent.putExtra("chapter_name","CHAPTER" + key);

//                if(key==1){
//                    intent.putExtra("chapter_name","CHAPTER2");
//                }
//
//                else if(key==2){
//                    intent.putExtra("chapter_name","CHAPTER3");
//                }
//                else if (key==3){
//                    intent.putExtra("chapter_name","CHAPTER4");
//                }


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

        catalog_list.setLayoutManager(layoutManager);
        //创建适配器
        cadapter = new CatalogViewAdapter(cData);
        //设置到RecyclerView里头
        catalog_list.setAdapter(cadapter);

        //初始化事件
        initListener();

    }

}
