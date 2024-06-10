import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tree extends Entity {
    public Tree(GamePanel gp){
        super(gp);
        collision = true;
        direction = "left";
        speed = 0;
        getImage();
        this.trueHeight = gp.tilesize * 3;
        this.trueWidth = gp.tilesize * 3;
        setCollisionBox(new Rectangle(8,8,32,32));
    }
    public void getImage(){
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Tiles/tree.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
