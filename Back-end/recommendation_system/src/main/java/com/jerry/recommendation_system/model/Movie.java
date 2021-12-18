package com.jerry.recommendation_system.model;

import org.hibernate.annotations.Nationalized;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String title;

    private int year;
    private String genres;
    private String director;
    private String country;
    private String poster;
    private int minutes;

    public Movie(Long anID, String aTitle, String aYear, String theGenres) {
        // just in case data file contains extra whitespace
        id = anID;
        title = aTitle.trim();
        year = Integer.parseInt(aYear.trim());
        genres = theGenres;
    }

    public Movie(Long anID, String aTitle, String aYear, String theGenres, String aDirector,
                 String aCountry, String aPoster, int theMinutes) {
        // just in case data file contains extra whitespace
        id = anID;
        title = aTitle.trim();
        year = Integer.parseInt(aYear.trim());
        genres = theGenres;
        director = aDirector;
        country = aCountry;
        poster = aPoster;
        minutes = theMinutes;
    }

    public Long getID () {
        return id;
    }

    public String getTitle () {
        return title;
    }

    public int getYear () {
        return year;
    }

    public String getGenres () {
        return genres;
    }

    public String getCountry(){
        return country;
    }

    public String getDirector(){
        return director;
    }

    public String getPoster(){
        return poster;
    }

    public int getMinutes(){
        return minutes;
    }

    public String toString () {
        String result = "Movie.Movie [id=" + id + ", title=" + title + ", year=" + year;
        result += ", genres= " + genres + "]";
        return result;
    }
}
