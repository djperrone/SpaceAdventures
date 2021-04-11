package SpaceAdventures;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
    Player player;
    MouseInput(Player player)
    {
        this.player = player;

    }

    public void mousePressed(MouseEvent e)
    {

        System.out.println("clicked!");
        player.fireGun();


    }

    public void mouseReleased(MouseEvent e)
    {

    }
}
