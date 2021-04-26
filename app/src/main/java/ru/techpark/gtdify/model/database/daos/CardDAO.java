package ru.techpark.gtdify.model.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.techpark.gtdify.model.models.Card;

@Dao
public interface CardDAO {
    @Query("SELECT * FROM cards")
    List<Card> getAll();

    @Insert
    void insert(Card card);

    @Delete
    void delete(Card card);

    @Update
    void update(Card card);
}
