package SpaceAdventures;

import java.awt.image.BufferedImage;

public abstract class GameObject {

    protected ID id;
    protected Team team;
    protected float xPosition;
    protected float yPosition;

    protected int width;
    protected int height;
    protected String textureName;
    protected float scale;
    protected GameplayManager manager;
    protected BufferedImage imageBuffer;
    protected float direction;

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
