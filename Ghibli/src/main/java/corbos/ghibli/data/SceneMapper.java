package corbos.ghibli.data;

import corbos.ghibli.models.Scene;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SceneMapper implements RowMapper<Scene> {
    
    @Override
    public Scene mapRow(ResultSet rs, int i) throws SQLException {
        Scene result = new Scene();
        result.setSceneId(rs.getInt("sceneid"));
        result.setName(rs.getString("name"));
        return result;
    }
    
}
