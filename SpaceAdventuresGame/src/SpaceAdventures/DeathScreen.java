package SpaceAdventures;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeathScreen extends MouseAdapter {
    public void mouseReleased(MouseEvent e) {
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        Font fnt = new Font("arial", 1, 120);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Game Over", 330, 400);
    }
}
