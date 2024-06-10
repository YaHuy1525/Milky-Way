import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager extends Tile{
    public String currentMap;
    public String current_2ndLayer;
    public final String bedroom = "/Map/Bedroom.txt";
    public final String bedroom_2ndLayer = "/Map/bedroom_2ndLayer.txt";
    public final String road = "/Map/Road.txt";
    public final String road_2ndLayer = "/Map/Road_2ndLayer.txt";
    GamePanel gp;
    Tile[] tile;
    int[][] mapTileNum;
    int[][] secondLayer;
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[15];
        mapTileNum = new int[gp.maxWorldrow][gp.maxWorldcol];
        secondLayer = new int[gp.maxWorldrow][gp.maxWorldcol];
        getTileImage();
        setDefaultValue();
        setTile(currentMap);
        set2ndTile(current_2ndLayer);
    }
    public int getMapCol(String mapStream){
        String line = "";
        try {
            InputStream map = getClass().getResourceAsStream(mapStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(map));
            line = reader.readLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        String[] number = line.split(" ");
        return number.length;
    }
    public int getMapRow(String mapStream){
        String line = "";
        int count = 0;
        try {
            InputStream map = getClass().getResourceAsStream(mapStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(map));
            while((line = reader.readLine()) != null){
                count++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return count;
    }
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/dirt .png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/black.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/stone.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/wood floor.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/boulder.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Room/bottomwall.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Room/topwall.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Room/leftrightwall.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Room/wall.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/onGrass.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/conner_wall.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setDefaultValue(){
        currentMap = bedroom;
        current_2ndLayer = bedroom_2ndLayer;
    }

    public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;

        int maxCol = getMapCol(currentMap);
        int maxRow = getMapRow(currentMap);

        while (worldCol < maxCol && worldRow < maxRow){
            int worldX = worldCol * gp.tilesize;
            int worldY = worldRow * gp.tilesize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            g2.drawImage(tile[mapTileNum[worldRow][worldCol]].image, screenX, screenY, gp.tilesize, gp.tilesize, null);
            worldCol++;
            if (worldCol == maxCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
    public void draw2Layer(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;

        int maxCol = getMapCol(current_2ndLayer);
        int maxRow = getMapRow(current_2ndLayer);

        while (worldCol < maxCol && worldRow < maxRow){
            int worldX = worldCol * gp.tilesize;
            int worldY = worldRow * gp.tilesize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            int num = secondLayer[worldRow][worldCol];
            if (num != 0){
                g2.drawImage(tile[num].image, screenX, screenY, gp.tilesize, gp.tilesize, null);
            }
            worldCol++;
            if (worldCol == maxCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
    public void setTile(String mapStream) {
        try {
            InputStream map = getClass().getResourceAsStream(mapStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(map));
            int maxCol = getMapCol(mapStream);
            int maxRow = getMapRow(mapStream);
            int col = 0;
            int row = 0;
            while (col < maxCol && row < maxRow){
                String line = reader.readLine();
                while (col < maxCol){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                    col++;
                }
                if(col == maxCol){
                    col = 0;
                    row++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void set2ndTile(String mapStream) {
        try {
            InputStream map = getClass().getResourceAsStream(mapStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(map));
            int maxCol = getMapCol(mapStream);
            int maxRow = getMapRow(mapStream);
            int col = 0;
            int row = 0;
            while (col < maxCol && row < maxRow){
                String line = reader.readLine();
                while (col < maxCol){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    secondLayer[row][col] = num;
                    col++;
                }
                if(col == maxCol){
                    col = 0;
                    row++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}