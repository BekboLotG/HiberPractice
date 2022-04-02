package org.example.entity.fourthClass;

import javax.persistence.*;

@Entity
@Table(name = "coco")
public class Coco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private String music;
    private String phrase;
    private boolean isAlive;
    private String address;

    public Coco() {
    }

    public Coco(String name, String surname, String music, String phrase, boolean isAlive, String address) {
        this.name = name;
        this.surname = surname;
        this.music = music;
        this.phrase = phrase;
        this.isAlive = isAlive;
        this.address = address;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Coco{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", music='" + music + '\'' +
                ", phrase='" + phrase + '\'' +
                ", isAlive=" + isAlive +
                ", address='" + address + '\'' +
                '}';
    }
}