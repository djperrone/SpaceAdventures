package SpaceAdventures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Class used to spawn Movable Healthy Objects
 * All objects are added to a list used by Game Manager
 */
public class Spawner{
    Random r = new Random();
    LinkedList<MovableHealthyObject> objectList;
    private LinkedList<UFO> ufoList;

    //public static final int dimension.WIDTH+1 = 1280, dimensions.HEIGHT = dimension.WIDTH+1/12 *9;
    Dimensions dimensions;
    
    static int DEFAULT_UFO_Y_POSITION;
    static int DEFAULT_ASTEROID_Y_POSITION;

    private long asteroidPreviousTime;
    private long asteroidCurrentTime;
    private long UFOPreviousTime;
    private long UFOCurrentTime;
    private long ASTEROID_SPAWN_RATE = 1000;
    private long UFO_SPAWN_RATE = 5000;

    Spawner(LinkedList<MovableHealthyObject> objectList,LinkedList<UFO> ufoList, Dimensions dimensions)
    {
        this.objectList = objectList;
        this.ufoList = ufoList;
        this.dimensions = dimensions;
        DEFAULT_UFO_Y_POSITION = 10;
        DEFAULT_ASTEROID_Y_POSITION = dimensions.MIN_SURVIVABLE_Y;

        asteroidPreviousTime = UFOPreviousTime = System.currentTimeMillis();
        asteroidCurrentTime = UFOCurrentTime = 0;
    }

    /**
     * Call all of the spawn functions in one place
     */
    void spawnAllObjects()
    {
        spawnAsteroids();
        spawnUFOs();
    }


    void spawnPlayer()
    {
        objectList.add(new Player(500,750));
    }

    /**
     * Spawn a UFO within bounds set by dimensions
     */
    void spawnUFO()
    {
        int xPos = r.nextInt(dimensions.MAX_X_SPAWN) ;
        int yPos = DEFAULT_UFO_Y_POSITION;
        UFO tempUFO = new UFO(xPos, yPos);
        ufoList.add(tempUFO);
        objectList.add(tempUFO);
    }

    /**
     * Spawn Asteroid within bounds set by dimensions
     */

    void spawnAsteroid()
    {
        int xPos = r.nextInt(dimensions.MAX_X_SPAWN) ;
        int yPos = DEFAULT_ASTEROID_Y_POSITION;
        objectList.add(new Asteroid((float)xPos,(float)yPos));
    }

    /**
     * Uses a timer to determine when to spawn an asteroid
     */
    public void spawnAsteroids()
    {
        if(asteroidCurrentTime == 0)
        {
            spawnAsteroid();

            asteroidPreviousTime = System.currentTimeMillis();
            asteroidCurrentTime = asteroidPreviousTime;
        }
        else
        {
            asteroidCurrentTime = System.currentTimeMillis();
            if(asteroidCurrentTime - asteroidPreviousTime >= ASTEROID_SPAWN_RATE)
            {
                spawnAsteroid();

                asteroidPreviousTime = asteroidCurrentTime;
            }
        }
    }

    /**
     * Uses a timer to determine when to spawn a UFO
     */
    public void spawnUFOs()
    {
        if(UFOCurrentTime == 0)
        {
            spawnUFO();
            UFOPreviousTime = System.currentTimeMillis();
            UFOCurrentTime = UFOPreviousTime;
        }
        else
        {
            UFOCurrentTime = System.currentTimeMillis();
            if(UFOCurrentTime - UFOPreviousTime >= UFO_SPAWN_RATE)
            {
                spawnUFO();
                UFOPreviousTime = UFOCurrentTime;
            }
        }
    }

    /**
     * Tracks spawned objects and sets health to 0 if they go offscreen (despawner)
     */
    void cleanObjectList()
    {
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();

            if(tempObject.getxPosition() < 0 || tempObject.getyPosition() > dimensions.MAX_SURVIVABLE_Y  ||
                    tempObject.getxPosition() > dimensions.WIDTH + dimensions.DEFAULT_SPRITE_WIDTH || tempObject.getyPosition() < dimensions.MIN_SURVIVABLE_Y)
            {
                System.out.println("Destroyed asteroid/projectile");
                tempObject.setHealth(0);
            }
        }
    }
}
