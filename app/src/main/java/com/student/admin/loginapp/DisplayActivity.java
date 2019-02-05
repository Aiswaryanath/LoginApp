package com.student.admin.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
TextView tv;
    Button b,b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        b = (Button) findViewById(R.id.profileedit);
        b1=(Button)findViewById(R.id.removeaccount) ;
        b2 = (Button) findViewById(R.id.logout);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        SharedPreferences sharedPreferences=getSharedPreferences("username",MODE_PRIVATE);
        String check=sharedPreferences.getString("username",null);
        if (check!=null)
        {
            Intent i=new Intent(getApplicationContext(),DisplayActivity.class);
            startActivity(i);
        }
        tv=(TextView)findViewById(R.id.textdisp);
        SharedPreferences preferences=getSharedPreferences("mydata",MODE_PRIVATE);
        String data=preferences.getString("username",null);
        tv.setText("Hello "+data);
    }

}
