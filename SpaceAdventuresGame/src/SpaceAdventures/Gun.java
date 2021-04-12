package SpaceAdventures;

import java.awt.event.MouseAdapter;


public abstract class Gun extends MouseAdapter {

    SpaceShip owner;
    Gun(SpaceShip owner)
    {
        this.owner = owner;
    }

    public Gun() {

    }

    void spawnProjectile(SpaceShip owner) {

    }


}

