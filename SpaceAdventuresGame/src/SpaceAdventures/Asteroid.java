package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import java.awt.image.BufferedImage;
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
        this.width = 20;
        this.height = 20;
        name = xPosition;

        this.team = ID.Enemy;
        this.health = 1;
        name = xPosition;

        this.speed = 1;
        this.yVelocity = 1;
        System.out.println("spawned asteroid! " + name);
        this.textureName = "artwork/asteroid1.png";

        try {
            this.imageBuffer = ImageIO.read(new File(textureName));
        } catch (IOException e) {}


//        BufferedImage before = imageBuffer;
//        int w = before.getWidth();
//        int h = before.getHeight();
//        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//        AffineTransform at = new AffineTransform();
//        at.scale(1.0,1.0);
//        AffineTransformOp scaleOp =
//                new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
//        after = scaleOp.filter(before, after);
//
//        this.imageBuffer = after;
    }


        this.speed = 1;
        this.yVelocity = 1;
        System.out.println("spawned asteroid! " + name + " " + height + " " + width);
        this.textureName = "artwork/asteroid1.png";

        try {
            this.imageBuffer = ImageIO.read(new File(textureName));
        } catch (IOException e) {
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
        return new Rectangle((int)xPosition, (int)yPosition, width = 32, height = 32);
    }

}
