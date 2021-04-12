package SpaceAdventures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 8886785132605953826L;
    public static final int WIDTH = 1280, HEIGHT = WIDTH/12 *9;
    private Thread thread;
    private boolean running = false;

    private GameManager manager;
    //private Renderer renderer;
    //private Player player;
    private BufferedImage img;
    private final int FPS = 60;
    Asteroid a;

    public Game(){

        //player = new Player(100, 1);
        //renderer = new Renderer();
        manager = new GameManager(this);

        this.addKeyListener(new KeyInput(manager.player));
        new Window(WIDTH, HEIGHT, "Space Adventures", this);

        a = new Asteroid(100, 1);
        this.addMouseListener(new MouseInput(manager.player));

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
                render();
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

        manager.tick();

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


        manager.render(g, bs);

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