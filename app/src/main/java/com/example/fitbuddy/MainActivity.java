package com.example.fitbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        // Set click listener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the login activity
                openLoginActivity();
            }
        });

        // Set click listener for the register button
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the user registration activity
                openUserRegistrationActivity();
            }
        });
    }

    private void openLoginActivity() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    private void openUserRegistrationActivity() {
        Intent intent = new Intent(this, user_registration.class);
        startActivity(intent);
    }
}
