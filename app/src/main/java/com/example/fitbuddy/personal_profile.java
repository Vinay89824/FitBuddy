package com.example.fitbuddy;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class personal_profile extends AppCompatActivity {
    private EditText editTextHeight;
    private EditText editTextWeight;
    private EditText editTextAge;
    private EditText editTextMedicalConditions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_profile);
// Initialize EditText fields
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextAge = findViewById(R.id.editTextAge);
        editTextMedicalConditions = findViewById(R.id.editTextMedicalConditions);
// Load existing user profile data if needed
        loadUserProfileData();
    }
    // Load existing user profile data (if available)
    private void loadUserProfileData() {
// Retrieve saved data from SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedHeight = sharedPreferences.getString("user_height", "");
        String savedWeight = sharedPreferences.getString("user_weight", "");
        String savedAge = sharedPreferences.getString("user_age", "");
        String savedMedicalConditions = sharedPreferences.getString("user_medical_conditions", "");
// Set the retrieved data to the corresponding EditText fields
        editTextHeight.setText(savedHeight);
        editTextWeight.setText(savedWeight);
        editTextAge.setText(savedAge);
        editTextMedicalConditions.setText(savedMedicalConditions);
    }
    // Save user profile data
    private void saveUserProfileData() {
// Retrieve the entered values from EditText fields
        String height = editTextHeight.getText().toString();
        String weight = editTextWeight.getText().toString();
        String age = editTextAge.getText().toString();
        String medicalConditions = editTextMedicalConditions.getText().toString();
// Get a SharedPreferences.Editor instance to edit SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
// Save the entered values to SharedPreferences
        editor.putString("user_height", height);
        editor.putString("user_weight", weight);
        editor.putString("user_age", age);
        editor.putString("user_medical_conditions", medicalConditions);
// Apply the changes
        editor.apply();
    }
    @Override
    protected void onPause() {
        super.onPause();
// Save user profile data when the activity is paused
        saveUserProfileData();
    }
}