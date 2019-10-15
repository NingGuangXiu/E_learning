package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class register1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);


        Button button2=null;
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

//                AlertDialog.Builder ab=new AlertDialog.Builder(this);  //(普通消息框)
//
//                     ab.setTitle("TextValue");  //设置标题
//                     ab.setIcon(R.Drawable);//设置图标
//                     ab.setMessage("Message");//设置消息内容
//                     ab.setPositiveButton("text",listenter);//设置确定按钮
//                     ab.setNegativeButton("取消",null);//设置取消按钮
//                     ab.setNeutralButton("其他"，null);
//                     ab.show();//显示弹出框

                Intent intent=new Intent();
                intent.setClass(register1.this , login1.class);
                startActivity(intent);
            }

        });
    }
}
