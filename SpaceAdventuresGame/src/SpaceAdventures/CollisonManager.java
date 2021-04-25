package SpaceAdventures;

import java.util.Iterator;
import java.util.LinkedList;

public class CollisonManager {

    private LinkedList<MovableHealthyObject> objectList;

    CollisonManager(LinkedList<MovableHealthyObject> objectList)
    {
        this.objectList = objectList;
    }


    public void checkForCollisionEvents()
    {
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject currentObject = it.next();

            for(Iterator<MovableHealthyObject> otherIt = objectList.iterator(); otherIt.hasNext();)
            {
                MovableHealthyObject other = otherIt.next();
//                if(isColliding(currentObject, other)){
//                    //System.out.println("Collision " + isOnSameTeam(currentObject, other));
//                }
                if(!isOnSameTeam(currentObject, other) && isColliding(currentObject, other)){
                    //System.out.println("Collision Detected");
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
