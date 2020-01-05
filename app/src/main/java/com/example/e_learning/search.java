package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_learning.adapters.SearchViewAdapter;
import com.example.e_learning.beans.Datas;
import com.example.e_learning.beans.ItemBeam2;
import com.example.e_learning.course_info.course_info;

import java.util.ArrayList;
import java.util.List;


public class search extends AppCompatActivity {

    private RecyclerView seache_list ;
    List<ItemBeam2> sData;
    private SearchViewAdapter sadapter;
    EditText search_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        //找到控件
        seache_list=this.findViewById(R.id.search_list_view);
        search_content = (EditText)findViewById(R.id.search_text);
        //准备数据
        initData();

        //设置默认的显示样式为ListView的效果
        showList(true, false);

        Button button18=null;
        button18 = (Button) findViewById(R.id.button18);
        button18.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(search.this , course.class);
                startActivity(intent);
            }

        });

        Button button19=null;
        button19 = (Button) findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(search.this , search.class);
                startActivity(intent);
            }

        });

        Button button20=null;
        button20 = (Button) findViewById(R.id.button20);
        button20.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(search.this , personal.class);
                startActivity(intent);
            }

        });

        Button button_1=null;
        button_1 = (Button)findViewById(R.id.search_button);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String content = search_content.getText().toString().trim();
                boolean flag = false;

                for(int i = 0; i <Datas.books.length; i++){
                    if (content.equals(Datas.books[i])){

                        Intent intent = new Intent();
                        intent.setClass(search.this , book.class);
//                        String name;
//                        String  publisher;
//                        String author;

                        Bundle bundle = new Bundle();
                        bundle.putString("name",Datas.books[i]);
                        bundle.putString("publisher",Datas.publisher[i]);
                        bundle.putString("author",Datas.author[i]);

                        intent.putExtras(bundle);
                        startActivity(intent);
                        flag = false;
                        break;
                    }
                    else {
                        flag = true;
                    }
                }



                if (flag){
                    Toast.makeText(search.this,"没有这本书!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //这个方法用于初始化数据
    private void initData(){

        //创建数据组合
        sData=new ArrayList<>();

        for (int i = 0; i< Datas.book_icon.length; i++){
            //创建数据对象
            ItemBeam2 data = new ItemBeam2();
            data.icon = Datas.book_icon[i];
            data.book = Datas.books[i];
            data.school = Datas.publisher[i];
            //添加到集合里头
            sData.add(data);
        }


//        //RecyclerView需要设置样式，其实就是设置布局管理器
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        seache_list.setLayoutManager(layoutManager);
//
//        //创建适配器
//        SearchViewAdapter adapter = new SearchViewAdapter(sData);
//        //设置到RecyclerView里头
//        seache_list.setAdapter(adapter);
    }

    private void initListener(){
        sadapter.setOnItemClickListener(new SearchViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {

                int key;
                key = position + 1;

                //这里处理条目的点击事件，该干嘛干嘛，跳转的就跳转...
//                Toast.makeText(search.this,"你点击的是第" + key + "个条目",Toast.LENGTH_SHORT).show();
                Intent  intent = new Intent(search.this,book.class);

                Bundle bundle = new Bundle();
                bundle.putString("name",Datas.books[0]);
                bundle.putString("publisher",Datas.publisher[0]);
                bundle.putString("author",Datas.author[0]);
                intent.putExtras(bundle);

                for (int i=0;i<Datas.books.length;i++){
                    if(key==i){
                        bundle.putString("name",Datas.books[key-1]);
                        bundle.putString("publisher",Datas.publisher[key-1]);
                        bundle.putString("author",Datas.author[key-1]);
                        intent.putExtras(bundle);
                    }
                }
//
//                if(key==2){
//                    bundle.putString("name",Datas.books[1]);
//                    bundle.putString("publisher",Datas.publisher[1]);
//                    bundle.putString("author",Datas.author[1]);
//                    intent.putExtras(bundle);
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

        seache_list.setLayoutManager(layoutManager);
        //创建适配器
        sadapter = new SearchViewAdapter(sData);
        //设置到RecyclerView里头
        seache_list.setAdapter(sadapter);

        //初始化事件
        initListener();

    }
}
