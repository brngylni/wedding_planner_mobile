package com.example.wedding_planner.models;

public class Band {
    private int id;
    private int musicians;
    private String name;
    private String genre;
    private String song_list;

    public Band(int id, int musicians, String name, String genre, String song_list) {
        this.id = id;
        this.musicians = musicians;
        this.name = name;
        this.genre = genre;
        this.song_list = song_list;
    }

    public int getId() {
        return id;
    }

    public int getMusicians() {
        return musicians;
    }

    public void setMusicians(int musicians) {
        this.musicians = musicians;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSong_list() {
        return song_list;
    }

    public void setSong_list(String song_list) {
        this.song_list = song_list;
    }


}
