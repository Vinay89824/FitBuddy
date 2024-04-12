package com.example.giatorsjava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.giatorsjava.Roomdatabase.DataBase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Profile extends AppCompatActivity {
    EditText etname, etnum, etemail, etaddress, etcity,  etpassword;
    Button btnupdate,btnlogout;
    SharedPreferences spf;
    DataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        etname=findViewById(R.id.etname);
        etnum=findViewById(R.id.etnum);
        etemail=findViewById(R.id.etemail);
        etaddress=findViewById(R.id.etaddress);
        etcity=findViewById(R.id.etcity);
        etpassword=findViewById(R.id.etpassword);
        btnupdate=findViewById(R.id.btnupdate);
        btnlogout=findViewById(R.id.btnlogout);

        spf= getSharedPreferences("users", MODE_PRIVATE);
        dataBase=DataBase.getdatabase(this);

        etname.setText( spf.getString("name",""));
        etnum.setText( spf.getString("moblie",""));
        etemail.setText( spf.getString("email",""));
        etcity.setText(spf.getString("city",""));
        etpassword.setText(spf.getString("password",""));
        etaddress.setText(spf.getString("address",""));


        btnlogout.setOnClickListener(l->{
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
            alertDialog.setTitle("Logout");
            alertDialog.setIcon(R.drawable.logo);
            alertDialog.setCancelable(false);
            alertDialog.setMessage("Do you want to Logout");
            alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SharedPreferences.Editor spe = spf.edit();
                    spe.clear();
                    spe.apply();
                    startActivity(new Intent(Profile.this,Login.class));
                    finish();
                }
            });
            alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(Profile.this, "Thank you", Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.show();
        });

        btnupdate.setOnClickListener(l->{
            String name=etname.getText().toString().trim();
            String num=etnum.getText().toString().trim();
            String email=etemail.getText().toString().trim();
            String city=etcity.getText().toString().trim();
            String address=etaddress.getText().toString().trim();
            String pass=etpassword.getText().toString().trim();
            if(name.isEmpty()){
                Toast.makeText(this, "Enter  name", Toast.LENGTH_SHORT).show();
            }else if(num.isEmpty()){
                Toast.makeText(this, "Enter Phone number", Toast.LENGTH_SHORT).show();
            }else if(email.isEmpty()){
                Toast.makeText(this, "Enter  Email", Toast.LENGTH_SHORT).show();
            }else if(city.isEmpty()){
                Toast.makeText(this, "Enter City", Toast.LENGTH_SHORT).show();
            }else if(address.isEmpty()){
                Toast.makeText(this, "Enter Address", Toast.LENGTH_SHORT).show();
            }else if(pass.isEmpty()){
                Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();

            } else{
                if(email.contains("@gmail.com")){
                    if(num.length()!=10){
                        Toast.makeText(this, "Enter  phone number properly", Toast.LENGTH_SHORT).show();
                    }else{
                        if(isValidPassword(pass)){
                            dataBase.dao().updateUser(
                                    name,
                                    num,
                                    email,
                                    city,
                                    pass,
                                    email);
                            SharedPreferences.Editor editor=spf.edit();
                            editor.putString("name",name);
                            editor.putString("moblie",num);
                            editor.putString("email",email);
                            editor.putString("city",city);
                            editor.putString("password",pass);
                            editor.putString("address" ,address);
                            editor.apply();

                            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();


                        }else{
                            Toast.makeText(this, "Enter Strong password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(this, "Enter  Email properly", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    public static boolean
    isValidPassword(String password)
    {

        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        if (password == null) {
            return false;
        }

        Matcher m = p.matcher(password);
        return m.matches();
    }
}