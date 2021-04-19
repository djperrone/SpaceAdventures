package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Projectile extends MovableHealthyObject
{

    //SpaceShip owner;
    public Projectile(float xPosition, float yPosition, Team team, float direction)
    {

        this.team = team;
        this.direction = direction;
        xVector = 0;
        speed = 5.0f;
        width = height = 128;
        damage = 1;
        textureName = "Artwork/Projectile_64.png";
        this.health = 1;
        this.yVector = direction;

        if(this.team == Team.Friend)
        {
            this.xPosition = xPosition + 128/4;
            this.yPosition = yPosition - 128/4;
        }
        else
        {
            this.xPosition = xPosition +128/4;
            this.yPosition = yPosition +128;
        }

        try {
            this.imageBuffer = ImageIO.read(new File(textureName));
        } catch (IOException e) {}
    }

    //@Override
    public void tick()
    {
        this.yPosition += (yVector * speed);
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
