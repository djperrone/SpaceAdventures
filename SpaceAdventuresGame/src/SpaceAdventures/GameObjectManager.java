
package SpaceAdventures;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import java.util.Iterator;


public class GameObjectManager {

    private Player player;
    private Renderer renderer;
    private Spawner spawner;
    private LinkedList<MovableHealthyObject> objectList;
    private LinkedList<UFO> UFOlist;
    private HealthBar healthbar;


    GameObjectManager()
    {
        this.player = new Player();
        objectList = new LinkedList<MovableHealthyObject>();
        objectList.add(player);
        UFOlist = new LinkedList<UFO>();
        spawner = new Spawner(objectList, UFOlist);
        this.healthbar = new HealthBar();
        LinkedList<MovableHealthyObject> otherList = objectList;
    }

    public void tick()
    {
        loadAllProjectiles();
        checkForCollisionEvents();
        updateList();
        spawnAll();

        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();
            tempObject.tick();
        }
    }

    public Player getPlayer()
    {
        return this.player;
    }

    public void loadPlayerProjectiles()
    {
        this.objectList.addAll(player.getGun().getProjectileList());

        this.player.getGun().clearProjectileList();
    }

    public void loadUFOProjectiles()
    {
        for(Iterator<UFO> it = UFOlist.iterator(); it.hasNext();)
        {
            UFO tempObject = it.next();

            this.objectList.addAll(tempObject.getGun().getProjectileList());

            tempObject.getGun().clearProjectileList();
        }
    }

    public void loadAllProjectiles()
    {
        loadPlayerProjectiles();
        loadUFOProjectiles();
    }

    public void render(Graphics g, BufferStrategy bs, MovableHealthyObject[] objectArray)
    {
        healthbar.render(g, (int) player.getHealth());
        for(MovableHealthyObject object : objectArray)
        {
            renderer.render(g,bs,object.getImageBuffer(), (int)object.getxPosition(), (int)object.getyPosition());
        }
    }

    public void updateList()
    {
        spawner.cleanObjectList();

        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();

            if(!tempObject.isAlive())
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

    public void checkForCollisionEvents()
    {
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject currentObject = it.next();

            for(Iterator<MovableHealthyObject> otherIt = objectList.iterator(); otherIt.hasNext();)
            {
                MovableHealthyObject other = otherIt.next();
                if(isColliding(currentObject, other)){
                    //System.out.println("Collision " + isOnSameTeam(currentObject, other));
                }
                if(!isOnSameTeam(currentObject, other) && isColliding(currentObject, other)){
                    //System.out.println("Collision Detected");
                    handleCollisionEvent(currentObject,other);
                }
            }
        }
    }

    public boolean isOnSameTeam(MovableHealthyObject currentObject, MovableHealthyObject other)
    {
        return currentObject.team == other.team;
    }

    public boolean isColliding(MovableHealthyObject objectA, MovableHealthyObject objectB)
    {
        return objectA.getBounds().intersects(objectB.getBounds());
    }

    public void handleCollisionEvent(MovableHealthyObject objectA, MovableHealthyObject objectB)
    {
        objectA.accept(objectB.getCollideHandler());
    }

    public void spawnAll()
    {
        spawner.spawnAllObjects();
    }

    public Renderer getRenderer()
    {
        return this.renderer;
    }

    // Function returns object list in array form
    public MovableHealthyObject[] getFrozenObjectList()
    {
        return objectList.toArray(new MovableHealthyObject[objectList.size()]);
    }
}