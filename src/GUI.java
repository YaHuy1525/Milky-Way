import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI  {
    GamePanel gp;
    public boolean deathScreen = false;
    private Timer timer;

    public GUI(GamePanel gp){
        this.gp = gp;
    }

    public void draw(Graphics2D g2){
        drawScoreBoard(g2);
    }

    public void drawScoreBoard(Graphics2D g2){
        int x = gp.screenlength - gp.tilesize * 4;
        int y = 0;
        int length = gp.tilesize * 4;
        int height = gp.tilesize * 2;
        drawTitle(g2, x, y, length, height);
        g2.setFont(new Font("Algerian", Font.PLAIN, 30));
        g2.setColor(Color.WHITE);
        g2.drawString("Death: " + gp.player.deathCounter, x + gp.tilesize - 30, y + gp.tilesize + 10);
    }

    public void drawTitle(Graphics2D g2, int x, int y, int length, int height){
        g2.setColor(Color.GRAY);
        g2.setStroke(new BasicStroke(3));
        g2.fillRoundRect(x, y, length, height, 30, 30);
    }

    public void drawDeathScreen(Graphics2D g2){
        Color bgColor = new Color(0,0,0,100);
        g2.setColor(bgColor);
        g2.fillRect(0,0,gp.screenlength,gp.screenwidth);

        g2.setFont(new Font("Algerian", Font.PLAIN, 40));
        g2.setColor(Color.RED);
        g2.drawString("YOU DIED", gp.screenwidth/2 + 25, gp.screenlength/2 - 120);
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deathScreen = false;
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}