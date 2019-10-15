package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class personal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        Button button9=null;
        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(personal.this , course.class);
                startActivity(intent);
            }

        });

        Button button10=null;
        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(personal.this , search.class);
                startActivity(intent);
            }

        });

        Button button11=null;
        button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(personal.this , personal.class);
                startActivity(intent);
            }

        });

    }
}
