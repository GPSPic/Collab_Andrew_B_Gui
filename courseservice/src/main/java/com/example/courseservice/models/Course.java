package com.example.courseservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String town;

    @Column
    private double starRating;

    @JsonIgnoreProperties({"course"})
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Booking> courseBookings;

    public Course() {
    }

    public Course(String name, String town, double starRating) {
        this.name = name;
        this.town = town;
        this.starRating = starRating;
        this.courseBookings = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public double getStarRating() {
        return starRating;
    }

    public void setStarRating(double starRating) {
        this.starRating = starRating;
    }

    public List<Booking> getBookings() {
        return courseBookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.courseBookings = bookings;
    }

    public void addBooking(Booking booking) {
        this.courseBookings.add(booking);
    }
}
