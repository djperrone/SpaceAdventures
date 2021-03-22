package MyGame;

import java.util.LinkedList;
import java.util.Iterator;

//import MyGame.Game;

public class GameManager {

    Game game;
    Player player;
    LinkedList<GameObject> objectList = new LinkedList<GameObject>();

    GameManager(Game game, Player player)
    {
        this.game = game;
        this.player = player;
    }


    public void tick()
    {
//        for(Iterator<GameObject> it = objectList.iterator();it.hasNext();)
//        {
//            GameObject tempObject = it.next();
//
//            for(Iterator<GameObject> innerIt = objectList.iterator();innerIt.hasNext())
//            {
//                GameObject tempObject2 = innerIt.next();
//
//                if(isColliding(tempObject, tempObject2) && it != innerIt)
//                {
//                    handleCollision(tempObject,tempObject2);
//                }
//            }
//
//            if(tempObject.isAlive())
//            {
//                tempObject.tick();
//            }
//            else
//            {
//                it.remove();
//            }
//        }

        for(int i =0; i < objectList.size();i++)
        {
            GameObject tempObject = objectList.get(i);

            for(int j = 0; j < objectList.size();j++)
            {
                GameObject tempObject2 = objectList.get(i);

                if(isColliding(tempObject, tempObject2) && i != j)
                {
                    handleCollision(tempObject,tempObject2);
                }
            }

            if(tempObject.isAlive())
            {
                tempObject.tick();
            }
            else
            {
                objectList.remove(tempObject);
            }
        }
    }

    public void render()
    {

    }

    public boolean isColliding(GameObject objectA, GameObject objectB)
    {
        return objectA.getBounds().intersects(objectB.getBounds());
    }

    public void handleCollision(GameObject objectA, GameObject objectB)
    {
        objectA.setHealth(objectA.getHealth()-1);
        objectB.setHealth(objectB.getHealth()-1);
    }

    public void spawnPlayer()
    {

    }

    public void spawnAsteroid(float xPosition, float yPosition)
    {
        Asteroid asteroid = new Asteroid(xPosition, yPosition, ID.Asteroid);
        this.objectList.add(asteroid);
    }

    public void spawnProjectile(float xPosition, float yPosition)
    {
        Projectile projectile = new Projectile(xPosition,yPosition,ID.Projectile);
        this.objectList.add(projectile);
    }


}
