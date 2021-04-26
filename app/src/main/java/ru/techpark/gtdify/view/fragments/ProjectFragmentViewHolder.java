package ru.techpark.gtdify.view.fragments;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProjectFragmentViewHolder extends RecyclerView.ViewHolder {

    private final TextView title;
    private final CheckBox check;

    public ProjectFragmentViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.project_fragment_title);
        check = itemView.findViewById(R.id.project_fragment_checkbox);
    }

    @SuppressLint("SetTextI18n")
    public void bind(ProjectFragmentModel model){
        title.setText(model.mTitle);
        check.setChecked(model.mCheck);
        //нажатие на текст
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
