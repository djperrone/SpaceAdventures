package SpaceAdventures;

import java.util.Vector;

public abstract class SpaceShip extends MovableHealthyObject {

    protected DefaultSpaceShipGun gun;

    public void fireGun()
    {
        this.gun.spawnProjectile(xPosition,yPosition,team,direction);
    }

    public Gun getGun()
    {
        return  this.gun;
    }

}
