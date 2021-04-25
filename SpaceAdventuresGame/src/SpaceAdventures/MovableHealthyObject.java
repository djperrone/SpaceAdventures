package SpaceAdventures;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class MovableHealthyObject extends GameObject implements Collidable{
    protected float speed;
    protected float xVector;
    protected float yVector;

    protected float damage;
    protected float health;
    protected float direction;
    protected float name;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxVector() {
        return xVector;
    }

    public void setxVector(float xVector) {
        this.xVector = xVector;
    }

    public float getyVector() {
        return yVector;
    }

    public void setyVector(float yVector) {
        this.yVector = yVector;
    }

    public float getDamage() {
        return damage;
    }

    public float getHealth() {
        return health;
    }

    public void damage (float damageValue){
        this.health = this.health - damageValue;
    }

    public void setHealth(float health) {
        this.health = health;
    }
    /**
     * returns whether object is alive
     *
     * @return True if health>0 boolean
     */
    public boolean isAlive(){
        return this.getHealth()>0;
    }

    public void updateLocation(){
        float newXPosition=this.getxPosition()+this.getSpeed()*this.getxVector();
        float newYPosition=this.getyPosition()+this.getSpeed()*this.getyVector();
        setxPosition(newXPosition);
        setyPosition(newYPosition);
    };

    public void tick() {
    }

    public void setDirection(float direction) {
        this.direction = direction;
    }

    public float getDirection() {
        return direction;
    }

    public BufferedImage getImageBuffer(){return this.imageBuffer;}

    public Rectangle getBounds()
    {
        return new Rectangle((int)xPosition,(int)yPosition,width,height);
    }

    @Override
    public void accept(CollideVisitor visitor) {

    }

    @Override
    public CollideVisitor getCollideHandler() {
        return null;
    }

}
