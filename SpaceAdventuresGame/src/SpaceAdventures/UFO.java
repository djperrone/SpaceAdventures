
package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UFO extends SpaceShip{

    private long RATE_OF_FIRE = 2000;
    private long previousTime;
    private long currentTime;


    public UFO(float xPosition, float yPosition, GameManager manager, String texture) {
        super();
    }

    public UFO(float xPosition, float yPosition) {



        //super(xPosition, yPosition);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.id = ID.UFO;
        this.team = Team.Enemy;
        this.direction = 1;
        this.gun = new DefaultSpaceShipGun();
        this.textureName = "Artwork/UFO.png";
        this.health = 3;
        this.width = this.height = 128;
        this.damage = 1;

        previousTime = previousTime = System.currentTimeMillis();
        currentTime = currentTime = 0;


        System.out.println("spawned ufo!");

        try {
            this.imageBuffer = ImageIO.read(new File(textureName));
        } catch (IOException e) {
        }
    }

    // Fire gun on timer
    @Override
    public void fireGun() {
        this.gun.spawnProjectile(xPosition,yPosition,team,direction);
    }

    @Override
    public void tick()
    {

        if(currentTime == 0)
        {
            fireGun();

            previousTime = System.currentTimeMillis();
            currentTime = previousTime;
        }
        else
        {
            currentTime = System.currentTimeMillis();
            if(currentTime - previousTime >= RATE_OF_FIRE)
            {
                fireGun();

                previousTime = currentTime;
            }
        }
        //implement timer here
        //fireGun();

        //implement movement controller here
    }

    @Override
    public void accept(CollideVisitor visitor) {
        visitor.collide(this);
    }

    @Override
    public CollideVisitor getCollideHandler() {
        return new UFOCollideVisitor(this);
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int)xPosition, (int)yPosition, width,height);
    }
}

