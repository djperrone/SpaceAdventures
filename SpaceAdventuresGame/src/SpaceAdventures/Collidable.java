package SpaceAdventures;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;

public interface Collidable {
    void collide(final Collidable other);

    void collide(final Asteroid asteroid);
    void collide(final Player player);
    void collide(final Projectile projectile);
    void collide(final UFO spaceship);
    void collide(final MovableHealthyObject other);
}
