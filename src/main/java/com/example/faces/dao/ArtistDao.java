package com.example.faces.dao;

import com.example.faces.data.Artist;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ArtistDao {
    @Resource(name = "jdbc/chinookMsql")
    private DataSource ds;

    public List<Artist> findAll() {

        List<Artist> artists = new ArrayList<>();
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from Artist");
             ResultSet rs = statement.executeQuery();
        ) {
            while (rs.next()) {
                int id = rs.getInt("ArtistId");
                String name = rs.getString("Name");
                artists.add(new Artist(id, name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return artists;
    }


    public void add(Artist artist) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into Artist (Name) values (?)");
        ) {
            ps.setString(1, artist.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from Artist where ArtistId = ?");
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
