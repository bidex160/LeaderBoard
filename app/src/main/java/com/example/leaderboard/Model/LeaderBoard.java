package com.example.leaderboard.Model;

public class LeaderBoard {
    private String name;
    private String hours;
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
