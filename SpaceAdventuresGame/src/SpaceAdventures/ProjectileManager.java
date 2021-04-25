package SpaceAdventures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/**
 * ProjectileManager class is responsible for aggregating a collection of all projectiles from all spaceships
 * It returns this list so that GameObjectManager can add the projectiles to the main list of objects *
 */

public class ProjectileManager {

    //private LinkedList<Projectile> projectileList;
    private Vector<Projectile> projectileList;

    public ProjectileManager()
    {
        projectileList = new Vector<>();
    }

    public Vector<Projectile> getProjectileList()
    {
        return this.projectileList;
    }

    public void clearProjectileList()
    {
        this.projectileList.clear();
    }

    /**
     * iterates through spaceship list, aggregates projectiles, clears each spaceship gun of projectiles
     * @param spaceshipList
     */
    public void loadAllProjectiles(LinkedList<SpaceShip> spaceshipList)
    {
        for(Iterator<SpaceShip> it = spaceshipList.iterator(); it.hasNext();)
        {
            SpaceShip tempSpaceship = it.next();

            this.projectileList.addAll(tempSpaceship.getGun().getProjectileList());

            tempSpaceship.getGun().clearProjectileList();
        }

    }

//    public void handleProjectiles(LinkedList<SpaceShip> spaceshipList)
//    {
//        loadAllProjectiles(spaceshipList);
//        clearProjectileList();
//    }
}
