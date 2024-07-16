package com.example.bebe;

public class events {
    int _id ;
    String title;
    double date;
    String description;


    public events(int _id ,String title, double date, String description) {
        this._id = _id;
        this.title = title;
        this.date = date;
        this.description = description;
    }
    public events(String title, double date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public events() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

