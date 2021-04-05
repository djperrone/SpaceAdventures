package SpaceAdventures;

public class Projectile extends MovableHealthyObject
{

    public Projectile(SpaceShip owner)
    {
        super(owner.getxPosition(),owner.getyPosition());

        xVector = 0;
        speed = 5.0f;
        width = height = 16;
        damage = 1;
        //texture = someFile

        yVector = owner.direction;
    }

    //@Override
    public void tick()
    {
        this.yPosition += yVector * speed;
    }

}
