package com.example.giatorsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.giatorsjava.Roomdatabase.DataBase;
import com.example.giatorsjava.Roomdatabase.Usertable;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {


    EditText etname, etnum, etemail, etcity, etpassword,etaddress;
    Button btnsubmit;
    DataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etname=findViewById(R.id.etname);
        etnum=findViewById(R.id.etnum);
        etemail=findViewById(R.id.etemail);
        etaddress=findViewById(R.id.etaddress);
        etcity=findViewById(R.id.etcity);
        etpassword=findViewById(R.id.etpassword);
        btnsubmit=findViewById(R.id.btnsubmit);
        dataBase=DataBase.getdatabase(this);


        btnsubmit.setOnClickListener(
                l->{
                    String name=etname.getText().toString().trim();
                    String num=etnum.getText().toString().trim();
                    String email=etemail.getText().toString().trim();
                    String city=etcity.getText().toString().trim();
                    String address=etaddress.getText().toString().trim();
                    String pass=etpassword.getText().toString().trim();
                    if(name.isEmpty()){
                        Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show();
                    }else if(num.isEmpty()){
                        Toast.makeText(this, "Enter your Phone number", Toast.LENGTH_SHORT).show();
                    }else if(email.isEmpty()){
                        Toast.makeText(this, "Enter your Email", Toast.LENGTH_SHORT).show();
                    }else if(city.isEmpty()){
                        Toast.makeText(this, "Enter your City", Toast.LENGTH_SHORT).show();
                    }else if(address.isEmpty()){
                        Toast.makeText(this, "Enter your Address", Toast.LENGTH_SHORT).show();
                    }else if(pass.isEmpty()){
                        Toast.makeText(this, "Enter your Password", Toast.LENGTH_SHORT).show();
                    }else{
                        if(email.contains("@gmail.com")){
                            if(num.length()!=10){
                                Toast.makeText(this, "Enter your phone number properly", Toast.LENGTH_SHORT).show();

                            }else{
                                if(isValidPassword(pass)){
                                    List<Usertable>data=dataBase.dao().checkmail(email);
                                    Toast.makeText(this, ""+data, Toast.LENGTH_SHORT).show();
                                    if(data.isEmpty()) {
                                        Usertable Usertable = new Usertable(name,num,email,city,pass,address,0);
                                        dataBase.dao().createUser(Usertable);
                                        finish();
                                        Toast.makeText(this, "Thank you for registering", Toast.LENGTH_SHORT).show();

                                    }else{
                                        Toast.makeText(this, "this email is already used by other user", Toast.LENGTH_SHORT).show();

                                    }

                                }else{
                                    Toast.makeText(this, "Enter Strong password", Toast.LENGTH_SHORT).show();

                                }
                            }
                        }else{
                            Toast.makeText(this, "Enter your Email properly", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        );

    }

    public static boolean
    isValidPassword(String password)
    {

        // Regex to check valid password.
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