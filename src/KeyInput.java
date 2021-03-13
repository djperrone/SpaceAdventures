package game.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class KeyInput extends KeyAdapter
{
    boolean w=false, a=false, s=false, d=false;    

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode(); 

        //key events
        if(key==KeyEvent.VK_W)
        {
            tempObject.setVelY(-5);
            w=true;
        }
        if(key==KeyEvent.VK_S)
        {
            tempObject.setVelY(5);
            s=true;
        }
        if(key==KeyEvent.VK_D)
        {
            tempObject.setVelX(5);
            d=true;
        }
        if(key==KeyEvent.VK_A)
        {
            tempObject.setVelX(-5);
            a=true;
        }         

        if(key== KeyEvent.VK_ESCAPE) System.exit(1);        
    }

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();       
        
        //key events
        if (key == KeyEvent.VK_W) 
        {
            w= false;
            if(s) tempObject.setVelY(5);
            else  tempObject.setVelY(0);
        }
        if (key == KeyEvent.VK_S)
        {
            s = false;
            if(w)tempObject.setVelY(-5);
            else tempObject.setVelY(0);
        }
        if (key == KeyEvent.VK_D)
        {
            d = false;
            if(a)tempObject.setVelX(-5);
            else tempObject.setVelX(0);
        }
        if (key == KeyEvent.VK_A)
        {
            a = false;
            if(d)tempObject.setVelX(5);
            else tempObject.setVelX(0);
        }        
    }
}
