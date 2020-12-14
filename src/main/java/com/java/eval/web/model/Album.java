package com.java.eval.web.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "album")
public class Album {
    @ManyToOne
    @JoinColumn(name = "ArtistId")
    private Artist artist;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumId")
    private Integer Albumid;

    @Column(name = "Title")
    private String Title;

    public Artist getArtist() { return artist; }
    public void setArtist(Artist artist) { this.artist = artist; }

    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }

    public void setAlbumid(Integer Albumid) {
        this.Albumid = Albumid;
    }
    public Integer getAlbumid() {
        return this.Albumid;
    }

    public Album(){}
    public Album(String Title){this.Title = Title;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(artist, album.artist) &&
                Objects.equals(Albumid, album.Albumid) &&
                Objects.equals(Title, album.Title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, Albumid, Title);
    }

    @Override
    public String toString() {
        return "Album{" +
                ", title='" + Title + '\'' +
                '}';
    }
}
