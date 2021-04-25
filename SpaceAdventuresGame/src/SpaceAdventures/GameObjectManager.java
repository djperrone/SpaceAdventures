
package SpaceAdventures;

import java.util.LinkedList;
import java.util.Iterator;


public class GameObjectManager {

    private Player player;

    private LinkedList<MovableHealthyObject> movableHealthyObjectList;
    private LinkedList<SpaceShip> spaceshipList;
    private Dimensions dimensions;

    private Spawner spawner;
    private CollisonManager collisonManager;
    private ProjectileManager projectileManager;


    GameObjectManager()
    {
        movableHealthyObjectList = new LinkedList<>();
        spaceshipList = new LinkedList<>();

        collisonManager = new CollisonManager();
        projectileManager = new ProjectileManager();
        spawner = new Spawner(movableHealthyObjectList, spaceshipList);

        initPlayer();
        dimensions = new Dimensions();
    }

    private void initPlayer()
    {
        player = spawner.spawnPlayer();
        movableHealthyObjectList.add(player);
        spaceshipList.add(player);
    }

    public void tick()
    {
        loadAllProjectiles();
        checkForCollisionEvents();
        cleanAllLists();
        spawnAll();

        for(Iterator<MovableHealthyObject> it = movableHealthyObjectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();
            tempObject.tick();
        }

        //System.out.println(this.spaceshipList.size() + "spacelist size");
        //System.out.println(this.movableHealthyObjectList.size() + "movableHealthyObject size");
    }
    private void checkForCollisionEvents()
    {
        collisonManager.checkForCollisionEvents(movableHealthyObjectList);
    }

    private void loadAllProjectiles()
    {
        projectileManager.loadAllProjectiles(spaceshipList);
        movableHealthyObjectList.addAll(projectileManager.getProjectileList());
        projectileManager.clearProjectileList();
    }

    private void cleanMovableHealthyObjectList()
    {
        for(Iterator<MovableHealthyObject> it = movableHealthyObjectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();

            if(!tempObject.isAlive() || !isWithinBounds(tempObject))
            {
                it.remove();
                if(player == tempObject){
                    System.out.println("player removed");
                }
                else{
                    System.out.println("something removed");
                }
            }
        }
    }

    private void cleanSpaceshipList()
    {
        for(Iterator<SpaceShip> it = spaceshipList.iterator(); it.hasNext();)
        {
            SpaceShip tempObject = it.next();

            if(!tempObject.isAlive() || !isWithinBounds(tempObject))
            {
                it.remove();
                if(player == tempObject){
                    System.out.println("player removed");
                }
                else{
                    System.out.println("something removed");
                }
            }
        }
    }



    private void cleanAllLists()
    {
       cleanMovableHealthyObjectList();
       cleanSpaceshipList();
    }



    public boolean isWithinBounds(MovableHealthyObject tempObject)
    {
        if(tempObject.getxPosition() < 0 || tempObject.getyPosition() > dimensions.MAX_SURVIVABLE_Y  ||
                tempObject.getxPosition() > dimensions.WIDTH * .99 || tempObject.getyPosition() < dimensions.MIN_SURVIVABLE_Y)
        {
            System.out.println("Destroyed asteroid/projectile");
            //tempObject.setHealth(0);
            return false;
        }

        return true;
    }


    private void spawnAll()
    {
        spawner.spawnAllObjects();
    }


    // Function returns object list in array form
    public MovableHealthyObject[] getFrozenObjectList()
    {
        return movableHealthyObjectList.toArray(new MovableHealthyObject[movableHealthyObjectList.size()]);
    }

    public Player getPlayer()
    {
        return this.player;
    }


}