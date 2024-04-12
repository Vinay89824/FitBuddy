package com.example.giatorsjava;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dietplans extends AppCompatActivity {

    Spinner amrspinner;
    ImageView imgtypes;
    String[] type1 = {"underweight","Normal",
            "overweight",
            "obesity(Class1)",
            "obesity(Class2)",
            "Extremeobesity"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dietplans);
        amrspinner=findViewById(R.id.amrspinner);
        imgtypes=findViewById(R.id.imgtypes);

        amrspinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, type1));




        String in=getIntent().getStringExtra("name").toString();
        int selectedIndex = -1;
        for (int i = 0; i < type1.length; i++) {
            if (type1[i].equals(in)) {
                selectedIndex = i;
                break;
            }
        }

        if (selectedIndex != -1) {
            amrspinner.setSelection(selectedIndex);
        } else {

        }


        amrspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (type1[i]) {
                    case "underweight":
                        imgtypes.setImageResource(R.drawable.underweight);
                        break;
                    case "Normal":
                        imgtypes.setImageResource(R.drawable.normal);
                        break;
                    case "overweight":
                        imgtypes.setImageResource(R.drawable.overweight);
                        break;
                    case "obesity(Class1)":
                        imgtypes.setImageResource(R.drawable.obesity1);
                        break;
                    case "obesity(Class2)":
                        imgtypes.setImageResource(R.drawable.obesity2);
                        break;
                    case "Extremeobesity":
                        imgtypes.setImageResource(R.drawable.extremeobesity);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}