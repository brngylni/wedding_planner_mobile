package com.example.wedding_planner.models;

public class Wedding {
    private int id;
    private String name;
    private String date;
    private String time;
    private int dinner_option;
    private int guests;
    private int band_option;
    private int photographer_option;
    private int alcohol;
    private Dinner_Menu dinner_menu;
    private int photographer_id;
    private int band_id;
    private int user_id;

    public Wedding(int id, String name, String date, String time, int dinner_option, int guests, int band_option, int photographer_option, int alcohol, Dinner_Menu dinner_menu, int photographer_id, int band_id, int user_id) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.dinner_option = dinner_option;
        this.guests = guests;
        this.band_option = band_option;
        this.photographer_option = photographer_option;
        this.alcohol = alcohol;
        this.dinner_menu = dinner_menu;
        this.photographer_id = photographer_id;
        this.band_id = band_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDinner_option() {
        return dinner_option;
    }

    public void setDinner_option(int dinner_option) {
        this.dinner_option = dinner_option;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public int getBand_option() {
        return band_option;
    }

    public void setBand_option(int band_option) {
        this.band_option = band_option;
    }

    public int getPhotographer_option() {
        return photographer_option;
    }

    public void setPhotographer_option(int photographer_option) {
        this.photographer_option = photographer_option;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    public Dinner_Menu getDinner_menu() {
        return dinner_menu;
    }

    public void setDinner_menu(Dinner_Menu dinner_menu) {
        this.dinner_menu = dinner_menu;
    }

    public int getPhotographer_id() {
        return photographer_id;
    }

    public void setPhotographer_id(int photographer_id) {
        this.photographer_id = photographer_id;
    }

    public int getBand_id() {
        return band_id;
    }

    public void setBand_id(int band_id) {
        this.band_id = band_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
