package com.student.admin.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    String getname,getmobileno,getusername,getpassword,getemailid;
    Button b,b1;
    Databasehelper databasehelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.emailid);
        ed3 = (EditText) findViewById(R.id.mobileno);
        ed4 = (EditText) findViewById(R.id.username);
        ed5 = (EditText) findViewById(R.id.password);
        databasehelper=new Databasehelper(this);
        databasehelper.getWritableDatabase();
        b = (Button) findViewById(R.id.register);
        b1=(Button)findViewById(R.id.backtologin) ;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getname = ed1.getText().toString();
                getemailid = ed2.getText().toString();
                getmobileno = ed3.getText().toString();
                getusername = ed4.getText().toString();
                getpassword= ed5.getText().toString();
                Log.d("username",getusername);
                Log.d("password",getpassword);
                boolean status=databasehelper.insertData(getname,getmobileno,getemailid,getusername,getpassword);

                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"successfully inserted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });
    }
}
