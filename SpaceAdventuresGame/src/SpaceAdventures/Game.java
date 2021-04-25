package SpaceAdventures;

import java.awt.*;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 8886785132605953826L;
    public final int WIDTH, HEIGHT;
    private Thread thread;
    private boolean running = false;

    public Dimensions dimensions;

    private GameplayManager gameplayManager;

    private BufferedImage img;
    private final int FPS = 60;
    //Window window;

    //states
    private Menu menu;
    private DeathScreen deathscreen;
    private Instructions instructions;
    private Leaderboard leaderboard;
    public enum STATE {
        Menu,
        InGame,
        DeathScreen,
        Instructions,
        Leaderboard
    };

    //Starting game state is menu
    public STATE gameState;

    public Game(){

        gameplayManager = new GameplayManager(this);
        gameState = STATE.Menu;
        dimensions = new Dimensions();
        WIDTH = dimensions.WIDTH;
        HEIGHT = dimensions.HEIGHT;

        //all four states
        menu = new Menu(this);
        deathscreen = new DeathScreen();
        instructions = new Instructions(this);
        leaderboard = new Leaderboard(this);

        this.addKeyListener(new KeyInput(gameplayManager.getPlayer()));
        new SpaceAdventures.Window(WIDTH, HEIGHT, "Space Adventures", this);

        //String gameName = "Space Adventures";

        this.addMouseListener(new MouseInput(gameplayManager.getPlayer()));
        this.addMouseListener(menu);
        this.addMouseListener(instructions);
        this.addMouseListener(leaderboard);
    }
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running=true;
    }
    public synchronized void stop(){
        try{
            thread.join();
            running= false;
        }catch(Exception e){
            e.printStackTrace();
        }
        thread = new Thread(this);
        thread.start();
    }
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
            {
                //render(frozenObectList());
                render();

            }
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        if(gameState == STATE.InGame){
            gameplayManager.tick();
        }
        else if(gameState == STATE.Menu){
            menu.tick();
        }
        else if(gameState == STATE.DeathScreen){
            deathscreen.tick();
        }
        else if(gameState == STATE.Instructions){
            instructions.tick();
        }
        else if(gameState == STATE.Leaderboard) {
            leaderboard.tick();
        }
    }

    private void render(){

        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);


        if(gameState == STATE.InGame){
            gameplayManager.render(g, bs);
        }
        else if(gameState == STATE.Menu){
            menu.render(g);
        }
        else if(gameState == STATE.DeathScreen){
            deathscreen.render(g);
        }
        else if(gameState == STATE.Instructions){
            instructions.render(g);
        }
        else if(gameState == STATE.Leaderboard){
            leaderboard.render(g);
        }
        g.dispose();
        bs.show();

    }

    public static void main(String args[]){
        new Game();
    }
}
