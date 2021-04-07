package SpaceAdventures;

public class Projectile extends MovableHealthyObject {

    public Projectile(SpaceShip owner) {
        super(owner.getxPosition(),owner.getyPosition());

        xVector = 0;
        speed = 5.0f;
        width = height = 16;
        damage = 1;
        health = 1;
        //texture = someFile

        yVector = owner.direction;
    }

    //@Override
    public void tick() {
        this.yPosition += yVector * speed;
    }

    @Override
    public void accept(CollideVisitor visitor) {
        visitor.collide(this);
    }

    public CollideVisitor getCollideHandler() {
        return ProjectileCollideVisitor(this.damage);
    }
}
