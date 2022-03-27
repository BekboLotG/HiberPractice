package org.example.entity.fristClass;

import javax.persistence.*;

@Entity
@Table(name = "penguin")
public class Penguin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Column(name = "address")
    private String address;
    private String song;
    private String favoritePhrase;

    public Penguin() {
    }

    public Penguin(String name, String address, String song, String favoritePhrase) {
        this.name = name;
       this.address=address;
        this.song = song;
        this.favoritePhrase = favoritePhrase;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getFavoritePhrase() {
        return favoritePhrase;
    }

    public void setFavoritePhrase(String favoritePhrase) {
        this.favoritePhrase = favoritePhrase;
    }

    @Override
    public String toString() {
        return "Penguin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", song='" + song + '\'' +
                ", favoritePhrase='" + favoritePhrase + '\'' +
                '}';
    }
}
