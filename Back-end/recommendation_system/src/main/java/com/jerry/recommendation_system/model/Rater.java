package com.jerry.recommendation_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Rater {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    @JsonProperty
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rater", cascade = CascadeType.ALL)
    private List<Rating> myRatings;

    public Rater(Long id) {
        this.id = id;
    }


//    public boolean hasRating(String item) {
//        return myRatings.containsKey(item);
//    }

    public Long getID() {
        return id;
    }

//    public double getRating(String item) {
//
//        if (hasRating(item)) {
//            return this.myRatings.get(item).getValue();
//        }
//
//        return -1;
//
//    }

    public int numRatings() {
        return myRatings.size();
    }

//    public ArrayList<String> getItemsRated() {
//        return new ArrayList<>(this.myRatings.keySet());
//    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
