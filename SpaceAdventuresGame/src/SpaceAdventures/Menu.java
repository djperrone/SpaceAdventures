package SpaceAdventures;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import SpaceAdventures.Game.STATE;

public class Menu extends MouseAdapter {
    //will switch this once we take state out of game class
    private SpaceAdventures.Game game;

    public Menu(SpaceAdventures.Game game){
        this.game = game;
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        //play brings to InGame class
        if (game.gameState == STATE.Menu) {
            if (mouseOver(mx, my, 480 ,300, 320, 128)) {
                game.gameState = STATE.InGame;
            }

            //Instructions
            if (mouseOver(mx, my, 120 , 500 , 450, 128)) {
                game.gameState = STATE.Instructions;
            }

            //leaderboard
            if (mouseOver(mx, my, 660 ,500, 450, 128)) {
                game.gameState = STATE.Leaderboard;
            }
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
        Font fnt = new Font("arial", 1, 130);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Space Adventures", 80, 160);
        g.setColor(Color.white);
        g.drawRect(120 , 500 , 450, 128);
        Font fnt2 = new Font("arial", 1, 60);
        g.setFont(fnt2);
        g.setColor(Color.white);
        g.drawString("How To Play", 170, 580);
        g.setColor(Color.white);
        g.drawRect(660 ,500, 450, 128);
        g.setColor(Color.white);
        g.drawString("Leaderboard", 700, 580);
        g.setColor(Color.white);
        g.drawRect(480 ,300, 320, 128);
        Font fnt3 = new Font("arial", 1, 100);
        g.setFont(fnt3);
        g.setColor(Color.white);
        g.drawString("Play", 540, 400);
    }
}
