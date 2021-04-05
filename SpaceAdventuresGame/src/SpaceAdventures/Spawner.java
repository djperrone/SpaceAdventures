package SpaceAdventures;
import java.util.LinkedList;
import java.util.Random;


public class Spawner {
    Random r = new Random();
    LinkedList<MovableHealthyObject> objectList;

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
        objectList.add(new Asteroid(r.nextInt(),r.nextInt(),ID.Asteroid,ID.Enemy));
    }

    void spawnProjectile(SpaceShip owner)
    {
        objectList.add(new Projectile(owner));
    }


}
