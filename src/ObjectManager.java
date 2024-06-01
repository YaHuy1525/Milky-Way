import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ObjectManager extends Entity{
    GamePanel gp;
    TileManager tileManager;
    ArrayList<Entity> objects;
    public ObjectManager(GamePanel gp){
        this.gp = gp;
        objects = new ArrayList<>();
    }
    public void getObjectImage(){
        try {
            Entity tree = new Entity(new Rectangle(0, 0, 48, 48));
            tree.image = ImageIO.read(getClass().getResourceAsStream("/Tiles/tree.png"));
            tree.collision = false;
            tree.direction = "right";
            objects.add(tree);
            Entity car = new Entity(new Rectangle(0, 0, 48 * 2, 48));
            car.image = ImageIO.read(getClass().getResourceAsStream("/Tiles/table.png"));
            car.collision = false;
            car.direction = "left";
            objects.add(car);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void updateObject(){
        for (Entity object : objects){
            switch (object.direction){
                case "right":
                    object.worldX += object.speed;
                    break;
                case "left":
                    object.worldX -= object.speed;
                    break;
            }
        }
    }
    public void draw(Graphics2D g2){
        for (Entity object : objects) {
            int screenX = object.worldX - gp.player.worldX + gp.player.screenX;
            int screenY = object.worldY - gp.player.worldY + gp.player.screenY;
            g2.drawImage(object.image, screenX, screenY, gp.tilesize, gp.tilesize, null);
        }
    }
}
