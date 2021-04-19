package SpaceAdventures;

import java.awt.*;
import java.util.LinkedList;

public class HealthBar {

    public void tick(){
    }

    public void render(Graphics g,int health){
        //rectangle values
        int x=0;
        int y = 900;
        int width = 400;
        int height = 50;

        Font fnt = new Font("arial", 1, 40);
        g.setFont(fnt);
        g.setColor(Color.red);
        g.drawString("Health", x+20, y-10);
        //create health bar graphic
        g.drawRect(x,y, width, height);
        g.setColor(Color.white);
        //the initial health is 3, thus width/3 give us width in terms of health =1
        g.fillRect(x,y, health*(width/3), height);
    }
}