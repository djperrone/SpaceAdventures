package SpaceAdventures;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import SpaceAdventures.Game.STATE;

public class Instructions extends MouseAdapter {
    private SpaceAdventures.Game game;
    public Instructions(SpaceAdventures.Game game){
        this.game = game;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        //play brings to InGame class
        if (mouseOver(mx, my, 20 , 40 , 170, 90) && game.gameState == STATE.Instructions ) {
            game.gameState = STATE.Menu;
        }
    }



    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x+width){
            if(my > y && my < y+height){
                return true;
            }
            else return false;
        }
        else return false;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        Font fnt = new Font("arial", 1, 110);
        g.setFont(fnt);
        g.drawString("How To Play", 335, 110);
        // here type instruction

        //return to menu
        Font fnt2 = new Font("arial", 1, 40);
        g.setFont(fnt2);
        g.setColor(Color.white);
        g.drawRect(20 , 40 , 170, 90);
        g.setColor(Color.white);
        g.drawString("Return", 40, 100);

        //instructions/controls
        Font fnt3 = new Font("arial", 1, 50);
        g.setFont(fnt2);
        g.setColor(Color.white);
        g.drawRect(350, 150, 550, 250);
        g.drawString("Key Controls", 500, 200);
        g.drawString("W - Up", 400, 275);
        g.drawString("A - Left", 700, 275);
        g.drawString("S - Down", 400, 325);
        g.drawString("D - Right", 700, 325);
        g.drawString("Space - Shoot ", 500, 375);

    }
}
