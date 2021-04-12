
package SpaceAdventures;

public class UFO extends SpaceShip{

    public UFO(float xPosition, float yPosition, GameManager manager, String texture) {
        super();
    }

    public UFO(float xPosition, float yPosition) {
        super(xPosition, yPosition);
    }

    @Override
    void fireGun() {

    }

    @Override
    public void accept(CollideVisitor visitor) {
        visitor.collide(this);
    }

    @Override
    public CollideVisitor getCollideHandler() {
        return new UFOCollideVisitor(this);
    }
}

package SpaceAdventures;

public class UFO extends SpaceShip{

    public UFO(float xPosition, float yPosition, GameManager manager, String texture) {
        super();
    }

    public UFO(float xPosition, float yPosition) {
        super(xPosition, yPosition);
    }

    @Override
    void fireGun() {

    }
}

