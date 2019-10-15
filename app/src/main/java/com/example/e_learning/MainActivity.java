package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button3=null;
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(MainActivity.this , login1.class);
                startActivity(intent);
            }

        });

        Button button4=null;
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(MainActivity.this , register1.class);
                startActivity(intent);
            }

        });

        Button button5=null;
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(MainActivity.this , course.class);
                startActivity(intent);
            }

        });


        Button button6=null;
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(MainActivity.this , course.class);
                startActivity(intent);
            }

        });

        Button button7=null;
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(MainActivity.this , course.class);
                startActivity(intent);
            }

        });

    }
}
