package com.example.fitbuddy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class user_registration extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        // Initialize UI components
        editTextUsername = findViewById(R.id.UsernameET);
        editTextEmail = findViewById(R.id.EmailET);
        editTextPassword = findViewById(R.id.PasswordET);
        buttonRegister = findViewById(R.id.RegisterBTN);

        // Set click listener for the register button
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform user registration
                registerUser();
            }
        });
    }

    private void registerUser() {
        // Retrieve registration details entered by the user
        String username = editTextUsername.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Perform registration logic here (e.g., store user details in a database)
        // For demo purposes, display a toast message indicating success
        Toast.makeText(this, "Registration Successful for username: " + username, Toast.LENGTH_SHORT).show();
    }
}
