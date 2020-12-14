package com.java.eval.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artist")
public class Artist {

    @Column(name = "Name")
    private String Name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Artistid")
    private Integer Artistid;

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public void setArtistid(Integer Artistid) {
        this.Artistid = Artistid;
    }
    public Integer getArtistid() {
        return this.Artistid;
    }

    public Artist(){ }
    public Artist(String Name){ this.Name = Name;}
}
