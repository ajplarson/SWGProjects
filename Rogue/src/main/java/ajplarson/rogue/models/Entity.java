package ajplarson.rogue.models;

/**
 *
 * @author ajplarson
 */
public class Entity {

    private String name;
    private Square currentSquare;
    private String type;

    public Entity() {

    }

    public Entity(String name, Square currentSquare, String type) {
        this.name = name;
        this.currentSquare = currentSquare;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Square getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
