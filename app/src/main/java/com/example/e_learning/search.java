package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


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
    }
}
