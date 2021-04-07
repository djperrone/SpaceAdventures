package SpaceAdventures;

public abstract class MovableHealthyObject extends GameObject implements Collidable{
    protected float speed;
    protected float xVector;
    protected float yVector;

    protected float damage;
    protected float health;
    protected Team team;

    /**
     * Constructor for MovableHealthyObject
     *
     * @param team enum Team
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
    public MovableHealthyObject(Team team, ID id, float xPosition, float yPosition, int width, int height, String textureName, float scale, float speed, float xVector, float yVector, float damage, float health){
        super(id,xPosition,yPosition,width,height,textureName,scale);
        this.speed=speed;
        this.xVector=xVector;
        this.yVector=yVector;
        this.damage=damage;
        this.health=health;
        this.team = team;
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
    public MovableHealthyObject(Team team, ID id, float xPosition, float yPosition, int width, int height, String textureName){
        this(team,id,xPosition,yPosition,width,height,textureName,1f,0f,0f,0f,1f,1f);
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
    public MovableHealthyObject(Team team, ID id, float xPosition, float yPosition, int width, int height, String textureName, float scale){
        this(team,id,xPosition,yPosition,width,height,textureName,scale,0f,0f,0f,1f,1f);
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

    public void damage (float damageValue){
        if(this.health - damageValue < 0){
            this.health = 0;
        }
        else{
            this.health = this.health - damageValue;
        }
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

}