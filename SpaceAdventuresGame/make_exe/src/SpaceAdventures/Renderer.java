
package SpaceAdventures;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

public class Renderer extends Canvas{


    Renderer()
    {
    }

    public void render(Graphics g, BufferStrategy bs, BufferedImage imageBuffer ,int xPosition, int yPosition) {

        g.drawImage(imageBuffer, xPosition, yPosition, null);
    }

}
