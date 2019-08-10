/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.projectpony.dao;

import ajplarson.projectpony.models.Color;
import ajplarson.projectpony.models.Pony;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ajplarson
 */
@Repository
public class PonyDao {

    @Autowired
    JdbcTemplate jdbc;

    @Transactional
    public Pony addPony(Pony pony) {
        final String sql = "INSERT INTO pony(ponyName, colorId) VALUES(?,?);";
        jdbc.update(sql,
                pony.getPonyName(),
                pony.getForeignColorId());
        return jdbc.queryForObject("SELECT * from pony where ponyName = ?", new PonyMapper(), pony.getPonyName());
    }

    @Transactional
    public void updatePony(Pony pony) {
        final String sql = "UPDATE pony SET ponyName = ?, colorId = ? WHERE ponyId = ?";
        jdbc.update(sql,
                pony.getPonyName(),
                pony.getForeignColorId(),
                pony.getPonyId());
    }

    public void deletePonyById(int id) {
        final String sql = "DELETE FROM pony WHERE ponyId = ?";
        jdbc.update(sql, id);
    }

    public Pony getPonyById(int id) {
        final String sql = "SELECT * FROM pony WHERE ponyId = ?";
        if(jdbc.query(sql, new PonyMapper(), id).size() == 0) {
            return null;
        } else {
            return jdbc.query(sql, new PonyMapper(), id).get(0);
        }
    }
    
     public Pony getPonyByName(String name) {
        final String sql = "SELECT * FROM pony WHERE ponyName = ?";
        if(jdbc.query(sql, new PonyMapper(), name).size() == 0) {
            return null;
        } else {
            return jdbc.query(sql, new PonyMapper(), name).get(0);
        }
    }

    public List<Pony> getAllPonies() {
        final String sql = "SELECT * FROM pony";
        List<Pony> ponies = jdbc.query(sql, new PonyMapper());
        return ponies;
    }

    public static final class PonyMapper implements RowMapper<Pony> {

        @Override
        public Pony mapRow(ResultSet rs, int index) throws SQLException {
            Pony pony = new Pony();
            pony.setForeignColorId(rs.getInt("colorId"));
            pony.setPonyId(rs.getInt("ponyId"));
            pony.setPonyName(rs.getString("ponyName"));
            return pony;
        }
    }
}
