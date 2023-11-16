package com.example.faces.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "track")
public class Track {
    @Id
    @Column(name = "TrackId", nullable = false)
    private Integer id;

    @Size(max = 200)
    @NotNull
    @Column(name = "Name", nullable = false, length = 200)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AlbumId")
    private Album album;

    @Size(max = 220)
    @Column(name = "Composer", length = 220)
    private String composer;

    @NotNull
    @Column(name = "Milliseconds", nullable = false)
    private Integer milliseconds;

    @Column(name = "Bytes")
    private Integer bytes;

    @NotNull
    @Column(name = "UnitPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

}