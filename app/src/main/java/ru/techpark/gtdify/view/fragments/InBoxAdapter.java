package ru.techpark.gtdify.view.fragments;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import ru.techpark.gtdify.R;
import ru.techpark.gtdify.model.models.Card;

public class InBoxAdapter extends RecyclerView.Adapter<ProjectFragmentViewHolder> {

    List<Card> data;

    public InBoxAdapter(List<Card> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ProjectFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_fragment_item, parent, false);
        return new ProjectFragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectFragmentViewHolder holder, int position) {
        Card model = data.get(position);

        //нажатие на чекбокс
        holder.itemView.findViewById(R.id.project_fragment_checkbox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
