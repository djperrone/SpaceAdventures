package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.*;

import java.io.File;
import java.io.IOException;

public class Asteroid extends MovableHealthyObject implements Collidable {
    protected float speed;
    protected float direction;

    public Asteroid(float xPosition, float yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.id = ID.Asteroid;

        this.team = Team.Enemy;
        this.health = 1;
        this.damage = 1;

        this.width = 128;
        this.height = 128;
        name = xPosition;

        this.speed = 1.5f;
        this.yVelocity = 1.0f;

        System.out.println("spawned asteroid! " + name + " " + height + " " + width);
        this.textureName = "Asteroid1.png";

        try {
            this.imageBuffer = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(textureName));
        } catch (Exception e) {
            System.err.print("Trying to read Asteroid image: ");
            System.err.println(e.toString());
        }
    }

    protected float xVelocity = xPosition*speed;
    protected float yVelocity = yPosition*speed;

    @Override
    public void accept(CollideVisitor visitor) {
        visitor.collide(this);
    }

    @Override
    public CollideVisitor getCollideHandler() {
        return new AsteroidCollideVisitor(this);
    }

    @Override
    public void tick() {
        xPosition+=xVelocity;
        yPosition+=yVelocity;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)xPosition, (int)yPosition, width, height);
    }
}
