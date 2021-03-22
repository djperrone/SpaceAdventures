package MyGame;

import java.awt.*;

public class Projectile extends GameObject
{

    String projectileTexture;


    public Projectile(float xPosition, float yPosition, ID id, Team team)
    {
        super(xPosition,yPosition,id, team);
        xVector = 0;
        //yVector = -1;
        speed = 5.0f;
        width = height = 16;

        damage = 1;

        if(this.team == Team.Friend)
        {
            yVector = -1;
            projectileTexture = "FriendProjectile.png";
        }
        else
        {
            yVector = 1;
            projectileTexture = "EnemyProjectile.png";
        }
    }

    @Override
    public void tick()
    {
        yPosition += yVector * speed;
    }

    @Override
    public void render(Graphics g)
    {

    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int)xPosition,(int)yPosition,width,height);
    }
}
