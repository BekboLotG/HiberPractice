package org.example.entity.fifthClass;

import javax.persistence.*;

@Entity
@Table(name = "oogway")
public class OogwayStudents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String species;
    private String eyeColor;
    private String clothing;
    @Column(name = "G")
    private char gender;
    private int age;
    private String residence;

    public OogwayStudents() {
    }

    public OogwayStudents(String name, String species, String eyeColor, String clothing, char gender, int age, String residence) {
        this.name = name;
        this.species = species;
        this.eyeColor = eyeColor;
        this.clothing = clothing;
        this.gender = gender;
        this.age = age;
        this.residence = residence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getClothing() {
        return clothing;
    }

    public void setClothing(String clothing) {
        this.clothing = clothing;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    @Override
    public String toString() {
        return "OogwayStudents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", clothing='" + clothing + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", residence='" + residence + '\'' +
                '}';
    }
}
