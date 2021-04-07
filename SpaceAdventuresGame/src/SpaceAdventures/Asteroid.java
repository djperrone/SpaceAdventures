package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Asteroid extends MovableHealthyObject implements Collidable {

    public Asteroid(Team team, ID id, float xPosition, float yPosition, int width, int height, String textureName, float scale, float speed, float xVector, float yVector, float damage, float health) {
        super(team, id, xPosition, yPosition, width, height, textureName, scale, speed, xVector, yVector, damage, health);
    }

    @Override
    public void accept(CollideVisitor visitor) {
        visitor.collide(this);
    }

    @Override
    public CollideVisitor getCollideHandler() {
        return new AsteroidCollideVisitor(this);
    }
}
