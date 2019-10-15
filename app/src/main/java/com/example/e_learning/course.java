package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

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
}
