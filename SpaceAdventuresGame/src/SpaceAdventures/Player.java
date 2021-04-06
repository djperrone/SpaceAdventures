package SpaceAdventures;

public class Player extends SpaceShip {


    public Player(float xPosition, float yPosition, GameManager manager, String texture) {
        super(xPosition, yPosition);
    }

    public Player(float xPosition, float yPosition) {
        super(xPosition, yPosition);
    }

    public Player() {
        super();
    }

    @Override
    void fireGun() {

    }
}
