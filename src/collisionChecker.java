import java.util.Objects;

public class collisionChecker {
    GamePanel gp;
    public collisionChecker(GamePanel gp){
        this.gp= gp;
    }
    public void checkTile(Entity entity){
        int entityLeftworldX = entity.worldX + entity.hitBox.x;
        int entityRightworldX = entity.worldX + entity.hitBox.x + entity.hitBox.width;
        int entityTopworldY = entity.worldY + entity.hitBox.y;
        int entityBottomworldY = entity.worldY + entity.hitBox.y + entity.hitBox.height;

        int entityLeftCol = entityLeftworldX / gp.tilesize;
        int entityRightCol = entityRightworldX / gp.tilesize;
        int entityTopRow = entityTopworldY / gp.tilesize;
        int entityBottomRow = entityBottomworldY / gp.tilesize;
        int tilenum1, tilenum2, secondlayer1, secondlayer2;

        //Check checkpoint
        if(Objects.equals(gp.tileM.currentMap, gp.tileM.bedroom)){
            if(entityTopworldY < gp.tilesize * 2 ){
                gp.tileM.currentMap = gp.tileM.road;
                gp.tileM.setTile(gp.tileM.currentMap);
                gp.tileM.current_2ndLayer = gp.tileM.road_2ndLayer;
                gp.tileM.set2ndTile(gp.tileM.current_2ndLayer);
                gp.player.worldX = gp.tilesize * 3;
                gp.player.worldY = gp.tilesize * 0;
            }
        }

        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopworldY - entity.speed)/gp.tilesize;
                tilenum1 = gp.tileM.mapTileNum[entityTopRow][entityLeftCol];
                tilenum2 = gp.tileM.mapTileNum[entityTopRow][entityRightCol];
                secondlayer1 = gp.tileM.secondLayer[entityTopRow][entityLeftCol];
                secondlayer2 = gp.tileM.secondLayer[entityTopRow][entityRightCol];
                if (gp.tileM.tile[tilenum1].collision || gp.tileM.tile[tilenum2].collision || gp.tileM.tile[secondlayer1].collision || gp.tileM.tile[secondlayer2].collision){
                    entity.collision = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomworldY + entity.speed)/gp.tilesize;
                tilenum1 = gp.tileM.mapTileNum[entityBottomRow][entityLeftCol];
                tilenum2 = gp.tileM.mapTileNum[entityBottomRow][entityRightCol];
                secondlayer1 = gp.tileM.secondLayer[entityBottomRow][entityLeftCol];
                secondlayer2 = gp.tileM.secondLayer[entityBottomRow][entityRightCol];
                if (gp.tileM.tile[tilenum1].collision || gp.tileM.tile[tilenum2].collision || gp.tileM.tile[secondlayer1].collision || gp.tileM.tile[secondlayer2].collision){
                    entity.collision = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightworldX - entity.speed)/gp.tilesize;
                tilenum1 = gp.tileM.mapTileNum[entityTopRow][entityRightCol];
                tilenum2 = gp.tileM.mapTileNum[entityBottomRow][entityRightCol];
                secondlayer1 = gp.tileM.secondLayer[entityTopRow][entityRightCol];
                secondlayer2 = gp.tileM.secondLayer[entityBottomRow][entityRightCol];
                if (gp.tileM.tile[tilenum1].collision || gp.tileM.tile[tilenum2].collision || gp.tileM.tile[secondlayer1].collision || gp.tileM.tile[secondlayer2].collision){
                    entity.collision = true;
                }
                break;
            case "left":
                entityTopRow = (entityLeftworldX + entity.speed)/gp.tilesize;
                tilenum1 = gp.tileM.mapTileNum[entityTopRow][entityLeftCol];
                tilenum2 = gp.tileM.mapTileNum[entityBottomRow][entityLeftCol];
                secondlayer1 = gp.tileM.secondLayer[entityTopRow][entityLeftCol];
                secondlayer2 = gp.tileM.secondLayer[entityBottomRow][entityLeftCol];
                if (gp.tileM.tile[tilenum1].collision || gp.tileM.tile[tilenum2].collision || gp.tileM.tile[secondlayer1].collision || gp.tileM.tile[secondlayer2].collision){
                    entity.collision = true;
                }
                break;
            default:
                entity.collision = false;
                break;
        }
    }
}
