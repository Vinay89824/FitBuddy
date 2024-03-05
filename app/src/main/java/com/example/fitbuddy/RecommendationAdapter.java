package com.example.fitbuddy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecommendationAdapter extends RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder> {
    private List<Recommendation> recommendationList;

    public RecommendationAdapter(List<Recommendation> recommendationList) {
        this.recommendationList = recommendationList;
    }

    @NonNull
    @Override
    public RecommendationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommendation, parent, false);
        return new RecommendationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendationViewHolder holder, int position) {
        Recommendation recommendation = recommendationList.get(position);
        holder.titleTextView.setText(recommendation.getTitle());
        holder.descriptionTextView.setText(recommendation.getDescription());
    }

    @Override
    public int getItemCount() {
        return recommendationList.size();
    }

    public static class RecommendationViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;

        public RecommendationViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTV);
            descriptionTextView = itemView.findViewById(R.id.descriptionTV);
        }
    }
}
