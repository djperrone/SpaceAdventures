
package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Player extends SpaceShip {
    public static final int WIDTH = 1280, HEIGHT = WIDTH/12 *9;

    public Player(float xPosition, float yPosition) {

        //x,y,texname,health,speed,damage,direction,team,id,width,height


        super(xPosition,yPosition);
        System.out.println("Created Player!\n");
        this.textureName = "Spaceship.png";
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.speed = 5;
        this.direction = -1;
        this.health = 3;
        this.team = Team.Friend;
        this.id = ID.Player;
        this.name = 9;
        this.width = 128;
        this.height = 64;
        this.damage = 1;

        this.gun = new DefaultSpaceShipGun();

        try {
            this.imageBuffer = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(textureName));
        } catch (Exception e) {
            System.err.print("Trying to read player image: ");
            System.err.println(e.toString());
        }
    }

    public Player() {

        System.out.println("Created Player!\n");
        this.textureName = "Spaceship.png";
        this.health = 3;
        this.team = Team.Friend;
        this.name = 1;
        this.width = 128;
        this.height = 128;
        this.xPosition = 500;
        this.yPosition = 750;

        this.speed = 5;
        this.direction = -1;

        this.id = ID.Player;

        this.damage = 1;

        this.gun = new DefaultSpaceShipGun();

        try {
            this.imageBuffer = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(textureName));
        } catch (Exception e) {
            System.err.print("Trying to read player image: ");
            System.err.println(e.toString());
        }
    }

    //@override
    public void tick()
    {
        //this.xPosition += (this.xVector * speed);
        //this.yPosition += (this.yVector * speed);
        updateLocation();
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