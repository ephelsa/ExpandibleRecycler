package com.personal.leonardo.testapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {

    private List<ChildModel> childList;
    private Context context = null;

    public ChildAdapter(List<ChildModel> childList) {
        this.childList = childList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.cardview_child, parent, false);

        ViewHolder holder = new ViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.childTitle.setText(childList.get(position).getTitle());
        holder.childImage.setImageResource(R.drawable.ic_launcher_background);

        holder.childCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, childList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView childCard;
        TextView childTitle;
        ImageView childImage;

        public ViewHolder(View itemView) {
            super(itemView);

            childCard = itemView.findViewById(R.id.cardViewChild);
            childTitle = itemView.findViewById(R.id.childTitle);
            childImage = itemView.findViewById(R.id.childImage);
        }
    }
}
