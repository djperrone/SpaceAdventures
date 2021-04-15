package SpaceAdventures;

import java.time.temporal.Temporal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.TimerTask;

public class Spawner{
    Random r = new Random();
    LinkedList<MovableHealthyObject> objectList;
    private LinkedList<UFO> UFOlist;

    //public static final int dimension.WIDTH+1 = 1280, dimensions.HEIGHT = dimension.WIDTH+1/12 *9;
    Dimensions dimensions;
    
    static int DEFAULT_UFO_Y_POSITION;
    static int DEFAULT_ASTEROID_Y_POSITION;

    Spawner(LinkedList<MovableHealthyObject> objectList,LinkedList<UFO> UFOlist, Dimensions dimensions)
    {
        this.objectList = objectList;
        this.UFOlist = UFOlist;
        this.dimensions = dimensions;
        DEFAULT_UFO_Y_POSITION = 10;
        DEFAULT_ASTEROID_Y_POSITION = dimensions.MIN_SURVIVABLE_Y;
    }

    void spawnPlayer()
    {
        objectList.add(new Player(r.nextFloat(),r.nextFloat()));
    }

    void spawnUFO()
    {
        int xPos = r.nextInt(dimensions.MAX_X_SPAWN) ;
        int yPos = DEFAULT_UFO_Y_POSITION;
        UFO tempUFO = new UFO(xPos, yPos);
        UFOlist.add(tempUFO);
        objectList.add(tempUFO);
    }

    /**
     *
     */
    void spawnAsteroid()
    {
        int xPos = r.nextInt(dimensions.MAX_X_SPAWN) ;
        int yPos = DEFAULT_ASTEROID_Y_POSITION;

        objectList.add(new Asteroid((float)xPos,(float)yPos));
    }

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

//    void cleanProjectiles()
//    {
//        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();) {
//            MovableHealthyObject tempObject = it.next();
//
//            if (tempObject.getxPosition() > dimensions.WIDTH+1 || tempObject.getyPosition() < -100 || tempObject.getxPosition() < 0 && tempObject.getId() == ID.Projectile) {
//                System.out.println("Destroyed projectile");
//                tempObject.setHealth(0);
//            }
//        }
//    }



    //clean all function


}
