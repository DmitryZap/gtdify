package ru.techpark.gtdify.model.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.techpark.gtdify.model.database.daos.CardDAO;
import ru.techpark.gtdify.model.models.Card;

@Database(entities = {Card.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CardDAO taskDAO();
}