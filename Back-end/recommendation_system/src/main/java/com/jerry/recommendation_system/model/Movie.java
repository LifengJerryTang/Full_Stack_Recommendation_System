package com.jerry.recommendation_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    private String title;

    @JsonProperty
    private int year;

    @JsonProperty
    private String genres;

    @JsonProperty
    private String director;

    @JsonProperty
    private String country;

    @JsonProperty
    private String poster;

    @JsonProperty
    private int minutes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieItem", cascade = CascadeType.ALL)
    @JsonProperty
    List<Rating> ratings;

    public Movie(String title, int year, String genres,
                 String director, String country,
                 String poster, int minutes) {
        this.title = title;
        this.year = year;
        this.genres = genres;
        this.director = director;
        this.country = country;
        this.poster = poster;
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genres='" + genres + '\'' +
                ", director='" + director + '\'' +
                ", country='" + country + '\'' +
                ", poster='" + poster + '\'' +
                ", minutes=" + minutes +
                '}';
    }
}
