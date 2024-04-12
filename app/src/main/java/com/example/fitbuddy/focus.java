package com.example.giatorsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class focus extends AppCompatActivity {


    RecyclerView recyclerView;
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);

        recyclerView=findViewById(R.id.recy);

        int[] imgs={
                R.drawable.illu11,
                R.drawable.illu3,
                R.drawable.illu5,
                R.drawable.illu7,
                R.drawable.illu9,
                };

        imageAdapter = new ImageAdapter(focus.this,imgs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(imageAdapter);

    }
}