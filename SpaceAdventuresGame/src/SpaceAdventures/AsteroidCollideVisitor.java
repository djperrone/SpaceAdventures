package SpaceAdventures;

public class AsteroidCollideVisitor extends ACollideVisitor {
    private Asteroid asteroid;

    public AsteroidCollideVisitor(Asteroid asteroid){
        this.asteroid = asteroid;
    }

    public void collide(final Player player){
        player.damage(this.asteroid.damage);
    }

    public void collide(final Projectile projectile){
        if(projectile.team != asteroid.team){
            projectile.damage(this.asteroid.damage);
        }
    }
}
