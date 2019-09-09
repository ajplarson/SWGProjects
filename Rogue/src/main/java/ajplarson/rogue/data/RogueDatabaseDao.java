package ajplarson.rogue.data;

import ajplarson.rogue.models.Entity;
import ajplarson.rogue.models.Square;
import ajplarson.rogue.models.SquareContent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RogueDatabaseDao implements RogueDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RogueDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Square> getAllMapRow(){
        final String sql = "Select * from Square s join squarecontent sc on s.squarecontentid = sc.squarecontentid";
        return jdbcTemplate.query(sql, new SquareMapper());
    }
    
    public List<Entity> getAllEntities() {
        final String sql = "Select * from Entity e join Square s on s.squareid = e.squareid inner join squarecontent sc on s.squarecontentid = sc.squarecontentid";
        return jdbcTemplate.query(sql, new EntityMapper());
    }
    
    public void updateEntity(Entity entity){
         final String sql = "UPDATE entity SET "
                + "squareid = ?,"
                 + "type = ? "
                + "WHERE name = ?;";
         int squareid=getSquareId(entity);
        jdbcTemplate.update(sql,
                squareid,
                entity.getType(),
                entity.getName());
        
    }
//    @Override
//    public ToDo add(ToDo todo) {
//
//        final String sql = "INSERT INTO todo(todo, note) VALUES(?,?);";
//        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
//
//        jdbcTemplate.update((Connection conn) -> {
//
//            PreparedStatement statement = conn.prepareStatement(
//                sql, 
//                Statement.RETURN_GENERATED_KEYS);
//
//            statement.setString(1, todo.getTodo());
//            statement.setString(2, todo.getNote());
//            return statement;
//
//        }, keyHolder);
//
//        todo.setId(keyHolder.getKey().intValue());
//
//        return todo;
//    }
//
//    @Override
//    public List<ToDo> getAll() {
//        final String sql = "SELECT id, todo, note, finished FROM todo;";
//        return jdbcTemplate.query(sql, new ToDoMapper());
//    }
//
//    @Override
//    public ToDo findById(int id) {
//
//        final String sql = "SELECT id, todo, note, finished "
//                + "FROM todo WHERE id = ?;";
//
//        return jdbcTemplate.queryForObject(sql, new ToDoMapper(), id);
//    }
//
//    @Override
//    public boolean update(ToDo todo) {
//
//        final String sql = "UPDATE todo SET "
//                + "todo = ?, "
//                + "note = ?, "
//                + "finished = ? "
//                + "WHERE id = ?;";
//
//        return jdbcTemplate.update(sql,
//                todo.getTodo(),
//                todo.getNote(),
//                todo.isFinished(),
//                todo.getId()) > 0;
//    }
//
//    @Override
//    public boolean deleteById(int id) {
//        final String sql = "DELETE FROM todo WHERE id = ?;";
//        return jdbcTemplate.update(sql, id) > 0;
//    }
//

    private int getSquareId(Entity entity) {
        List<Square> list= getAllMapRow();
        int squareid=0;
        
        for(Square s: list){
            if(entity.getCurrentSquare().getXcoord()==s.getXcoord()&&entity.getCurrentSquare().getYcoord()==s.getYcoord()){
                squareid=s.getSquareId();
                break;
            }
        }
        
        return squareid;
    }

      private static final class SquareMapper implements RowMapper<Square> {
        @Override
        public Square mapRow(ResultSet rs, int index) throws SQLException {
            return new Square(new SquareContent(rs.getBoolean("valid"),rs.getInt("squarecontentid")),rs.getInt("xcoord"),rs.getInt("ycoord"),rs.getInt("squareId"));
        }
        
    }
      
      private static final class EntityMapper implements RowMapper<Entity> {
        @Override
        public Entity mapRow(ResultSet rs, int i) throws SQLException {
            Entity e = new Entity();
            e.setName(rs.getString("name"));
            e.setType(rs.getString("type"));
            e.setCurrentSquare(new Square(new SquareContent(rs.getBoolean("valid"),rs.getInt("squarecontentid")),rs.getInt("xcoord"),rs.getInt("ycoord"),rs.getInt("squareId")));
            return e;
        }
      } 
}
