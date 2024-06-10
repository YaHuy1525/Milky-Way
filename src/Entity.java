import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX, worldY;
    public int defaultHitBoxX, defaultHitBoxY;
    public int trueWidth, trueHeight;
    public int speed = 4;
    public BufferedImage image, shadow, front1, front2, front3, back1, back2, back3, left1, left2, left3, right1, right2, right3;
    public boolean collision = false;
    public Rectangle hitBox;

    public String direction = "down";
    public int spritecounter= 0;
    public int spritenum = 0;
    public Entity(){
    }
    public Entity(GamePanel gp){
        this.gp = gp;
    }
    public Entity(GamePanel gp, Rectangle hitBox){
        this.gp = gp;
        this.hitBox = hitBox;
    }
    public void setCollisionBox(Rectangle rectangle){
        this.hitBox = rectangle;
    }
    public void draw(Graphics2D g2) {
        int screenX = this.worldX - gp.player.worldX + gp.player.screenX;
        int screenY = this.worldY - gp.player.worldY + gp.player.screenY;
        g2.drawImage(this.image, screenX, screenY, this.trueWidth, this.trueHeight, null);
    }
}
