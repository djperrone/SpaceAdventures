package SpaceAdventures;

import java.awt.event.MouseAdapter;
import java.util.Vector;


public abstract class Gun {//extends MouseAdapter {

    protected Vector<Projectile> projectileList;

    abstract void spawnProjectile(float xPosition, float yPosition, Team team, float direction);
    abstract Vector<Projectile> getProjectileList();
    abstract void clearProjectileList();
}

