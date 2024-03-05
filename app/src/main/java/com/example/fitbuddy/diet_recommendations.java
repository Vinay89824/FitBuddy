package com.example.fitbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class diet_recommendations extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecommendationAdapter adapter;
    private List<Recommendation> recommendationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_recommendations);

        recyclerView = findViewById(R.id.recyclerViewDietRecommendations);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recommendationList = new ArrayList<>();
        recommendationList.add(new Recommendation("Eat a variety of foods", "Include fruits, vegetables, whole grains, lean proteins, and healthy fats."));
        recommendationList.add(new Recommendation("Control portion sizes", "Be mindful of portion sizes to avoid overeating."));
        recommendationList.add(new Recommendation("Stay hydrated", "Drink at least 8 glasses (64 ounces) of water per day, and adjust based on factors like activity level and climate."));
        recommendationList.add(new Recommendation("Limit processed foods", "Try to limit processed and packaged foods to no more than 25% of your total daily food intake. Focus on whole, unprocessed foods as the foundation of your diet."));
        recommendationList.add(new Recommendation("Reduce added sugars", "Limit added sugars to no more than 10% of your daily calorie intake. This typically amounts to about 50 grams (or 12 teaspoons) of added sugars per day for an average adult."));
        recommendationList.add(new Recommendation("Choose healthy fats", "Aim to include sources of healthy fats in each meal, such as 1-2 tablespoons of olive oil for cooking, a small handful of nuts or seeds, or half an avocado."));
        recommendationList.add(new Recommendation("Prioritize fiber", "Aim for at least 25 grams of fiber per day for women and 38 grams per day for men. Incorporate fiber-rich foods into each meal, such as whole grains, fruits, vegetables, beans, and legumes."));
        recommendationList.add(new Recommendation("Balance macronutrients", "Aim for a balanced distribution of macronutrients, with approximately 45-65% of your total daily calories coming from carbohydrates, 20-35% from fats, and 10-35% from protein."));
        recommendationList.add(new Recommendation("Plan meals ahead", "Set aside time each week to plan your meals and snacks. Create a grocery list based on your meal plan to ensure you have all the necessary ingredients on hand."));
        recommendationList.add(new Recommendation("Listen to your body", "Practice mindful eating by paying attention to hunger and fullness cues. Eat slowly, savoring each bite, and stop eating when you feel satisfied but not overly full."));
        adapter = new RecommendationAdapter(recommendationList);
        recyclerView.setAdapter(adapter);
    }
}