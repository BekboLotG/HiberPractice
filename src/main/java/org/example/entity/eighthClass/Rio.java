package org.example.entity.eighthClass;


import javax.persistence.*;

@Entity
@Table(name = "rio")
public class Rio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String nickname;
    private String species;
    private String dislike;
    private String quote;

    public Rio() {
    }

    public Rio(String name, String nickname, String species, String dislike, String quote) {
        this.name = name;
        this.nickname = nickname;
        this.species = species;
        this.dislike = dislike;
        this.quote = quote;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDislike() {
        return dislike;
    }

    public void setDislike(String dislike) {
        this.dislike = dislike;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Rio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", species='" + species + '\'' +
                ", dislike='" + dislike + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}


