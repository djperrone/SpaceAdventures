package SpaceAdventures;

public class UFOCollideVisitor extends ACollideVisitor {
    private UFO ufo;

    public UFOCollideVisitor(UFO ufo){
        this.ufo = ufo;
    }

    public void collide(final Projectile projectile){
        if(ufo.team != projectile.team) {
            projectile.damage(ufo.damage);
        }
    }

}
