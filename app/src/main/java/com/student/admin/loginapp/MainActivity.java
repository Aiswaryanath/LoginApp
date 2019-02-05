package com.student.admin.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    String getusername,getpassword,getid,retrievepassword;
    Button b,b1;
    Databasehelper databasehelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed1 = (EditText) findViewById(R.id.username);
        ed2 = (EditText) findViewById(R.id.password);
        databasehelper=new Databasehelper(this);
        databasehelper.getWritableDatabase();
        b = (Button) findViewById(R.id.login);
        b1=(Button)findViewById(R.id.register) ;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getusername = ed1.getText().toString();
                getpassword = ed2.getText().toString();
                Log.d("username", getusername);
                Log.d("password", getpassword);


                Cursor cursor = databasehelper.SearchData(getusername);
                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No Name Found", Toast.LENGTH_LONG).show();
                } else {
                    while (cursor.moveToNext()) {
                        retrievepassword = cursor.getString(5);

                        getid = cursor.getString(0);
                        Toast.makeText(getApplicationContext(), getid, Toast.LENGTH_LONG).show();
                        getusername=cursor.getString(4);
                        if(retrievepassword.equals(getpassword))
                        {
                       Intent i=new Intent(getApplicationContext(),DisplayActivity.class);
                            startActivity(i);
                            SharedPreferences.Editor editor=getSharedPreferences("mydata",MODE_PRIVATE).edit();
                            editor.putString("username",getusername);
                            editor.apply();


                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_LONG).show();
                        }
                    }
                }


            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
