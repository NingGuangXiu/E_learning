package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class personal extends AppCompatActivity {

//    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
//
//        name=(TextView)findViewById(R.id.id);
//
//        Intent intent_content=getIntent();
//        Bundle bundle = intent_content.getExtras();
//        name.setText(bundle.getString("id"));

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

        Button button_course=null;
        button_course = (Button)findViewById(R.id.my_course);
        button_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(personal.this , my_course.class);
                startActivity(intent);

            }
        });

        Button button_books=null;
        button_books = (Button)findViewById(R.id.my_book);
        button_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(personal.this , my_book.class);
                startActivity(intent);

            }
        });
        Button button_exit=null;
        button_exit = (Button)findViewById(R.id.exit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(personal.this , MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
