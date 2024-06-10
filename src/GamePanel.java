import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements Runnable{
    //Screen Camera
    final int originalTilesize = 16;
    final int scale = 3;
    public final int tilesize = originalTilesize * scale;
    final int maxScreencol = 16;
    final int maxScreenrow = 12;
    final int screenlength = maxScreencol * tilesize;
    final int screenwidth = maxScreenrow * tilesize;
    static int FPS = 60;

    //World Camera
    final int maxWorldcol = 50;
    final int maxWorldrow = 50;
    public collisionChecker cChecker = new collisionChecker(this);
    Keyhandler keyhandler = new Keyhandler();
    public Player player = new Player(this, keyhandler);
    public TileManager tileM = new TileManager(this);
    public Entity[] objects = new Entity[10];
    public ObjectManager objectM = new ObjectManager(this);
    public GUI gui = new GUI(this);
    Thread gamethread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenlength, screenwidth));
        this.setBackground(Color.BLACK);
        this.addKeyListener(keyhandler);
        this.setFocusable(true);
        setupGame();
    }
    public void setupGame() {
        if (tileM.currentMap.equals(tileM.road)){
            objectM.setupCars();
        }
    }
    public void startgamethread(){
        gamethread = new Thread(this);
        gamethread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawcount = 0;
        while (gamethread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawcount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawcount);
                timer = 0;
                drawcount = 0;
            }
        }
    }
     public void update(){
        objectM.updateObject();
        player.update();
     }
     @Override
     public void paintComponent(Graphics g){
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D) g;
         tileM.draw(g2);
         tileM.draw2Layer(g2);
         player.draw(g2);
         if (tileM.currentMap.equals(tileM.road)){
             for (Entity object : objects) {
                 if (object != null) {
                     object.draw(g2);
                 }
             }
         }
         if (gui.deathScreen){
             gui.drawDeathScreen(g2);
         }
         gui.draw(g2);
         g2.dispose();
     }
}
