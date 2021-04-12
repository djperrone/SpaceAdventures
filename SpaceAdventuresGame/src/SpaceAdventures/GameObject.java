package SpaceAdventures;

import java.awt.image.BufferedImage;

public class GameObject {

    protected ID id;
    protected ID team;
    protected float xPosition;
    protected float yPosition;

    protected int width;
    protected int height;
    protected String textureName;
    protected float scale;
    protected GameManager manager;
    protected BufferedImage imageBuffer;
    protected float direction;

    /**
     * Constructor for GameObject
     *
     * @param id enum ID
     * @param xPosition float
     * @param yPosition float
     * @param width int greater zero
     * @param height int greater zero
     * @param textureName String
     * @param scale float greater zero
     */
    public GameObject(ID id, float xPosition, float yPosition, int width, int height, String textureName, float scale) {
        if (scale <= 0) {
            throw new IllegalArgumentException("Scale can not be zero or less");
        }
        if (width <= 0) {
            throw new IllegalArgumentException("Width can not be zero or less");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height can not be zero or less");
        }
        this.id = id;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.textureName = textureName;
        this.scale = scale;
    }
    /**
     * Constructor for GameObject
     *
     * @param id enum ID
     * @param xPosition float
     * @param yPosition float
     * @param width int greater zero
     * @param height int greater zero
     * @param textureName String
     */
    public GameObject(ID id, float xPosition, float yPosition, int width, int height, String textureName) {
        this(id,xPosition,yPosition,width,height,textureName,1f);
    }

    public GameObject() {

    }

    public GameObject(float xPosition, float yPosition, GameManager manager) {


    }


    public ID getId() {
        return id;
    }

    protected void setId(ID id) {
        this.id = id;
    }

    public float getxPosition(){
        return xPosition;
    }

    protected void setxPosition(float xPosition){
        this.xPosition=xPosition;
    }

    public float getyPosition(){
        return yPosition;
    }

    protected void setyPosition(float yPosition){
        this.yPosition=yPosition;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width can not be zero or less");
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height can not be zero or less");
        }
        this.height = height;
    }

    public String getTexture() {
        return textureName;
    }

    public void setTexture(String texture) {
        this.textureName = textureName;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        if (scale <= 0) {
            throw new IllegalArgumentException("Scale can not be zero or less");
        }
        this.scale = scale;
    }


}
