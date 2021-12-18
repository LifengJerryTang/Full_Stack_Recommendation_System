package com.jerry.recommendation_system.model;

import javax.persistence.*;

@Entity
@Table
public class Rating implements Comparable<Rating> {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rater_id")
    private Rater rater;

    private String item;

    private double value;

    public Rater getRater() {
        return rater;
    }

    public Rating (String anItem, double aValue) {
        item = anItem;
        value = aValue;
    }

    public String getItem () {
        return item;
    }

    public double getValue () {
        return value;
    }

    public String toString () {
        return "[" + getItem() + ", " + getValue() + "]";
    }

    public int compareTo(Rating other) {
        return Double.compare(value, other.value);
    }
}
