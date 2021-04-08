package SpaceAdventures;

public abstract class SpaceShip extends MovableHealthyObject {

    Gun gun;

    public SpaceShip(float xPosition, float yPosition,GameManager manager)
    {
        super(xPosition, yPosition, manager);
    }

    public SpaceShip(float xPosition, float yPosition) {
        super();
    }

    public SpaceShip() {
        super();

    }

    abstract void fireGun();

    public void tick() {
    }
}
