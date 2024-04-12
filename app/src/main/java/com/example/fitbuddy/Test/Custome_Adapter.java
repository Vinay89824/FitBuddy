package com.example.giatorsjava.Test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giatorsjava.R;

import java.util.ArrayList;
import java.util.Objects;

public class Custome_Adapter extends RecyclerView.Adapter<Custome_Adapter.Viwee> {

    Context context;
            ArrayList<selecatable> selecatables;
    ArrayList<Analy>analies;
    public Custome_Adapter(Context context, ArrayList<selecatable> selecatables, ArrayList<Analy> analies) {
        this.context=context;
                this.selecatables=selecatables;
        this.analies=analies;
    }

    @NonNull
    @Override
    public Viwee onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viwee(LayoutInflater.from(context).inflate(R.layout.analysis,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viwee holder, int position) {

        String ff="";
        String selected=selecatables.get(position).selected;
        Analy analy=analies.get(position);
        switch (selected){
            case "A":
                ff=analy.choose_A;
                break;
            case "B":
                ff=analy.choose_B;
                break;

            case "C":
                ff=analy.choose_C;
                break;

            case "D":
                ff=analy.choose_D;
                break;
        }
        holder.selected.setText(HtmlCompat.fromHtml("<b>Question No :"+analy.question+"</b><br>"+"<b>"+selected+")</b>"+ff,HtmlCompat.FROM_HTML_OPTION_USE_CSS_COLORS));


    }

    @Override
    public int getItemCount() {
        int num=0;
        for (selecatable item:selecatables){
            if(!Objects.equals(item.selected, "nothing")){
                num++;
            }
        }

        return num;
    }

    public static class Viwee extends RecyclerView.ViewHolder{
        TextView selected;
        public Viwee(@NonNull View itemView) {
            super(itemView);
            selected=itemView.findViewById(R.id.selected);
        }
    }
}
