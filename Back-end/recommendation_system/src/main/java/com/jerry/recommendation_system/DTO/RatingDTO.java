package com.jerry.recommendation_system.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDTO {

    @JsonProperty
    private String raterUsername;

    @JsonProperty
    private String movieName;

    @JsonProperty
    private double value;
}
