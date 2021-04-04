package MyGame;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Renderer extends Canvas{

    //BufferedImage texture;

    Graphics painter;
    BufferStrategy bufferStrategy;

    Renderer()
    {
        painter = bufferStrategy.getDrawGraphics();

        bufferStrategy = this.getBufferStrategy();

        if(bufferStrategy == null)
        {
            this.createBufferStrategy(3);
        }
    }
    public void render(GameObject renderableObject) {

        this.painter.drawImage(renderableObject.getImageBuffer(), (int) renderableObject.getxPosition(), (int) renderableObject.getyPosition(), null);
    }

}
