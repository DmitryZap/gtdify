package ru.techpark.gtdify.view.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

import ru.techpark.gtdify.R;
import ru.techpark.gtdify.model.database.DatabaseClient;
import ru.techpark.gtdify.model.models.Card;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_activity);

        initToolbar();
        initSelectDialog();
        initAddButton();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void initSelectDialog() {
        View selectData = findViewById(R.id.selectData);
        Calendar dateAndTime = Calendar.getInstance();
        selectData.setOnClickListener(v -> {
            new DatePickerDialog(this, (DatePickerDialog.OnDateSetListener) (datePicker, i, i1, i2) -> {

            }, dateAndTime.get(Calendar.YEAR), dateAndTime.get(Calendar.MONTH), dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
        });
    }

    private void initAddButton() {
        FloatingActionButton addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(view -> {
            EditText editTextCardName = findViewById(R.id.editTextCardName);
            EditText editTextCardText = findViewById(R.id.editTextCardText);

            class SaveTask extends AsyncTask<Void, Void, Void> {

                @Override
                protected Void doInBackground(Void... voids) {

                    DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                            .cardDAO()
                            .insert(new Card(editTextCardName.getText().toString(), editTextCardText.getText().toString()));
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getApplicationContext(), "Карточка сохарнена", Toast.LENGTH_LONG).show();
                }
            }

            SaveTask st = new SaveTask();
            st.execute();
        });
    }

}
