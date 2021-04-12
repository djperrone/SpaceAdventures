package SpaceAdventures;

public abstract class ACollideVisitor implements CollideVisitor {
    public void collide(final Asteroid asteroid){return;}
    public void collide(final Player player){return;}
    public void collide(final Projectile projectile){return;}
    public void collide(final UFO spaceship){return;}
    public void collide(final MovableHealthyObject other){return;}
}
