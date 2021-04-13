
package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Vector;

// FriendProjectile and EnemyProjectile
// or Projectile(Team)
// iterator cannot access current element or previous....cant change objects in enhanced for loop
public class GameManager {
    public static final int WIDTH = 1280, HEIGHT = WIDTH/12 *9;
    private BufferedImage img;

    private Game game;
    private Player player;
    private Renderer renderer;
    private Spawner spawner;
    private LinkedList<MovableHealthyObject> objectList;

    private long asteroidPreviousTime;
    private long asteroidCurrentTime;
    private long UFOPreviousTime;
    private long UFOCurrentTime;



    //    GameManager(Game game,Player player)
//    {
//        this.game = game;
//        this.renderer = new Renderer();
//        this.player = player;
//        objectList = new LinkedList<MovableHealthyObject>();
//        objectList.add(player);
//        spawner = new Spawner(objectList);
//        previousTime = System.currentTimeMillis();
//        currentTime = 0;
//    }
    GameManager(Game game)
    {
        this.game = game;
        this.renderer = new Renderer();
        this.player = new Player(500,500);
        objectList = new LinkedList<MovableHealthyObject>();
        objectList.add(player);
        spawner = new Spawner(objectList);
        asteroidPreviousTime = UFOPreviousTime = System.currentTimeMillis();
        asteroidCurrentTime = UFOCurrentTime = 0;
        System.out.println(player.health);
        LinkedList<MovableHealthyObject> otherList = objectList;

    }

    public void tick()
    {
        if (!player.isAlive()) {
            System.out.println("Game Over ");
            game.stop();
        }

        loadPlayerProjectiles();
        checkForCollisionEvents();
        spawner.cleanAsteroids();
        spawner.cleanProjectiles();
        updateList();

        spawnAsteroids();
        spawnUFOs();

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

    public void render(Graphics g, BufferStrategy bs, MovableHealthyObject[] objectArray)
    {


        for(MovableHealthyObject object : objectArray)
        {
            renderer.render(g,bs,object.getImageBuffer(), (int)object.getxPosition(), (int)object.getyPosition());

        }
    }

    public void updateList()
    {
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
                    System.out.println("Collision Detected");
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

    public void spawnAsteroids()
    {
        if(asteroidCurrentTime == 0)
        {
            spawner.spawnAsteroid();


            asteroidPreviousTime = System.currentTimeMillis();
            asteroidCurrentTime = asteroidPreviousTime;
        }
        else
        {
            asteroidCurrentTime = System.currentTimeMillis();
            if(asteroidCurrentTime - asteroidPreviousTime >= 1000)
            {
                spawner.spawnAsteroid();

                asteroidPreviousTime = asteroidCurrentTime;
            }
        }
    }

    public void spawnUFOs()
    {
        if(UFOCurrentTime == 0)
        {
            spawner.spawnUFO();
            UFOPreviousTime = System.currentTimeMillis();
            UFOCurrentTime = UFOPreviousTime;
        }
        else
        {
            UFOCurrentTime = System.currentTimeMillis();
            if(UFOCurrentTime - UFOPreviousTime >= 5000)
            {
                spawner.spawnUFO();
                UFOPreviousTime = UFOCurrentTime;
            }
        }
    }


    public Renderer getRenderer()
    {
        return this.renderer;
    }

    MovableHealthyObject[] objectListToArray()
    {
        return objectList.toArray(new MovableHealthyObject[objectList.size()]);
    }


}



