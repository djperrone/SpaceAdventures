package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Projectile extends MovableHealthyObject
{
    public Projectile(float xPosition, float yPosition, Team team, float direction)
    {
        this.team = team;
        this.direction = direction;
        this.xVector = 0.0f;
        this.yVector = direction;
        this.speed = 5.0f;
        this.width = height = 128;
        this.damage = 1.0f;
        this.textureName = "Projectile_64.png";
        this.health = 1.0f;

        if(this.team == Team.Friend)
        {
            this.xPosition = xPosition + 128.0f/4;
            this.yPosition = yPosition - 128.0f/4;
        }
        else
        {
            this.xPosition = xPosition +128.0f/4;
            this.yPosition = yPosition +128;
        }

        try {
            this.imageBuffer = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(textureName));
        } catch (Exception e) {
            System.err.print("Trying to read projectile image: ");
            System.err.println(e.toString());
        }
    }

    //@Override
    public void tick()
    {
        updateLocation();
    }
    public Rectangle getBounds()
    {
        return new Rectangle((int)xPosition, (int)yPosition, width,height);
    }


    @Override
    public void accept(CollideVisitor visitor) {
        visitor.collide(this);
    }

    public CollideVisitor getCollideHandler() {
        return new ProjectileCollideVisitor(this);
    }
}
