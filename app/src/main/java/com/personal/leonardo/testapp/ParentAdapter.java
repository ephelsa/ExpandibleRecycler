package com.personal.leonardo.testapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {

    private List<ParentModel> parentList;
    private Context context = null;

    public ParentAdapter(List<ParentModel> parentList) {
        this.parentList = parentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.cardview_parent, parent, false);

        ViewHolder holder = new ViewHolder(itemView, context);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        init(holder.parentRecycler, parentList.get(position).getQuery());

        holder.parentTitle.setText(parentList.get(position).getTitle());

        holder.parentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.parentRecycler.getVisibility() == View.VISIBLE) {
                    holder.parentRecycler.setVisibility(View.GONE);
                } else {
                    holder.parentRecycler.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void init(RecyclerView parentRecycler, int i) {
        List<ChildModel> list = new ArrayList<>();

        ChildAdapter childAdapter = new ChildAdapter(list);

        for (int j = 0; j < i; j++) {
            list.add(new ChildModel("Child " + j, null));

        }

        parentRecycler.setAdapter(childAdapter);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView parentCard;
        TextView parentTitle;
        RecyclerView parentRecycler;

        public ViewHolder(View itemView, Context context) {
            super(itemView);

            parentCard = itemView.findViewById(R.id.cardViewParent);
            parentTitle = itemView.findViewById(R.id.parentTitle);
            parentRecycler = itemView.findViewById(R.id.parentReycler);

            parentRecycler.setVisibility(View.GONE);
            parentRecycler.setHasFixedSize(true);
            parentRecycler.setLayoutManager(new LinearLayoutManager(context));
        }
    }
}
