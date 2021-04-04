package MyGame;

import java.util.LinkedList;
import java.util.Iterator;



import MyGame.Game;

// FriendProjectile and EnemyProjectile
// or Projectile(Team)
// iterator cannot access current element or previous....cant change objects in enhanced for loop

public class GameManager {

    Game game;
    Player player;
    Renderer renderer;
    Spawner spawner;
    LinkedList<GameObject> objectList;

    GameManager(Game game, Renderer renderer)
    {
        this.game = game;
        this.renderer = renderer;
        this.player = new Player();
        objectList = new LinkedList<GameObject>();
        spawner = new Spawner(objectList);

    }

    public void tick()
    {
        checkForCollisionEvents();
        update();
        render();
    }

    public void render()
    {
        for(Iterator<GameObject> it = objectList.iterator();it.hasNext();)
        {
            GameObject tempObject = it.next();

            renderer.render(tempObject);
        }
    }

    public void update()
    {
        for(Iterator<GameObject> it = objectList.iterator();it.hasNext();)
        {
            GameObject tempObject = it.next();

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

    public void checkForCollisionEvents()
    {
        for(Iterator<GameObject> it = objectList.iterator();it.hasNext();)
        {
            GameObject currentObject = it.next();

            for(Iterator<GameObject> otherIt = objectList.iterator();otherIt.hasNext();)
            {
                GameObject other = otherIt.next();

                if(!isOnSameTeam(currentObject, other) && isColliding(currentObject, other))
                {
                    handleCollisionEvent(currentObject,other);
                }
            }
        }
    }

    public boolean isOnSameTeam(GameObject currentObject, GameObject other)
    {
        return currentObject.team == other.team;
    }

    public boolean isColliding(GameObject objectA, GameObject objectB)
    {
        return objectA.getBounds().intersects(objectB.getBounds());
    }

    public void handleCollisionEvent(GameObject objectA, GameObject objectB)
    {
        objectA.setHealth(objectA.getHealth()-1);//-objectb.getDamage()
        objectB.setHealth(objectB.getHealth()-1); //- objectA.getDamage()
    }

//    public void spawnPlayer()
//    {
//
//    }
//
//    public void spawnAsteroid(float xPosition, float yPosition)
//    {
//        Asteroid asteroid = new Asteroid(xPosition, yPosition, ID.Asteroid, ID.Enemy);
//        this.objectList.add(asteroid);
//    }
//
//
//    public void spawnProjectile(float xPosition, float yPosition, ID team)
//    {
//        //Projectile projectile = new Projectile(xPosition,yPosition,ID.Projectile, team);
//        //this.objectList.add(projectile);
//    }
//    public void spawnFriendlyProjectile(float xPosition, float yPosition)
//    {
//        //Projectile projectile = new Projectile(xPosition,yPosition,ID.Projectile, ID.Friend);
//        //this.objectList.add(projectile);
//    }
//    public void spawnEnemyProjectile(float xPosition, float yPosition)
//    {
//        //Projectile projectile = new Projectile(xPosition,yPosition,ID.Projectile, ID.Enemy);
//        //this.objectList.add(projectile);
//    }


}
