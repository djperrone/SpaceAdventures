package SpaceAdventures;

import java.awt.*;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 8886785132605953826L;
    //default width, height
    public static final int WIDTH = 1280, HEIGHT = WIDTH/12 *9;
    private Thread thread;
    private boolean running = false;

    public Dimensions dimensions;

    private GameManager manager;
    //private Renderer renderer;
    //private Player player;
    private BufferedImage img;
    private final int FPS = 60;
    Asteroid a;
    Window window;
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

//    public static class Dimensions
//    {
//        public final int WIDTH, HEIGHT;
//        public Dimensions(int width, int height)
//        {
//            this.WIDTH = width;
//            this.HEIGHT = height;
//        }
//    }



    //Starting game state is menu
    public STATE gameState = STATE.Menu;

    public Game(){

        //player = new Player(100, 1);
        //renderer = new Renderer();
        dimensions = new Dimensions(WIDTH,HEIGHT);
        manager = new GameManager(this);
        //all four states
        menu = new Menu(this);
        deathscreen = new DeathScreen();
        instructions = new Instructions(this);
        leaderboard = new Leaderboard(this);



        this.addKeyListener(new KeyInput(manager.getPlayer()));
        String gameName = "Space Adventures";
        //window = new Window(WIDTH, HEIGHT, gameName, this);
        //new Window(WIDTH, HEIGHT, "Space Adventures", this);
        new SpaceAdventures.Window(WIDTH, HEIGHT, "Space Adventures", this);


        //a = new Asteroid(100, 1);
        this.addMouseListener(new MouseInput(manager.getPlayer()));
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
                //thread.wait(1000);

                //Collection<MovableHealthyObject> synchronizedList = Collections.synchronizedList(manager.objectList);
                render(frozenObectList());

                //render(frozenObectList());

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
    private MovableHealthyObject[] frozenObectList()
    {
       return manager.objectListToArray();
    }
    private void tick(){
        if(gameState == STATE.InGame){
            manager.tick();
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
    private void render(MovableHealthyObject[] objectArray){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);


        if(gameState == STATE.InGame){
            manager.render(g, bs, objectArray);
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

        //manager.renderer.render(g,bs,a);

//        try {
//            img = ImageIO.read(new File("assets/strawberry.jpg"));
//        } catch (IOException e) {}
//
//        g.drawImage(img, (int) WIDTH/2-32, HEIGHT/2-32, null);


        g.dispose();
        bs.show();


    }

    public static void main(String args[]){
        new Game();

    }
}
