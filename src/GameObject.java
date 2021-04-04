package MyGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class GameObject {

    protected ID id;
    protected Team team;
    protected float xPosition;
    protected float yPosition;

    protected int width;
    protected int height;
    protected String texture;
    protected float scale;

    protected float speed;
    protected float xVector;
    protected float yVector;

    protected float damage;
    protected float health;
    protected GameManager manager;
    protected BufferedImage imageBuffer;
    protected float direction;



    /**
     * Constructor for GameObject
     * @param xPosition float
     * @param yPosition float
     */
    public GameObject(float xPosition, float yPosition, GameManager manager) {

        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.manager = manager;
        scale = 1;
        speed = 0;
        xVector = 0;
        yVector = 0;
        damage = 1;
        health = 1;
    }


    /**
     * Constructor for GameObject
     * @param xPosition float
     * @param yPosition float
     */
    public GameObject(float xPosition, float yPosition) {

        this.xPosition = xPosition;
        this.yPosition = yPosition;

        scale = 1;
        speed = 0;
        xVector = 0;
        yVector = 0;
        damage = 1;
        health = 1;
    }

    /**
     * Constructor for GameObject     *
     * @param xPosition float
     * @param yPosition float
     * @param manager GameManager
     *                * @param texture String
     */
    public GameObject(float xPosition, float yPosition, GameManager manager, String texture) {

        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.texture = texture;
        this.manager = manager;
        scale = 1;
        speed = 0;
        xVector = 0;
        yVector = 0;
        damage = 1;
        health = 1;
    }
    //public abstract Rectangle getBounds();

    /**
     * Constructor for GameObject
     *
     * @param id enum ID
     * @param team enum Team
     * @param xPosition float
     * @param yPosition float
     * @param width int
     * @param height int
     * @param texture String
     */
    public GameObject(ID id, Team team, float xPosition, float yPosition, int width, int height, String texture) {
        this.id = id;
        this.team = team;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.texture = texture;
        scale = 1;
        speed = 0;
        xVector = 0;
        yVector = 0;
        damage = 1;
        health = 1;
    }
    /**
     * Constructor for GameObject
     *
     * @param id enum ID
     * @param team enum Team
     * @param xPosition float
     * @param yPosition float
     * @param width int
     * @param height int
     * @param texture String
     * @param scale float
     */
    public GameObject(ID id, Team team, float xPosition, float yPosition, int width, int height, String texture, float scale) {
        this.id = id;
        this.team = team;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.scale = scale;
        speed = 0;
        xVector = 0;
        yVector = 0;
        damage = 1;
        health = 1;
    }
    /**
     * Constructor for GameObject
     *
     * @param id enum ID
     * @param team enum Team
     * @param xPosition float
     * @param yPosition float
     * @param width int
     * @param height int
     * @param texture String
     * @param scale float
     * @param speed float
     * @param xVector float
     * @param yVector float
     * @param damage float
     * @param health float
     */
    public GameObject(ID id, Team team, float xPosition, float yPosition, int width, int height, String texture, float scale, float speed, float xVector, float yVector, float damage, float health) {
        this.id = id;
        this.team = team;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.scale = scale;
        this.speed=speed;
        this.xVector=xVector;
        this.yVector=yVector;
        this.damage=damage;
        this.health=health;
    }

    public GameObject() {

    }

    public ID getId() {
        return id;
    }

    public Team getTeam(){
        return team;
    }

    public float getxPosition(){
        return xPosition;
    }

    private void setxPosition(float xPosition){
        this.xPosition=xPosition;
    }

    public float getyPosition(){
        return yPosition;
    }

    private void setyPosition(float yPosition){
        this.yPosition=yPosition;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public float getScale() {
        return scale;
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
    public void setDirection(float direction) {
        this.direction = direction;
    }

    public float getDirection() {
        return direction;
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

    public BufferedImage getImageBuffer(){return this.imageBuffer;}

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

    public void tick(){
        float newXPosition=this.getxPosition()+this.getSpeed()*this.getxVector();
        float newYPosition=this.getyPosition()+this.getSpeed()*this.getyVector();
        setxPosition(newXPosition);
        setyPosition(newYPosition);
    };
    //public abstract void render();

    public Rectangle getBounds()
    {
        return new Rectangle((int)xPosition,(int)yPosition,width,height);
    }
}
