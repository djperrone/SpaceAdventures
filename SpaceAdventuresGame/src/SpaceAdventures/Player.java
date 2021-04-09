package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends SpaceShip {


    public Player(float xPosition, float yPosition) {
        super();
        System.out.println("Created Player!\n");
        this.textureName = "artwork/Spaceship.png";

        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.speed = 5;

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


    }

    @Override
    void fireGun()
    {
        this.gun.spawnProjectile(this);
    }

    //@override
    public void tick()
    {
        this.xPosition += (this.xVector * speed);
        this.yPosition += (this.yVector * speed);
        //System.out.println(xVector + yVector);
    }
}
