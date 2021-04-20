package SpaceAdventures;

public interface CollideVisitor {
    public void collide(final Asteroid asteroid);
    public void collide(final Player player);
    public void collide(final Projectile projectile);
    public void collide(final UFO spaceship);
    public void collide(final MovableHealthyObject other);
}
