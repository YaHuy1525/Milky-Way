import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gamePanel;
    Keyhandler keyhandler;
    int playerspeed;
    public final int screenX;
    public final int screenY;
    public String direction;
    public boolean death = false;
    public int deathCounter = 0;
    public Player(GamePanel gp, Keyhandler k){
        this.gamePanel = gp;
        this.keyhandler = k;
//        this.defaultHitBoxX = 8;
//        this.defaultHitBoxY = 8;
        screenX = gamePanel.screenlength/2 - (gamePanel.tilesize/2);
        screenY = gamePanel.screenwidth/2 - (gamePanel.tilesize/2);
        hitBox = new Rectangle(8,8,32,32);
        setDefultvalues();
        setPlayerImage();
    }
    public void update(){
        if (keyhandler.uppress){
            this.direction = "up";
            this.image = back1;
        }
        else if(keyhandler.downpress){
            this.direction = "down";
            this.image = front1;
        }
        else if(keyhandler.leftpress){
            this.direction = "left";
            this.image = left1;
        }
        else if (keyhandler.rightpress){
            this.direction = "right";
            this.image = right1;
        }

        collision = false;
        gamePanel.cChecker.checkTile(this);
        gamePanel.cChecker.checkObject(this);
        if (collision) {
            // If there's a collision, adjust the player's position slightly back
            switch (direction) {
                case "up" -> worldY += 2;
                case "down" -> worldY -= 2;
                case "left" -> worldX += 2;
                case "right" -> worldX -= 2;
                default -> {
                }
            }
        }
        if(!collision){
            if (keyhandler.uppress){
                worldY -= playerspeed;
                movement(back1,back2,back3);
            }
            else if (keyhandler.downpress){
                worldY += playerspeed;
                movement(front1,front2,front3);
            }
            else if (keyhandler.rightpress){
                worldX += playerspeed;
                movement(right1,right2, right3);
            }
            else if (keyhandler.leftpress){
                worldX -= playerspeed;
                movement(left1, left2, left3);
            }
        }
        if (death){
            deathCounter++;
            System.out.println(deathCounter);
            worldX = gamePanel.tilesize * 4;
            worldY = gamePanel.tilesize * 1;
            death = false;
            gamePanel.gui.deathScreen = true;
        }
    }

    private void movement(BufferedImage frame1, BufferedImage frame2, BufferedImage frame3) {
        spritecounter += playerspeed;
        if (spritecounter > 40){
            this.image = frame2;
        }
        if (spritecounter > 80){
            this.image = frame3;
        }
        if (spritecounter > 120){
            this.image = frame1;
            spritecounter = 0;
        }
    }

    public void setPlayerImage(){
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/front1.png"));
            shadow = ImageIO.read(getClass().getResourceAsStream("/player/shadow.png"));
            front1 = ImageIO.read(getClass().getResourceAsStream("/player/front1.png"));
            front2 = ImageIO.read(getClass().getResourceAsStream("/player/front2.png"));
            front3 = ImageIO.read(getClass().getResourceAsStream("/player/front3.png"));
            back1 = ImageIO.read(getClass().getResourceAsStream("/player/back1.png"));
            back2 = ImageIO.read(getClass().getResourceAsStream("/player/back2.png"));
            back3 = ImageIO.read(getClass().getResourceAsStream("/player/back3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/left3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/right3.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setDefultvalues(){
        this.direction = "down";
        playerspeed = 3;
        worldX = gamePanel.tilesize * 3;
        worldY = gamePanel.tilesize * 3;
    }
    @Override
    public void draw(Graphics2D g2){
        g2.drawImage(shadow, screenX, screenY + 8, gamePanel.tilesize, gamePanel.tilesize, null);
        g2.drawImage(image, screenX, screenY, gamePanel.tilesize, gamePanel.tilesize, null);
    }
}
