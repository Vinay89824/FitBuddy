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

public class Analysis extends AppCompatActivity {
    ArrayList<selecatable> selecatables;
    ArrayList<Analy> analies=new ArrayList<>();
    int num=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysise);
        selecatables = getIntent().getParcelableArrayListExtra("data");

        adddata();
        if (selecatables != null) {
            RecyclerView recyclerView=findViewById(R.id.cycle3);
            recyclerView.setLayoutManager(new LinearLayoutManager(this
            ));
            recyclerView.setAdapter(new Custome_Adapter(this,selecatables,analies));
        }


findViewById(R.id.fab).setOnClickListener(o->{
num=0;
    selecatables.forEach(m->{
if(!m.selected.contains("nothing")) {
    switch (m.selected) {
        case "A":
            num += 10;
            break;
        case "B":
            num += 9;
            break;

        case "C":
            num += 8;
            break;

        case "D":
            num += 7;
            break;
    }

}

    });
try {
    int value=(int) (((float) num /160)*100);
    Intent intent=new Intent(this,Percentage.class);
            intent.putExtra("percent",value);
    startActivity(intent);
}catch (Exception exception){

    Toast.makeText(this, ""+exception.getMessage(), Toast.LENGTH_SHORT).show();
}

});

    }

    private void adddata() {
        analies.add(new Analy("1", getString(R.string.a1a), getString(R.string.a1b), getString(R.string.a1c), getString(R.string.a1d)));
        analies.add(new Analy("2", getString(R.string.a2a), getString(R.string.a2b), getString(R.string.a22c), getString(R.string.a2d)));
        analies.add(new Analy("3", getString(R.string.a33a), getString(R.string.a33b), getString(R.string.a33c), getString(R.string.a33d)));
        analies.add(new Analy("4", getString(R.string.a44a), getString(R.string.a44b), getString(R.string.a44c), getString(R.string.a44d)));
        analies.add(new Analy("5", getString(R.string.a55a), getString(R.string.a55b), getString(R.string.a55c), getString(R.string.a55d)));
        analies.add(new Analy("6", getString(R.string.a66a), getString(R.string.a66b), getString(R.string.a66c), getString(R.string.a66d)));
        analies.add(new Analy("7", getString(R.string.a77a), getString(R.string.a77b), getString(R.string.a77c), getString(R.string.a77d)));
        analies.add(new Analy("8", getString(R.string.a88a), getString(R.string.a88b), getString(R.string.a88c), getString(R.string.a88d)));
        analies.add(new Analy("9", getString(R.string.a99a), getString(R.string.a99b), getString(R.string.a99c), getString(R.string.a99d)));
        analies.add(new Analy("10", getString(R.string.a10a), getString(R.string.a10b), getString(R.string.a10c), getString(R.string.a10d)));
        analies.add(new Analy("11", getString(R.string.a11a), getString(R.string.a11b), getString(R.string.a11c), getString(R.string.a11d)));
        analies.add(new Analy("12", getString(R.string.a12a), getString(R.string.a12b), getString(R.string.a12c), getString(R.string.a12d)));
        analies.add(new Analy("13", getString(R.string.a13a), getString(R.string.a13b), getString(R.string.a13c), getString(R.string.a13d)));
        analies.add(new Analy("14", getString(R.string.a14a), getString(R.string.a14b), getString(R.string.a14c), getString(R.string.a14d)));
        analies.add(new Analy("15", getString(R.string.a15a), getString(R.string.a15b), getString(R.string.a15c), getString(R.string.a15d)));
        analies.add(new Analy("16", getString(R.string.a16a), getString(R.string.a16b), getString(R.string.a16c), getString(R.string.a16d)));
    }

}