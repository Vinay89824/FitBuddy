package com.example.giatorsjava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giatorsjava.Test.MainActivity;

public class Dashboard extends AppCompatActivity {


    TextView tvname;
    SharedPreferences spf;
    LinearLayout linearfocus,linearCalories,linearfitness,lineardepression,linearprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

         findViewById(R.id.test).setOnClickListener(v->{
            startActivity(new Intent(Dashboard.this, MainActivity.class));
        });



        tvname=findViewById(R.id.tvname);
        linearfocus=findViewById(R.id.linearfocus);
        linearCalories=findViewById(R.id.linearCalories);
        linearfitness=findViewById(R.id.linearfitness);
        lineardepression=findViewById(R.id.lineardepression);
        linearprofile=findViewById(R.id.linearprofile);
        spf= getSharedPreferences("users", MODE_PRIVATE);


        tvname.setText("Welcome "+spf.getString("name",""));



        linearprofile.setOnClickListener(l->{
            startActivity(new Intent(this,Profile.class));
        });

        lineardepression.setOnClickListener(l->{
            startActivity(new Intent(this,WebViewLoad.class));
        });


        linearfocus.setOnClickListener(l->{
            startActivity(new Intent(this,focus.class));
        });

        linearfitness.setOnClickListener(l->{
            startActivity(new Intent(this,fitness.class));
        });

        linearCalories.setOnClickListener(l->{
            startActivity(new Intent(this,Calories.class));

        });
    }
}