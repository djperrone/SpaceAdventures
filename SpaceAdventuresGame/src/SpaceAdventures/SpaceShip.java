package SpaceAdventures;

import java.util.Vector;

public abstract class SpaceShip extends MovableHealthyObject {

    protected DefaultSpaceShipGun gun;
    //Vector<Projectile> projectileList;

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
