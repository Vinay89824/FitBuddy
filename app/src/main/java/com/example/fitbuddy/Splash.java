package com.example.giatorsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.giatorsjava.R;

import java.util.Objects;

public class Splash extends AppCompatActivity {
    SharedPreferences spf;
    String Type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spf= getSharedPreferences("users", MODE_PRIVATE);
        Type=spf.getString("name","");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
             if(Type.isEmpty()){
                 startActivity(new Intent(Splash.this,Login.class));
             }else{
                 startActivity(new Intent(Splash.this,Dashboard.class));
             }

                finish();
            }
        },3000);
    }
}