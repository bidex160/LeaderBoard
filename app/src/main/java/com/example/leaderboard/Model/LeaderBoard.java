package com.example.leaderboard.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaderBoard {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hours")
    @Expose
    private String hours;
    @SerializedName("image")
    @Expose
    private int image;

    public LeaderBoard(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "LeaderBoard{" +
                "name='" + name + '\'' +
                ", hours='" + hours + '\'' +
                ", image=" + image +
                '}';
    }
}
