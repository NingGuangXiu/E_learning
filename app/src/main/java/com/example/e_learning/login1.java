package com.example.e_learning;

//import androidx.appcompat.app.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_learning.User.User;
import com.example.e_learning.beans.Datas;

public class login1 extends Activity {

    private EditText user_name;

    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        user_name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


        Button button = null;
                button = (Button) findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent;

                final String str = user_name.getText().toString().trim();
                final String str2 = password.getText().toString().trim();


                if (str.isEmpty()||str2.isEmpty()) {
                    showDialog_1();
                    return;
                }

                User user = new User();
                user.setId(str);
                user.setPassword(str2);
                boolean flag = false;

                for (int i = 0; i < Datas.User_id.length; i++){
                    if (user.getId().equals(Datas.User_id[i]) && user.getPassword().equals(Datas.User_password[i])){
                        flag = true;
                    }
                }
                if (flag){

                    intent = new Intent();
                    intent.setClass(login1.this, personal.class);
//                    Bundle bundle=new Bundle();
//                    bundle.putString("id",user.getId());
//                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(login1.this,"登录失败!",Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(login1.this,"登录成功!",Toast.LENGTH_SHORT).show();
//                else if (str.equals("ngx") && str2.equals("123456")){
//                    intent = new Intent();
//                    intent.setClass(login1.this, course.class);
//                    startActivity(intent);
//                }

            }

        });
    }

    private void showDialog_1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("提示");
        builder.setMessage("用户名或密码不能为空！");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }



}
