package ajplarson.rogue.data;

import ajplarson.rogue.models.Entity;
import ajplarson.rogue.models.Square;
import java.util.List;

public interface RogueDao {

    public List<Square> getAllMapRow();

    public void updateEntity(Entity entity);
    

    public List<Entity> getAllEntities();
}
