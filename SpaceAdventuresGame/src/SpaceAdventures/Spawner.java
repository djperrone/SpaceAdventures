package SpaceAdventures;

import java.time.temporal.Temporal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.TimerTask;

public class Spawner{
    Random r = new Random();
    LinkedList<MovableHealthyObject> objectList;
    public static final int WIDTH = 1280, HEIGHT = WIDTH/12 *9;

    Spawner(LinkedList<MovableHealthyObject> objectList)
    {
        this.objectList = objectList;
    }

    void spawnPlayer()
    {
        objectList.add(new Player(r.nextFloat(),r.nextFloat()));
    }

    void spawnUFO()
    {
        objectList.add(new UFO(r.nextFloat(),r.nextFloat()));
    }

    void spawnAsteroid()
    {
        int xPos = r.nextInt(WIDTH+1) ;
        int yPos = -100;

        objectList.add(new Asteroid((float)xPos,(float)yPos));

    }
    void spawnProjectile(float xPosition, float yPosition, Team team, float direction)
    {
        objectList.add(new Projectile(xPosition,yPosition,team,direction));
    }

    //void spawnProjectiles()

    void cleanAsteroids()
    {
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();

            if(tempObject.getxPosition() < 0 || tempObject.getyPosition() >= HEIGHT  || tempObject.getxPosition() > WIDTH)
            {
                System.out.println("Destroyed asteroid");
                tempObject.setHealth(0);
            }

//            if(tempObject.isAlive())
//            {
//                tempObject.tick();
//            }
//            else
//            {
//                it.remove();
//            }
        }

    }

    void cleanProjectiles()
    {
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();) {
            MovableHealthyObject tempObject = it.next();

            if (tempObject.getxPosition() > WIDTH || tempObject.getyPosition() < -100 || tempObject.getxPosition() < 0 && tempObject.getId() == ID.Projectile) {
                System.out.println("Destroyed projectile");
                tempObject.setHealth(0);

            }
        }
    }

//    void cleanAsteroids()
//    {
//        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
//        {
//            MovableHealthyObject tempObject = it.next();
//
//            if(tempObject.getxPosition() < 0 || tempObject.getyPosition() >= HEIGHT * 2 || tempObject.getxPosition() > WIDTH)
//            {
//                System.out.println("Destroyed "+ tempObject.name);
//                it.remove();
//            }
//
//            if(!(tempObject.isAlive()))
//            {
//                it.remove();
//            }
//        }
//    }





}
