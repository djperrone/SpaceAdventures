package SpaceAdventures;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Projectile extends MovableHealthyObject
{

    SpaceShip owner;
    public Projectile(SpaceShip owner)
    {
        super();
        this.owner = owner;
        xPosition = owner.getxPosition();
        yPosition = owner.getyPosition();
        xVector = 0;
        speed = 2.0f;
        width = height = 16;
        damage = 1;
        textureName = "assets/strawberry.jpg";
        this.health = 1;
        this.yVector = owner.direction;

        yVector = owner.direction;

        try {
            this.imageBuffer = ImageIO.read(new File(textureName));
        } catch (IOException e) {}
    }

    //@Override
    public void tick()
    {
        this.yPosition += (yVector * speed);
    }


    @Override
    public void accept(CollideVisitor visitor) {
        visitor.collide(this);
    }

    public CollideVisitor getCollideHandler() {
        return new ProjectileCollideVisitor(this);
    }
}
