package com.example.giatorsjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.giatorsjava.R;

import java.util.ArrayList;

public class fitness extends AppCompatActivity  {
    ArrayList<String> link=new ArrayList<>();
    ArrayList<String> title=new ArrayList<>();


    RecyclerView recyclerView;
    ArrayList <TextView>textViews=new ArrayList<>();


    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);



        recyclerView=findViewById(R.id.cycle);
        link.add("https://youtu.be/sWfNosruPPw?si=NY4Xvx7cay506270");
        link.add("https://youtu.be/7EX1Xnvvk5c?si=1pxStLuCPsfQ6ko1");
        link.add("https://youtu.be/r4MzxtBKyNE?si=ed2lF9ZC1lHnio8M");
        link.add("https://youtu.be/r4MzxtBKyNE?si=qUzDgOlKHqCwheN9");
        link.add("https://youtu.be/rT7DgCr-3pg?si=NQTfoI66AMshaYtC");
        link.add("https://youtu.be/eGo4IYlbE5g?si=0CagkmWJyDvU0MRv");
        link.add("https://youtu.be/rep-qVOkqgk?si=tz76nIlYAcd7zQxa");
        link.add("https://youtu.be/_UvmPNGtlPM?si=M-Ep1k9epF9cvNNd");
        link.add("https://youtu.be/wrwwXE_x-pQ?si=u9Rck-jtYnrAHqoD");
        link.add("https://youtu.be/IODxDxX7oi4?si=S9mQx8DvdGNkXHVt");
        link.add("https://youtu.be/M2rwvNhTOu0?si=3NDM9UeyIrH9vGsF");
        link.add("https://youtu.be/4re6CJ0XNF8?si=t5LW7GswYiZwJRCv");
        link.add("https://youtu.be/QZEqB6wUPxQ?si=FvCt5aDqqvV5opRz");
        link.add("https://youtu.be/kBWAon7ItDw?si=IhK2woKO_eVoAZAL");
        title.add("How to Reduce your Depression");
        title.add("How to manage stress and anxiety");
        title.add("Squat");
        title.add("Deadlift");
        title.add("Bench Press");
        title.add("Pullup");
        title.add("Face Pull");
        title.add("Banded External Rotation");
        title.add("Lunge");title.add("Pushup");
        title.add("Overhead Press");
        title.add("The Lying Triceps Extension");
        title.add("Barbell Curl");
        title.add("Barbell Row");
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setAdapter(new VideoListAdapetr(this,link,title));
    }


}