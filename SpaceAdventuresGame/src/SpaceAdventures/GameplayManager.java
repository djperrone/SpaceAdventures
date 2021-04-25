
package SpaceAdventures;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * GameplayManager class handles anything related to gameplay
 * This involves passing all renderable objects to the renderer (including healthbar, objectList returned from objectmanager)
 *  would most likely track a score if implemented
 * passes main responsibility of gameobjects onto the objectManager
 */

public class GameplayManager {

    private Game game;
    private GameObjectManager objectManager;
    private Renderer renderer;
    private HealthBar healthbar;

    GameplayManager(Game game)
    {
        this.game = game;
        this.objectManager = new GameObjectManager();
        this.renderer = new Renderer();
        this.healthbar = new HealthBar();
        System.out.println(objectManager.getPlayer().health);
    }

    public void tick()
    {
        if (!getPlayer().isAlive()) {
            this.game.gameState = Game.STATE.DeathScreen;
            System.out.println("Game Over");
            return;
        }
        objectManager.tick();
    }

    public void render(Graphics g, BufferStrategy bs)
    {
        healthbar.render(g, (int) getPlayer().getHealth());

        for(MovableHealthyObject object : objectManager.getFrozenObjectList())
        {
            renderer.render(g,bs,object.getImageBuffer(), (int)object.getxPosition(), (int)object.getyPosition());
        }
    }

    public Player getPlayer()
    {
        return this.objectManager.getPlayer();
    }
}