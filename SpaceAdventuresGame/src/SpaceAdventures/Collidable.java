package SpaceAdventures;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;

public interface Collidable {
    public void accept(final CollideVisitor visitor);

    public CollideVisitor getCollideHandler();
}
