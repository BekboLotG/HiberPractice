package org.example.entity.secondClass;

import org.hibernate.type.LocalDateTimeType;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="sugar_rush")
public class SugarRushRaces {
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
//    @Column(name = "2ndName")
    private String SecondName;
    private int age;
    private String hobbies;
    private String home;
    private String dislikes;
    private LocalDate birth;

    public SugarRushRaces() {
    }

    public SugarRushRaces(String name, String secondName, int age, String hobbies,
                          String home, String dislikes, LocalDate birth) {
        this.name = name;
        SecondName = secondName;
        this.age = age;
        this.hobbies = hobbies;
        this.home = home;
        this.dislikes = dislikes;
        this.birth = birth;
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

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getDislikes() {
        return dislikes;
    }

    public void setDislikes(String dislikes) {
        this.dislikes = dislikes;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "SugarRushRaces{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", age=" + age +
                ", hobbies='" + hobbies + '\'' +
                ", home='" + home + '\'' +
                ", dislikes='" + dislikes + '\'' +
                ", birth=" + birth +
                '}';
    }
}
