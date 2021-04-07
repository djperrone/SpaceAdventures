package SpaceAdventures;

import java.util.Iterator;
import java.util.LinkedList;

public class GameManager {
    Game game;
    Player player;
    Renderer renderer;
    Spawner spawner;
    LinkedList<MovableHealthyObject> objectList;

    GameManager(Game game, Renderer renderer)
    {
        this.game = game;
        this.renderer = renderer;
        this.player = new Player();
        objectList = new LinkedList<MovableHealthyObject>();
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
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();

            renderer.render(tempObject);
        }
    }

    public void update()
    {
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();

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
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject currentObject = it.next();

            for(Iterator<MovableHealthyObject> otherIt = objectList.iterator(); otherIt.hasNext();)
            {
                MovableHealthyObject other = otherIt.next();

                if(!isOnSameTeam(currentObject, other) && isColliding(currentObject, other))
                {
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

}
