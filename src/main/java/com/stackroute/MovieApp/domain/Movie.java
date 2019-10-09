package com.stackroute.MovieApp.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    private int id;
    private String title;
    private String overview;
    private int vote_count;
    private String release_date;

    public Movie(){}

    public Movie(String title, String overview, int id, int vote_count, String release_date) {
        this.title = title;
        this.overview = overview;
        this.id = id;
        this.vote_count = vote_count;
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", id=" + id +
                ", vote_count=" + vote_count +
                ", release_date='" + release_date + '\'' +
                '}';
    }
}
