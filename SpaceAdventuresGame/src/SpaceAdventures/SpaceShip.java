package SpaceAdventures;

import java.util.Vector;

public abstract class SpaceShip extends MovableHealthyObject {

    protected DefaultSpaceShipGun gun;

    public SpaceShip(float xPosition, float yPosition) {
        super();
    }

    public SpaceShip() {
        super();
    }

    public void fireGun()
    {
        this.gun.spawnProjectile(xPosition,yPosition,team,direction);
    }

    public Gun getGun()
    {
        return  this.gun;
    }

}
