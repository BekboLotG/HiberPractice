package org.example.entity.thirdClass;


import javax.persistence.*;

@Entity
@Table(name = "madagascar")
public class NYC_Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String nickName;
    private String enemies;
//    @Column(name = "eye's color")
    private String color;
    private char gender;
    private String family;

    public NYC_Zoo() {
    }

    public NYC_Zoo(String fullName, String nickName, String enemies, String color, char gender, String family) {
        this.fullName = fullName;
        this.nickName = nickName;
        this.enemies = enemies;
        this.color = color;
        this.gender = gender;
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEnemies() {
        return enemies;
    }

    public void setEnemies(String enemies) {
        this.enemies = enemies;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "NYC_Zoo{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", enemies='" + enemies + '\'' +
                ", color='" + color + '\'' +
                ", gender=" + gender +
                ", family='" + family + '\'' +
                '}';
    }
}
