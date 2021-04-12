
package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Iterator;

// FriendProjectile and EnemyProjectile
// or Projectile(Team)
// iterator cannot access current element or previous....cant change objects in enhanced for loop
public class GameManager {
    public static final int WIDTH = 640, HEIGHT = WIDTH/12 *9;
    BufferedImage img;

    Game game;
    Player player;
    Renderer renderer;
    Spawner spawner;
    LinkedList<MovableHealthyObject> objectList;

    long previousTime;
    long currentTime;

    GameManager(Game game,Player player)
    {
        this.game = game;
        this.renderer = new Renderer();
        this.player = player;
        objectList = new LinkedList<MovableHealthyObject>();
        objectList.add(player);
        spawner = new Spawner(objectList);
        previousTime = System.currentTimeMillis();
        currentTime = 0;

    }
    GameManager(Game game)
    {
        this.game = game;
        this.renderer = new Renderer();
        this.player = new Player(100,100,this);
        objectList = new LinkedList<MovableHealthyObject>();
        objectList.add(player);
        spawner = new Spawner(objectList);
        previousTime = System.currentTimeMillis();
        currentTime = 0;
        System.out.println(player.health);

    }

    public void tick()
    {
        if (!player.isAlive()) {
            System.out.println("Game Over ");
            game.stop();
        }

        checkForCollisionEvents();
        updateList();
        spawnAsteroids();

        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();

            tempObject.tick();
        }
    }

    public void render(Graphics g, BufferStrategy bs)
    {
        //this.renderer = new Renderer(g,bs);
        //renderer.render(g,bs,player);
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();

            renderer.render(g,bs,tempObject);
        }


//        try {
//            img = ImageIO.read(new File("assets/strawberry.jpg"));
//        } catch (IOException e) {}

        //g.drawImage(player.imageBuffer, (int) game.WIDTH/2-32, game.HEIGHT/2-32, null);
    }

    public void updateList()
    {
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject tempObject = it.next();

            if(tempObject.isAlive() && !(tempObject.getxPosition() < 0 || tempObject.getyPosition() >= HEIGHT * 2 || tempObject.getxPosition() > WIDTH || tempObject.getyPosition() < 0))
            {
                tempObject.tick();
            }
            else
            {
                it.remove();
                if(player == tempObject){
                    System.out.println("player removed");
                }
                else{
                    System.out.println("something removed");
                }
            }
        }
    }

    public void checkForCollisionEvents()
    {
        //System.out.println(player.team);
        for(Iterator<MovableHealthyObject> it = objectList.iterator(); it.hasNext();)
        {
            MovableHealthyObject currentObject = it.next();

            for(Iterator<MovableHealthyObject> otherIt = objectList.iterator(); otherIt.hasNext();)
            {
                MovableHealthyObject other = otherIt.next();
                if(isColliding(currentObject, other)){
                    System.out.println("Collision " + isOnSameTeam(currentObject, other));
                }
                if(!isOnSameTeam(currentObject, other) && isColliding(currentObject, other)){
                    System.out.println("Collision Detected");
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

    public void spawnAsteroids()
    {
        if(currentTime == 0)
        {
            spawner.spawnAsteroid();
            previousTime = System.currentTimeMillis();
            currentTime = previousTime;
        }
        else
        {
            currentTime = System.currentTimeMillis();
            if(currentTime - previousTime >= 1000)
            {
                spawner.spawnAsteroid();
                previousTime = currentTime;
            }
        }
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
