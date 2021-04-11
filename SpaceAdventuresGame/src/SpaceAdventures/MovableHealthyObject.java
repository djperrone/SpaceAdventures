package SpaceAdventures;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MovableHealthyObject extends GameObject{
    protected float speed;
    protected float xVector;
    protected float yVector;

    protected float damage;
    protected float health;
    protected float direction;
    protected float name;

    /**
     * Constructor for MovableHealthyObject
     *
     * @param id enum ID
     * @param xPosition float
     * @param yPosition float
     * @param width int greater zero
     * @param height int greater zero
     * @param textureName String
     * @param scale float greater zero
     * @param speed float
     * @param xVector float
     * @param yVector float
     * @param damage float
     * @param health float
     */
    public MovableHealthyObject(ID id, float xPosition, float yPosition, int width, int height, String textureName, float scale, float speed, float xVector, float yVector, float damage, float health){
        super(id,xPosition,yPosition,width,height,textureName,scale);
        this.speed=speed;
        this.xVector=xVector;
        this.yVector=yVector;
        this.damage=damage;
        this.health=health;
    }

    /**
     * Constructor for MovableHealthyObject
     *
     * @param id enum ID
     * @param xPosition float
     * @param yPosition float
     * @param width int greater zero
     * @param height int greater zero
     * @param textureName String
     */
    public MovableHealthyObject(ID id, float xPosition, float yPosition, int width, int height, String textureName){
        this(id,xPosition,yPosition,width,height,textureName,1f,0f,0f,0f,1f,1f);
    }

    /**
     * Constructor for MovableHealthyObject
     *
     * @param id enum ID
     * @param xPosition float
     * @param yPosition float
     * @param width int greater zero
     * @param height int greater zero
     * @param textureName String
     * @param scale float greater zero
     */
    public MovableHealthyObject(ID id, float xPosition, float yPosition, int width, int height, String textureName, float scale){
        this(id,xPosition,yPosition,width,height,textureName,scale,0f,0f,0f,1f,1f);
    }

    public MovableHealthyObject(float xPosition, float yPosition, GameManager manager, String texture) {
        super();
    }

    public MovableHealthyObject() {
        super();
    }

    public MovableHealthyObject(float getxPosition, float getyPosition) {
        super();
    }

    public MovableHealthyObject(float xPosition, float yPosition, GameManager manager) {
        super(xPosition,yPosition,manager);
    }


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

}