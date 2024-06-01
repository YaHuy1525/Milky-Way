import java.awt.*;
import java.awt.image.BufferedImage;

public class Objects {
    public BufferedImage image;
    public int worldX, worldY;
    public Rectangle collisionBox;
    public boolean collision = true;
    public Objects(Rectangle collisionBox){
        this.collisionBox = collisionBox;
    }
    public void setCollisionBox(Rectangle collisionBox){
        this.collisionBox = collisionBox;
    }
    public void draw(){

    }
}
