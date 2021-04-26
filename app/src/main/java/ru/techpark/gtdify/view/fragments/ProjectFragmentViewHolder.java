package ru.techpark.gtdify.view.fragments;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.techpark.gtdify.R;
import ru.techpark.gtdify.model.models.Card;

public class ProjectFragmentViewHolder extends RecyclerView.ViewHolder {

    private final TextView title;
    private final CheckBox check;

    public ProjectFragmentViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.project_fragment_title);
        check = itemView.findViewById(R.id.project_fragment_checkbox);
    }

    @SuppressLint("SetTextI18n")
    public void bind(Card model){
        title.setText(model.getName());
        check.setChecked(model.getComplete());
        //нажатие на текст
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
