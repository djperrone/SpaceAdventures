package SpaceAdventures;

import java.util.Vector;

public abstract class SpaceShip extends MovableHealthyObject {

    DefaultSpaceShipGun gun;
    Vector<Projectile> ammo;

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
