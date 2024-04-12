package com.example.giatorsjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class VideoListAdapetr extends RecyclerView.Adapter<VideoListAdapetr.Viewed> {
    Context context;
    ArrayList<String> link;
    ArrayList<String> title;
    public VideoListAdapetr(Context context, ArrayList<String> link, ArrayList<String> title) {
        this.context=context;
        this.link=link;
        this.title=title;
    }

    @NonNull
    @Override
    public Viewed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new Viewed(LayoutInflater.from(context).inflate(R.layout.cardlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewed holder, int position) {
TextView textView= holder.textView;
textView.setText(title.get(position));
holder.itemView.setOnClickListener(
        v->{
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(link.get(0)));
            context.startActivity(intent);
        }
);
    }

    @Override
    public int getItemCount() {
        return link.size();
    }

    public static class Viewed extends  RecyclerView.ViewHolder {
        TextView textView;
        public Viewed(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.details);
        }
    }
}
