/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.projectpony.dao;

import ajplarson.projectpony.models.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author ajplarson
 */
@Repository
public class ColorDao {
    
    @Autowired
    JdbcTemplate jdbc;
    
    public Color getColorById(int id) {
        final String sql = "SELECT * FROM color WHERE colorId = ?";
        return jdbc.query(sql, new ColorMapper(), id).get(0);
    }
    
    public List<Color> getAllColors() {
        final String sql = "SELECT * FROM color";
        List<Color> colors = jdbc.query(sql, new ColorMapper());
        return colors;
    }
    
    public static final class ColorMapper implements RowMapper<Color> {
        
        @Override
        public Color mapRow(ResultSet rs, int index) throws SQLException {
            Color color = new Color();
            color.setColorId(rs.getInt("colorId"));
            color.setColorName(rs.getString("colorName"));
            return color;
        }
    }
    
}
