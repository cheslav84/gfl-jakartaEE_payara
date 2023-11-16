package com.example.faces.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "album")
@NamedQueries({
        @NamedQuery(name = "Album.findAll", query = "select a from Album a")
})
public class Album {
    @Id
    @Column(name = "AlbumId", nullable = false)
    private Integer id;

    @Size(max = 160)
    @NotNull
    @Column(name = "Title", nullable = false, length = 160)
    private String title;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ArtistId", nullable = false)
    private Artist artist;

}