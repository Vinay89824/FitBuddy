package com.example.giatorsjava.Test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.giatorsjava.R;

public class Percentage extends AppCompatActivity {
    TextView textView,tvprecentage,
    result1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage);
    int value=getIntent().getIntExtra("percent",0);
        textView=findViewById(R.id.result);

    if(value<=10){
    getcharsequence("<b>"+value+"% - Denial</b><br>" +
            "You are in denial that the project is going to be difficult or time-consuming.<br>"+
            "You may underestimate the scope of the project or overestimate your own abilities.<br>" +
            "You may be reluctant to start working on the project or to ask for help.<br>");

    }else if(value<=20){
        getcharsequence("<b>"+value+"% - Anxiety</b><br>" +
                "You start to feel anxious about the project.<br>"+
                "You may worry about meeting deadlines, completing all of the tasks, or producing high-quality work.<br>" +
                "You may start to procrastinate or avoid working on the project altogether.<br>");
    }else if(value<=30){
 getcharsequence("<b>"+value+"% - Desperation</b><br>" +
                "You are now feeling desperate to complete the project.<br>"+
                "You may start to work long hours or to neglect other important aspects of your life.<br>" +
                "You may feel overwhelmed and frustrated.<br>");

    }else if(value<=40){
 getcharsequence("<b>"+value+"% - Depression</b><br>" +
                "You are now feeling depressed about the project.<br>"+
                "You may lose hope of ever completing the project or of producing high-quality work.<br>" +
                "You may start to feel worthless and incompetent.<br>");

    }else if(value<=50){
 getcharsequence("<b>"+value+"% - Anger</b><br>" +
                "You are now angry about the project.<br>"+
                "You may blame yourself or others for the project's difficulties.<br>" +
                "You may feel resentful of the time and effort that you have put into the project.<br>");

    }else if(value<=60){
 getcharsequence("<b>"+value+"% - Resignation</b><br>" +
                "You have now resigned yourself to the fact that the project will not be completed on time or to a high standard.<br>"+
                "You may feel apathetic and unmotivated.<br>" +
                "You may start to cut corners or to give up on the project altogether.<br>");

    }else if(value<=70){
 getcharsequence("<b>"+value+"% - Acceptance</b><br>" +
                "You have now accepted that the project is a failure.<br>"+
                "You may feel disappointed and ashamed.<br>" +
                "You may start to learn from your mistakes and to plan for future projects.<br>");

    }else if(value<=80){
 getcharsequence("<b>"+value+"% - Reflection</b><br>" +
                "You are now reflecting on the project and what went wrong.<br>"+
                "You are identifying areas where you can improve your project management skills.<br>" +
                "You are developing strategies to avoid making the same mistakes in the future.<br>");

    }else if(value<=90){
 getcharsequence("<b>"+value+"% - Recovery</b><br>" +
                "You are now recovering from the project failure.<br>"+
                "You are starting to feel more confident and motivated.<br>" +
                "You are ready to start working on new projects.<br>");

    }else if(value<=100){
 getcharsequence("<b>"+value+"% - happy mind</b><br>" +
                "ou have now moved on from the project failure.<br>"+
                "You have learned from your mistakes and are ready to apply your new knowledge to future projects.<br>" +
                "You are feeling confident and optimistic about the future.<br>");

    }else{
        getcharsequence("<b>"+value+"% - Lazy</b><br>" +
                "Too Lazy<br>"+
                "Tooo Lazy<br>" +
                "Toooo Lazy<br>");
    }




    }

    private void getcharsequence(String s) {

     textView.setText(HtmlCompat.fromHtml(s,HtmlCompat.FROM_HTML_OPTION_USE_CSS_COLORS));
    }
}