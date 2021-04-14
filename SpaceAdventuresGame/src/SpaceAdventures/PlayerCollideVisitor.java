package SpaceAdventures;

public class PlayerCollideVisitor extends ACollideVisitor {
    private Player player;

    public PlayerCollideVisitor(Player player){
        this.player = player;
    }

    public void collide(final Asteroid asteroid){
        asteroid.damage(1);
    }

    public void collide(final Projectile projectile){
        if(projectile.team != player.team){
            projectile.damage(this.player.damage);
        }
    }
    public void collide(final UFO ufo){
            ufo.damage(this.player.damage);
    }


}
