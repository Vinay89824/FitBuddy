package com.example.giatorsjava.Test;


import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.giatorsjava.Login;
import com.example.giatorsjava.R;

import java.util.ArrayList;
import java.util.Objects;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Viewed> {
    Context context;
    ArrayList<Situations> situations;
    ArrayList<selecatable>selecatables;
    public MyAdapter(Context context, ArrayList<Situations> situations, ArrayList<selecatable> selecatables) {
        this.context=context;
                this.situations=situations;
        this.selecatables=selecatables;
        }

    @NonNull
    @Override
    public Viewed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewed(LayoutInflater.from(context).inflate(R.layout.questioncard, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewed holder, int position) {
        Situations situation=situations.get(position);
        int fd=position+1;
        selecatable ff=new selecatable(String.valueOf(fd),"nothing");
        selecatables.add(ff);
        holder.question.setText(spannable("<b>"+fd+")&nbsp</b>"+situation.questions.trim()));
        holder.option1.setText(spannable("A) "+situation.choice_a.trim()));
        holder.option2.setText(spannable("B) "+situation.choice_b.trim()));
        holder.option3.setText(spannable("C) "+situation.choice_c.trim()));
        holder.option4.setText(spannable("D) "+situation.choice_d.trim()));
        ArrayList<TextView>textViews=new ArrayList<>();
        textViews.add(holder.option1);
        textViews.add(holder.option2);
        textViews.add(holder.option3);
        textViews.add(holder.option4);
        holder.option1.setOnClickListener(v-> {
            functions(holder.option1, textViews);

            change("A",""+fd);
        });
        holder.option2.setOnClickListener(v-> {
            change("B",""+fd);
            functions(holder.option2, textViews);
        });
        holder.option3.setOnClickListener(v-> {
            change("C",""+fd);
            functions(holder.option3, textViews);
        });
        holder.option4.setOnClickListener(v-> {
            change("D",""+fd);
            functions(holder.option4, textViews);
        });

    }

    private void change(String selected,String questionid) {
    selecatables.forEach(v->{

        if(Objects.equals(questionid, v.getQuestion())){
            v.selected=selected;
        }
     });
    }

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    private void functions(TextView v, ArrayList<TextView> textViews) {
        for (TextView item:textViews){
            if(v ==item){
                item.setBackgroundColor(context.getColor(R.color.white));
            }else{
                item.setBackgroundColor(context.getColor(R.color.tint));
            }
        }

    }

    @Override
    public int getItemCount() {
        return situations.size();
    }
public CharSequence spannable(String string){
        return HtmlCompat.fromHtml(string,HtmlCompat.FROM_HTML_OPTION_USE_CSS_COLORS);
}
    public static class Viewed extends RecyclerView.ViewHolder{
TextView question,option1,option2,option3,option4;
        public Viewed(@NonNull View itemView) {
            super(itemView);
                    question=itemView.findViewById(R.id.question);
                    option1=itemView.findViewById(R.id.option1);
                    option2=itemView.findViewById(R.id.option2);
                    option3=itemView.findViewById(R.id.option3);
                    option4=itemView.findViewById(R.id.option4);
        }
    }
}
