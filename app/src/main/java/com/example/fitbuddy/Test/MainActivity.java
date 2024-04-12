package com.example.giatorsjava.Test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.giatorsjava.R;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    ArrayList<Situations> situations = new ArrayList<>();
    ArrayList<selecatable> selecatables = new ArrayList<>();
    int num;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = findViewById(R.id.cycle2);
        situations = new ArrayList<>();

        situations.add(new Situations(getString(R.string.q1), getString(R.string.q1a), getString(R.string.q1b), getString(R.string.q1c), getString(R.string.q1d)));
        situations.add(new Situations(getString(R.string.q2), getString(R.string.q2a), getString(R.string.q2b), getString(R.string.a2c), getString(R.string.q2d)));
        situations.add(new Situations(getString(R.string.q3), getString(R.string.a3a), getString(R.string.q3b), getString(R.string.q3c), getString(R.string.q3d)));
        situations.add(new Situations(getString(R.string.q4), getString(R.string.a4a), getString(R.string.q4b), getString(R.string.q4c), getString(R.string.q4d)));
        situations.add(new Situations(getString(R.string.q5), getString(R.string.q5a), getString(R.string.q5b), getString(R.string.q5c), getString(R.string.q5d)));
        situations.add(new Situations(getString(R.string.q6), getString(R.string.q6a), getString(R.string.q6b), getString(R.string.q6c), getString(R.string.q6d)));
        situations.add(new Situations(getString(R.string.q7), getString(R.string.q7a), getString(R.string.q7b), getString(R.string.q7c), getString(R.string.q7d)));
        situations.add(new Situations(getString(R.string.q8), getString(R.string.q8a), getString(R.string.q8b), getString(R.string.q8c), getString(R.string.q8d)));
        situations.add(new Situations(getString(R.string.q9), getString(R.string.q9a), getString(R.string.q9b), getString(R.string.q9c), getString(R.string.q9d)));
        situations.add(new Situations(getString(R.string.q10), getString(R.string.q10a), getString(R.string.q10b), getString(R.string.q10c), getString(R.string.q10d)));
        situations.add(new Situations(getString(R.string.q11), getString(R.string.q11a), getString(R.string.q11b), getString(R.string.q11c), getString(R.string.q11d)));
        situations.add(new Situations(getString(R.string.q12), getString(R.string.q12a), getString(R.string.q12b), getString(R.string.q12c), getString(R.string.q12d)));
        situations.add(new Situations(getString(R.string.q13), getString(R.string.q13a), getString(R.string.q13b), getString(R.string.q13c), getString(R.string.q13d)));
        situations.add(new Situations(getString(R.string.q14), getString(R.string.q14a), getString(R.string.q14b), getString(R.string.q14c), getString(R.string.q14d)));
        situations.add(new Situations(getString(R.string.q15), getString(R.string.q15a), getString(R.string.q15b), getString(R.string.q15c), getString(R.string.q15d)));
        situations.add(new Situations(getString(R.string.q16), getString(R.string.q16a), getString(R.string.q16b), getString(R.string.q16c), getString(R.string.q16d)));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemViewCacheSize(situations.size());
        recyclerView.setAdapter(new MyAdapter(this, situations, selecatables));

        findViewById(R.id.btn).setOnClickListener(v->{
            num=0;
            for (selecatable item:selecatables){
                if(!Objects.equals(item.selected, "nothing"))
                    num++;
                        else
                    break;
            }
            if(num>=1){
                Intent intent= new Intent(MainActivity.this,Analysis.class);
                intent.putParcelableArrayListExtra("data",selecatables);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Please select any option of Options ", Toast.LENGTH_SHORT).show();
            }


        });

    }
}