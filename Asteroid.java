package MyGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Asteroid extends MovableHealthyObject implements Collidable {
    protected float speed;
    protected float direction;

    public Asteroid(float xPosition, float yPosition, ID id, ID team) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.id = id;
    }

    protected float xVelocity = xPosition*speed;
    protected float yVelocity = yPosition*speed;

    public void collide(final Collidable other) {
        // Call collide on the other object.
        other.collide(this);
    }

    public void collide(final Asteroid asteroid) {
        // TODO Handle Asteroid-Asteroid collision.
    }

    public void collide(final Player plyer) {
        // TODO Handle Asteroid-Player collision.
    }

    public void collide(final Projectile projectile) {
        // TODO Handle Asteroid-projectile collision.
    }

    public void collide(final Ufo spaceship) {
        // TODO Handle Asteroid-UFO collision.
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
