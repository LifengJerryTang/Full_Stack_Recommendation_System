package com.jerry.recommendation_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Rating implements Comparable<Rating> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rater_id")
    @JsonProperty
    private Rater rater;

    @JsonProperty
    @JoinColumn(name = "movie_id")
    @ManyToOne
    private Movie movieItem;

    private double value;

    public Rating (Movie movieItem, double value) {
        this.movieItem = movieItem;
        this.value = value;
    }

    public String toString () {
        return "[" + getMovieItem() + ", " + getValue() + "]";
    }

    public int compareTo(Rating other) {
        return Double.compare(value, other.value);
    }

}
