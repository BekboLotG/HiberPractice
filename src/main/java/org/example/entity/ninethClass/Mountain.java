package org.example.entity.ninethClass;

import javax.persistence.*;

@Entity
@Table(name = "mountains")
public class Mountain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String peak;
    @Column(name = "mountain_island")
    private String mountain;
    @Column
    private String location;
    @Column
    private double prominence;
    @Column
    private double height;

    public Mountain() {
    }

    public Mountain(String peak, String mountain, String location, double prominence, double height) {
        this.peak = peak;
        this.mountain = mountain;
        this.location = location;
        this.prominence = prominence;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeak() {
        return peak;
    }

    public void setPeak(String peak) {
        this.peak = peak;
    }

    public String getMountain() {
        return mountain;
    }

    public void setMountain(String mountain) {
        this.mountain = mountain;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getProminence() {
        return prominence;
    }

    public void setProminence(double prominence) {
        this.prominence = prominence;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "id=" + id +
                ", peak='" + peak + '\'' +
                ", mountain='" + mountain + '\'' +
                ", location='" + location + '\'' +
                ", prominence=" + prominence +
                ", height=" + height +
                '}';
    }
}
