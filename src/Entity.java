import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public int speed = 4;
    public BufferedImage image, shadow, front1, back1, left1, right1;
    public boolean collision = false;
    public Rectangle hitBox;

    public String direction = "down";
    public int spirecounter= 0;
    public int spritenum = 1;
    public Entity(){}
    public Entity(Rectangle rectangle){
        this.hitBox = rectangle;
    }
    public void setCollisionBox(Rectangle rectangle){
        this.hitBox = rectangle;
    }
}
