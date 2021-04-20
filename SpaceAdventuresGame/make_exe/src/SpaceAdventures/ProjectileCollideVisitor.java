package SpaceAdventures;

public class ProjectileCollideVisitor extends ACollideVisitor{
    private Projectile projectile;

    public ProjectileCollideVisitor(Projectile projectile){
        this.projectile = projectile;
    }

    public void collide(final Asteroid asteroid){
        if(projectile.team != asteroid.team){
            asteroid.damage(this.projectile.damage);
        }
    }

    public void collide(final Player player){
        if(projectile.team != player.team){
            player.damage(this.projectile.damage);
        }
    }

    public void collide(final UFO ufo){
        if(projectile.team != ufo.team){
            ufo.damage(this.projectile.damage);
        }
    }
}
