package SpaceAdventures;
import java.time.temporal.Temporal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.TimerTask;


public class Spawner{
    Random r = new Random();
    LinkedList<MovableHealthyObject> objectList;
    public static final int WIDTH = 640, HEIGHT = WIDTH/12 *9;

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
        int xPos = r.nextInt(WIDTH+1);
        int yPos = r.nextInt(HEIGHT+1);
        objectList.add(new Asteroid(xPos,yPos));
    }

    void cleanAsteroids()
    {
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();

            if(tempObject.getxPosition() < 0 || tempObject.getyPosition() >= HEIGHT * 2 || tempObject.getxPosition() > WIDTH)
            {
                System.out.println("Destroyed "+ tempObject.name);
                it.remove();
            }

            if(tempObject.isAlive())
            {
                tempObject.tick();
            }
            else
            {
                it.remove();
            }
        }
    }

    void spawnProjectile(SpaceShip owner)
    {
        objectList.add(new Projectile(owner));
    }



}
