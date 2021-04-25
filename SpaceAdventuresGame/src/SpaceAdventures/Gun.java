package SpaceAdventures;

import java.awt.event.MouseAdapter;
import java.util.Vector;

/**
 * Gun class is unique to spaceships
 * Allows a spaceship to create its own collection of projectiles
 * Each time a projectile would be fired, it saves the x,y position, team, and direction the projectile should fly
 * this information is later used by the projectileManager to aggregate all guns into one projectileList
 */
public abstract class Gun {

    protected Vector<Projectile> projectileList;

    abstract void spawnProjectile(float xPosition, float yPosition, Team team, float direction);
    abstract Vector<Projectile> getProjectileList();
    abstract void clearProjectileList();
}

