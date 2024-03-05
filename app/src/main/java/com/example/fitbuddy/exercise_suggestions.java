package com.example.fitbuddy;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class exercise_suggestions extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExerciseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_suggestions);
        recyclerView = findViewById(R.id.ExerciseSuggestionsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise("Push-ups", "Strengthen upper body muscles"));
        exerciseList.add(new Exercise("Squats", "Tone lower body muscles"));
        exerciseList.add(new Exercise("Lunges", "Engage lower body muscles"));
        exerciseList.add(new Exercise("Plank", " Strengthen core muscles by holding a push-up position."));
        exerciseList.add(new Exercise("Jumping Jacks", "Boost heart rate with a full-body cardio move involving jumping and arm movement."));
        exerciseList.add(new Exercise("Burpees", "Improve strength and endurance with a combination of squat, push-up, and jump."));
        exerciseList.add(new Exercise("High Knees", "Elevate heart rate by rapidly lifting knees towards chest while standing."));
        exerciseList.add(new Exercise("Mountain Climbers", "Enhance core strength and agility by alternating legs in a plank position."));
        exerciseList.add(new Exercise("Bicycle Crunches", "Target abdominal muscles with a twisting motion while lying on your back."));
        exerciseList.add(new Exercise("Russian Twists", " Work oblique muscles with a seated twisting motion while holding a weight or clasping hands together."));
        adapter = new ExerciseAdapter(exerciseList);
        recyclerView.setAdapter(adapter);
    }
}