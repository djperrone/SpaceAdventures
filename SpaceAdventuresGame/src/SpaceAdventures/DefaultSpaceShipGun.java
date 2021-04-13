package SpaceAdventures;

import java.util.Vector;

public class DefaultSpaceShipGun extends Gun{


    protected Vector<Projectile> projectileList;

    public DefaultSpaceShipGun()
    {
        this.projectileList = new Vector<Projectile>();
    }
    void spawnProjectile(float xPosition, float yPosition, Team team, float direction)
    {
        this.projectileList.add(new Projectile(xPosition, yPosition, team, direction));
    }

    Vector<Projectile> getProjectileList()
    {
        return this.projectileList;
    }
    void clearProjectileList()
    {
        this.projectileList.clear();
    }

}
