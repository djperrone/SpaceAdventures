package SpaceAdventures;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class KeyInput extends KeyAdapter
{
    private Player player;
    boolean w=false,a=false,s=false,d=false;
    
    public KeyInput(Player player)
    {
        this.player = player;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        //key events
        if (key == KeyEvent.VK_W) {
            player.setyVector(-1);
            w = true;
        }
        if (key == KeyEvent.VK_S) {
            player.setyVector(1);
            s = true;
        }

        if (key == KeyEvent.VK_D) {
            player.setxVector(1);
            d = true;
        }

        if (key == KeyEvent.VK_A) {
            player.setxVector(-1);
            a = true;
        }

        if(key == KeyEvent.VK_SPACE)
        {
            player.fireGun();
        }

        if(key== KeyEvent.VK_ESCAPE) System.exit(1);
    }

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        //System.out.println("Asdasdasdasd" + key);

        //key events
        if (key == KeyEvent.VK_W) {
            w = false;
            if (s) player.setyVector(1);
            else player.setyVector(0);
        }
        if (key == KeyEvent.VK_S) {
            s = false;
            if (w) player.setyVector(-1);
            else player.setyVector(0);
        }
        if (key == KeyEvent.VK_D) {
            d = false;
            if (a) player.setxVector(-1);
            else player.setxVector(0);
        }
        if (key == KeyEvent.VK_A) {
            a = false;
            if (d) player.setxVector(1);
            else player.setxVector(0);
        }

    }
    
}

