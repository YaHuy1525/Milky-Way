import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    GamePanel gamePanel;
    Keyhandler keyhandler;
    int playerspeed;
    public final int screenX;
    public final int screenY;
    public String direction;
    public Player(GamePanel gp, Keyhandler k){
        this.gamePanel = gp;
        this.keyhandler = k;
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

//        switch (direction){
//            case "up":
//                worldY -= playerspeed;
//                break;
//            case "down":
//                worldY += playerspeed;
//                break;
//            case "left":
//                worldX -= playerspeed;
//                break;
//            case "up":
//                worldY -= playerspeed;
//                break;
//        }
        if (collision) {
            // If there's a collision, adjust the player's position slightly back
            switch (direction) {
                case "up" -> worldY += 3;
                case "down" -> worldY -= 3;
                case "left" -> worldX += 3;
                case "right" -> worldX -= 3;
            }
        }
        if(!collision){
            if (keyhandler.uppress){
                worldY -= playerspeed;
            }
            else if (keyhandler.downpress){
                worldY += playerspeed;
            }
            else if (keyhandler.rightpress){
                worldX += playerspeed;
            }
            else if (keyhandler.leftpress){
                worldX -= playerspeed;
            }
        }
    }
    public void setPlayerImage(){
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/440195841_1559576347940274_6214247284721351186_n.png"));
            shadow = ImageIO.read(getClass().getResourceAsStream("/player/shadow.png"));
            front1 = ImageIO.read(getClass().getResourceAsStream("/player/440195841_1559576347940274_6214247284721351186_n.png"));
            back1 = ImageIO.read(getClass().getResourceAsStream("/player/back.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setDefultvalues(){
        playerspeed = 4;
        worldX = gamePanel.tilesize * 3;
        worldY = gamePanel.tilesize * 3;
//        else if (gamePanel.tileM.currentMap == gamePanel.tileM.road){
//            worldX = gamePanel.tilesize * 2;
//            worldY = gamePanel.tilesize * 2;
//        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(shadow, screenX, screenY + 8, gamePanel.tilesize, gamePanel.tilesize, null);
        g2.drawImage(image, screenX, screenY, gamePanel.tilesize, gamePanel.tilesize, null);
    }
}
