package com.jerry.recommendation_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Rater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @JsonProperty
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rater", cascade = CascadeType.ALL)
    private List<Rating> myRatings;

    public Rater(String username, String password) {
        this.username = username;
        this.password = password;
        this.myRatings = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Rater{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", myRatings=" + myRatings +
                '}';
    }

    public void addRating(Rating rating) {
        this.myRatings.add(rating);
    }
}
