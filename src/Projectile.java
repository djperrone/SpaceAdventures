package MyGame;

import java.awt.*;

public class Projectile extends GameObject
{

    String projectileTexture;


    public Projectile(float xPosition, float yPosition, ID id)
    {
        super(xPosition,yPosition,id);
        xVector = 0;
        yVector = -1;
        speed = 5.0f;
        width = height = 16;
        projectileTexture = "projectile.png";
        damage = 1;
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
