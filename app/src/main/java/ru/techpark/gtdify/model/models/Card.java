package ru.techpark.gtdify.model.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "cards")
public class Card {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    @ColumnInfo(name = "unformatted_text")
    private String unformattedText;
    @ColumnInfo(name = "is_complete")
    private Boolean isComplete = false;
    @ColumnInfo(name = "is_delete")
    private Boolean isDelete = false;
//    private java.sql.Date date;
//    @ColumnInfo(name = "time_start")
//    private java.sql.Time timeStart;
//    @ColumnInfo(name = "time_end")
//    private java.sql.Time timeEnd;


    public Card(String name, String unformattedText) {
        this.name = name;
        this.unformattedText = unformattedText;
        this.isComplete = false;
        this.isDelete = false;
    }


//    public List<Card> getCards() {
//        return cards;
//    }
//
//    public void setCards(List<Card> cards) {
//        this.cards = cards;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnformattedText() {
        return unformattedText;
    }

    public void setUnformattedText(String unformattedText) {
        this.unformattedText = unformattedText;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Time getTimeStart() {
//        return timeStart;
//    }
//
//    public void setTimeStart(Time timeStart) {
//        this.timeStart = timeStart;
//    }
//
//    public Time getTimeEnd() {
//        return timeEnd;
//    }
//
//    public void setTimeEnd(Time timeEnd) {
//        this.timeEnd = timeEnd;
//    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
