
package SpaceAdventures;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class UFO extends SpaceShip{

    public UFO(float xPosition, float yPosition, GameManager manager, String texture) {
        super();
    }

    public UFO(float xPosition, float yPosition) {

        //super(xPosition, yPosition);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.id = ID.UFO;
        this.direction = 1;
        this.gun = new DefaultSpaceShipGun();
        this.textureName = "Artwork/UFO.png";
        this.health = 3;

        System.out.println("spawned ufo!");

        try {
            this.imageBuffer = ImageIO.read(new File(textureName));
        } catch (IOException e) {
        }
    }

    // Fire gun on timer
    @Override
    public void fireGun() {

    }

    @Override
    public void accept(CollideVisitor visitor) {
        visitor.collide(this);
    }

    @Override
    public CollideVisitor getCollideHandler() {
        return new UFOCollideVisitor(this);
    }
}

