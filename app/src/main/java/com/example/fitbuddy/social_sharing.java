package com.example.fitbuddy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class social_sharing extends AppCompatActivity {

    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_sharing);

        shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareRecommendations();
            }
        });
    }

    private void shareRecommendations() {
        // Create a message containing diet recommendations
        StringBuilder message = new StringBuilder();
        message.append("Check out these diet recommendations from Fit Buddy app:\n\n");
        for (Recommendation recommendation : getDietRecommendations()) {
            message.append("- ").append(recommendation.getTitle()).append(": ").append(recommendation.getDescription()).append("\n\n");
        }

        // Share the message
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message.toString());
        startActivity(Intent.createChooser(intent, "Share Diet Recommendations"));
    }

    private ArrayList<Recommendation> getDietRecommendations() {
        // Here you would fetch the actual diet recommendations from your data source
        // For this example, let's create some dummy recommendations
        ArrayList<Recommendation> recommendations = new ArrayList<>();
        recommendations.add(new Recommendation("Eat a variety of foods", "Include fruits, vegetables, whole grains, lean proteins, and healthy fats."));
        recommendations.add(new Recommendation("Control portion sizes", "Be mindful of portion sizes to avoid overeating."));
        recommendations.add(new Recommendation("Stay hydrated", "Drink at least 8 glasses (64 ounces) of water per day, and adjust based on factors like activity level and climate."));
        // Add more recommendations as needed
        return recommendations;
    }
}
