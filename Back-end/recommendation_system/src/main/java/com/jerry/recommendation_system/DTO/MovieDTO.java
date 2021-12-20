package com.jerry.recommendation_system.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDTO {

    @Nationalized
    @JsonProperty
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
}
