package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import com.example.e_learning.beans.Datas;

import java.util.Arrays;

public class register1 extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView password;
    private TextView confirm_psd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        name = findViewById(R.id.register_name);
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        confirm_psd = findViewById(R.id.register_con_psd);



        Button button2=null;
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                boolean flag = false;

                final String str = name.getText().toString().trim();
                final String str1 = email.getText().toString().trim();
                final String str2= password.getText().toString().trim();
                final String str3= confirm_psd.getText().toString().trim();

                if(str.isEmpty()){
                    showDialog_1();
                }
                else if(str1.isEmpty()){
                    showDialog_2();
                }
                else if(str2.isEmpty()){
                    showDialog_3();
                }
                else if(str3.isEmpty()){
                    showDialog_4();
                }




                for (int i = 0; i<Datas.User_id.length; i++){
                    if (str.equals(Datas.User_id[i])||str.equals("")||str1.equals("")||str2.equals("")||str3.equals("")){

//                        Toast.makeText(register1.this,"用户已存在",Toast.LENGTH_SHORT).show();
                        flag = false;
                        break;
                    }
                    else {
                        flag = true;
                    }


                }



                if (flag){
                        if (str2.equals(str3)) {
                            //执行注册操作
//                            SaveInfo.SaveInformation(RegisterActivity.this,username,password,password2,mail);
                            Toast.makeText(register1.this,"注册成功,请返回登录",Toast.LENGTH_SHORT).show();

                            Intent intent;
                            intent = new Intent();
                            intent.setClass(register1.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(register1.this, "两次输入的密码不一样", Toast.LENGTH_SHORT).show();
                        }

                }



//                intent=new Intent();
//                intent.setClass(register1.this , MainActivity.class);
//                startActivity(intent);
            }

        });
    }


    private void showDialog_1() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//        builder.setTitle("提示");
        builder1.setMessage("昵称不能为空！");
        builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder1.create();
        dialog.show();
    }

    private void showDialog_2() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//        builder.setTitle("提示");
        builder1.setMessage("邮箱不能为空！");
        builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder1.create();
        dialog.show();
    }

    private void showDialog_3() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//        builder.setTitle("提示");
        builder1.setMessage("密码不能为空！");
        builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder1.create();
        dialog.show();
    }
    private void showDialog_4() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//        builder.setTitle("提示");
        builder1.setMessage("确认密码不能为空！");
        builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder1.create();
        dialog.show();
    }

//    public String[] addDataToArray(String[] s,String newData)
//    {
//        s= Arrays.copyOf(s, s.length+1);
//        s[s.length-1]=newData;
//        return s;
//    }
}
