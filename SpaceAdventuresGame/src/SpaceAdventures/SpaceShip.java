package SpaceAdventures;

public abstract class SpaceShip extends MovableHealthyObject {

    Gun gun;

    public SpaceShip(float xPosition, float yPosition,GameManager manager, String texture)
    {
        super(xPosition, yPosition, manager,texture);
    }

    public SpaceShip(float xPosition, float yPosition) {
        super();
    }

    public SpaceShip() {
        super();

    }

    abstract void fireGun();
}
