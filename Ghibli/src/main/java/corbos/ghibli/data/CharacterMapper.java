package corbos.ghibli.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CharacterMapper implements RowMapper<corbos.ghibli.models.Character> {

    @Override
    public corbos.ghibli.models.Character mapRow(ResultSet rs, int i) throws SQLException {
        corbos.ghibli.models.Character result = new corbos.ghibli.models.Character();
        result.setCharacterId(rs.getInt("characterid"));
        result.setName(rs.getString("name"));
        return result;
    }

}
