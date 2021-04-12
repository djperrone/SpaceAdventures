
package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends SpaceShip {
    public static final int WIDTH = 1280, HEIGHT = WIDTH/12 *9;

    public Player(float xPosition, float yPosition) {
        super();
        System.out.println("Created Player!\n");
        this.textureName = "artwork/Spaceship.png";

        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.speed = 5;
        this.health = 3;
        this.team = Team.Friend;
        this.name = 69;
        this.width = 128;
        this.height = 128;

        try {
            this.imageBuffer = ImageIO.read(new File(textureName));
        } catch (IOException e) {}

        gun = new DefaultSpaceShipGun(this);

        //BufferedImage imageBuffer = new BufferedImage((int)xPosition,(int)yPosition,BufferedImage.TYPE_INT_ARGB);

        //imageBuffer.getTransparency();

    }
    public Player(float xPosition, float yPosition, GameManager manager) {
        super(xPosition,yPosition,manager);
        System.out.println("Created Player!\n");
        this.textureName = "artwork/Spaceship.png";
        this.manager = manager;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.speed = 5;
        direction = -1;
        this.health = 3;
        this.team = Team.Friend;
        this.name = 69;
        this.width = 128;
        this.height = 128;

        try {
            this.imageBuffer = ImageIO.read(new File(textureName));
        } catch (IOException e) {}

        gun = new DefaultSpaceShipGun(this);

        //BufferedImage imageBuffer = new BufferedImage((int)xPosition,(int)yPosition,BufferedImage.TYPE_INT_ARGB);

        //imageBuffer.getTransparency();

    }

    // public Player(float xPosition, float yPosition) {
    // super(xPosition, yPosition);
    //}

    public Player() {
        super();
        this.health = 3;
        this.team = Team.Friend;
        this.name = 69;
        this.width = 128;
        this.height = 128;
    }

    @Override
    void fireGun() {
        this.gun.spawnProjectile(this);
    }

    //@override
    public void tick()
    {
        this.xPosition += (this.xVector * speed);
        this.yPosition += (this.yVector * speed);
        //System.out.println(xVector + yVector);

        if (xPosition < 0){
            xPosition = 0;
        }
        else if (xPosition > WIDTH) {
            xPosition = WIDTH;
        }
        if (yPosition < 0){
            yPosition = 0;
        }
        else if (yPosition >= HEIGHT*2) {
            yPosition = HEIGHT*2 - 1;
        }
    }

    @Override
    public void accept(CollideVisitor visitor) {
        visitor.collide(this);
    }

    @Override
    public CollideVisitor getCollideHandler() {
        return new PlayerCollideVisitor(this);
    }
}



