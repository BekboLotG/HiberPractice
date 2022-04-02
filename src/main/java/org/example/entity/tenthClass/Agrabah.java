package org.example.entity.tenthClass;

import javax.persistence.*;

@Entity
@Table(name = "agrabah_palace")
public class Agrabah {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String otherName;
    private String address;
    private String likes;

    public Agrabah() {
    }

    public Agrabah(String name, String otherName, String address, String likes) {
        this.name = name;
        this.otherName = otherName;
        this.address = address;
        this.likes = likes;
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

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Agrabah{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", otherName='" + otherName + '\'' +
                ", address='" + address + '\'' +
                ", likes='" + likes + '\'' +
                '}';
    }
}
