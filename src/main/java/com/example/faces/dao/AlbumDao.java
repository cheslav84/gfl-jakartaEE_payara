package com.example.faces.dao;

import com.example.faces.data.Album;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class AlbumDao {

    @PersistenceContext
    private EntityManager em;

    public List<Album> findAll() {
        return em.createNamedQuery("Album.findAll", Album.class).getResultList();
    }
}
