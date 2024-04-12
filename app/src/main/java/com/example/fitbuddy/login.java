package com.example.giatorsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giatorsjava.Roomdatabase.DataBase;
import com.example.giatorsjava.Roomdatabase.Usertable;

import java.util.List;

public class Login extends AppCompatActivity {

    TextView tvsignup;
    EditText etemail, etpassword;
    Button btnlogin;
    SharedPreferences spf;
    DataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dataBase=DataBase.getdatabase(this);
        tvsignup=findViewById(R.id.tvsignup);
        etemail=findViewById(R.id.etemail);
        etpassword=findViewById(R.id.etpassword);
        btnlogin=findViewById(R.id.btnlogin);
        spf= getSharedPreferences("users", MODE_PRIVATE);
        tvsignup.setOnClickListener(l->{
            startActivity(new Intent(this,Register.class));
        });


        btnlogin.setOnClickListener(l->{
            String email= etemail.getText().toString().trim();
            String pass=etpassword.getText().toString().trim();
            if(email.isEmpty()){
                Toast.makeText(this, "Enter your Email", Toast.LENGTH_SHORT).show();

            }else if(pass.isEmpty()){
                Toast.makeText(this, "Enter your Password", Toast.LENGTH_SHORT).show();

            }else {

                List<Usertable> login=dataBase.dao().login(email,pass);
              if(login.isEmpty()){
                    Toast.makeText(this, "Please enter valid credentials", Toast.LENGTH_SHORT).show();

                }else{
                    Usertable health=login.get(0);
                    SharedPreferences.Editor spe = spf.edit();
                    spe.putString("name",health.name);
                    spe.putString("moblie",health.moblie);
                    spe.putString("email",health.email);
                    spe.putString("city",health.city);
                    spe.putString("password",health.password);
                    spe.putString("address" ,health.address);
                    spe.putString("id",health.id.toString());
                    spe.apply();
                    startActivity(new Intent(this,Dashboard.class));
                    finish();


                }



            }
        });
    }
}