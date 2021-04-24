package SpaceAdventures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Class used to spawn Movable Healthy Objects
 * All objects are added to a list that is used by Game Manager to run the game
 */
public class Spawner{
    private Random r = new Random();
    private LinkedList<MovableHealthyObject> objectList;
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

    /**
     * Constructor creates instance of spawner
     * Initializes objecList, ufoList, and dimensions
     * @param objectList
     * @param ufoList
     * @param dimensions
     */
    Spawner(LinkedList<MovableHealthyObject> objectList,LinkedList<UFO> ufoList, Dimensions dimensions)
    {
        this.objectList = objectList;
        this.ufoList = ufoList;
        this.dimensions = dimensions;
        DEFAULT_UFO_Y_POSITION = 10;
        DEFAULT_ASTEROID_Y_POSITION = dimensions.MIN_SURVIVABLE_Y+1;

        asteroidPreviousTime = UFOPreviousTime = System.currentTimeMillis();
        asteroidCurrentTime = UFOCurrentTime = 0;
    }

    // returns objectList
    LinkedList<MovableHealthyObject> getObjectList()
    {
        return this.objectList;
    }

    /**
     * Spawn a UFO within certain range of x and y values
     * y value is set at top of the screen
     * x value is a random number between 0 and the max allowable x value
     * Adds ufo to both ufolist and objectlist - ufolist is used to fire projectiles
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
     * Spawn Asteroid within range of x, y values
     * asteroid should spawn above offscreen (above) and fly down onto the screen
     * asteroid should spawn at random x locations within range of screen
     */
    void spawnAsteroid()
    {
        int xPos = r.nextInt(dimensions.MAX_X_SPAWN) ;
        int yPos = DEFAULT_ASTEROID_Y_POSITION;
        objectList.add(new Asteroid((float)xPos,(float)yPos));
    }

    /**
     * Call all of the spawn functions in one place
     */
    void spawnAllObjects()
    {
        spawnAsteroids();
        spawnUFOs();
    }

    /**
     * Called at start of game to create instance of player - added as first item on list for easy access
     */
    void spawnPlayer()
    {
        objectList.add(new Player());
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
                    tempObject.getxPosition() > dimensions.WIDTH * .99 || tempObject.getyPosition() < dimensions.MIN_SURVIVABLE_Y)
            {
                System.out.println("Destroyed asteroid/projectile");
                tempObject.setHealth(0);
            }
        }
    }
}
