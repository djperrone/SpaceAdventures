package SpaceAdventures;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import SpaceAdventures.Game.STATE;

public class Leaderboard extends MouseAdapter {
    private SpaceAdventures.Game game;
    public Leaderboard(SpaceAdventures.Game game){
        this.game = game;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        //play brings to InGame class
        if (mouseOver(mx, my, 20 , 40 , 170, 90) && game.gameState == STATE.Leaderboard ) {
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
        g.setColor(Color.white);
        g.drawString("Leaderboard", 310, 110);
        //return to menu
        Font fnt2 = new Font("arial", 1, 20);
        g.setFont(fnt2);
        g.setColor(Color.white);
        g.drawRect(20 , 40 , 170, 90);
        g.setColor(Color.white);
        g.drawString("Return", 40, 100);

    }
}
