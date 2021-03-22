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
    LinkedList<GameObject> objectList = new LinkedList<GameObject>();

    GameManager(Game game, Player player)
    {
        this.game = game;
        this.player = player;
    }

    public void tick()
    {
        checkForCollisionEvents();
        update();
    }

    public void render()
    {

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

    public void spawnFriendlyProjectile(float xPosition, float yPosition)
    {
        Projectile projectile = new Projectile(xPosition,yPosition,ID.Projectile, Team.Friend);
        this.objectList.add(projectile);
    }
    public void spawnEnemyProjectile(float xPosition, float yPosition)
    {
        Projectile projectile = new Projectile(xPosition,yPosition,ID.Projectile, Team.Friend);
        this.objectList.add(projectile);
    }


}
