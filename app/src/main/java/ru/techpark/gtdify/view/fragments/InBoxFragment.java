package ru.techpark.gtdify.view.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import ru.techpark.gtdify.R;
import ru.techpark.gtdify.model.database.DatabaseClient;
import ru.techpark.gtdify.model.models.Card;

public class InBoxFragment extends ProjectFragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(), "Карточка сохарнена", Toast.LENGTH_LONG).show();
        View view = inflater.inflate(R.layout.project_fragment, container, false);
        recyclerView = view.findViewById(R.id.ProjectFragmentFeed);
        recyclerView.setItemViewCacheSize(100);
        Context applicationContext = recyclerView.getContext().getApplicationContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(applicationContext));
//        recyclerView.setAdapter(adapter);
        FloatingActionButton fab = view.findViewById(R.id.floating_button);

        //нажатие на желтую кнопку
        fab.setOnClickListener(view1 -> {

        });
        getTasks();
        return view;
    }

    private void getTasks() {
        class GetTasks extends AsyncTask<Void, Void, List<Card>> {

            @Override
            protected List<Card> doInBackground(Void... voids) {
                List<Card> taskList = DatabaseClient
                        .getInstance(getContext())
                        .getAppDatabase()
                        .cardDAO()
                        .getAll();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<Card> cards) {
                super.onPostExecute(cards);
                InBoxAdapter adapter = new InBoxAdapter(cards);
                recyclerView.setAdapter(adapter);
            }
        }

        GetTasks gt = new GetTasks();
        gt.execute();
    }
}
