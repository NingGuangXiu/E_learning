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

import com.example.e_learning.adapters.ChapterViewAdapter;
import com.example.e_learning.adapters.CourseViewAdapter;
import com.example.e_learning.beans.Datas;
import com.example.e_learning.beans.ItemBeam1;

import java.util.ArrayList;
import java.util.List;

public class book extends AppCompatActivity {

    private RecyclerView chapter_list;
    private List<ItemBeam1> cpData;
    private ChapterViewAdapter cpadapter;
    TextView _book_name;
    TextView _book_publisher;
    TextView _book_author;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        _book_name=(TextView) findViewById(R.id.book_name);
        _book_publisher=(TextView)findViewById(R.id.book_publisher);
        _book_author=(TextView)findViewById(R.id.book_author);
        imageView=(ImageView)findViewById(R.id.book_icon);


        final Intent intent = getIntent();//获取intent对象
        Bundle bundle = intent.getExtras();//获取传递的数据包
        bundle.getString("name");
        bundle.getString("publisher");
        bundle.getString("author");

        _book_name.setText(bundle.getString("name"));
        _book_publisher.setText(bundle.getString("publisher"));
        _book_author.setText(bundle.getString("author"));
//        imageView.setImageResource(Datas.icons[]);


        //找到控件
        chapter_list = this.findViewById(R.id.book_chapter_list);
        //准备数据
        initData();
        //设置默认的显示样式为ListView的效果
        showList(true, false);

        Button shoucang = null;
        shoucang = (Button)findViewById(R.id.shoucang_book);
        shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.setClass(book.this,my_book.class);
                startActivity(intent1);
            }
        });

    }
    //这个方法用于初始化数据
    private void initData() {

        //创建数据组合
        cpData = new ArrayList<>();

        for (int i = 0; i < Datas.Chapter_list.length; i++) {
            //创建数据对象
            ItemBeam1 data = new ItemBeam1();
            data.Chapter_Name = Datas.Chapter_list[i];
            //添加到集合里头
            cpData.add(data);
        }
    }

    private void initListener(){
        cpadapter.setOnItemClickListener(new ChapterViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {

                int key;
                key = position + 1;

                //这里处理条目的点击事件，该干嘛干嘛，跳转的就跳转...
                Toast.makeText(book.this,"你点击的是第" + key + "个条目",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent = new Intent(book.this,book_content.class);




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

        chapter_list.setLayoutManager(layoutManager);
        //创建适配器
        cpadapter = new ChapterViewAdapter(cpData);
        //设置到RecyclerView里头
        chapter_list.setAdapter(cpadapter);

        //初始化事件
        initListener();

    }
}
