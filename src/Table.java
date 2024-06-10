import javax.imageio.ImageIO;
import java.io.IOException;

//          /_/\
//        ( o.o )
//         > ^ <

public class Table extends Entity {

    GamePanel gp;
    public Table(){
        setPosition(0,0);
        setDefaultValue();
    }
    public void setPosition(int x, int y){
        this.worldX = x * gp.tilesize;
        this.worldY = y * gp.tilesize;
    }
    public void setDefaultValue(){
        try{
            this.image = ImageIO.read(getClass().getResourceAsStream("/Tiles/table.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
