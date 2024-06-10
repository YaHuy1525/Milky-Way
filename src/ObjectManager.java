
public class ObjectManager {
    GamePanel gp;
    public ObjectManager(GamePanel gp){
        this.gp = gp;
    }
    public void setupCars(){
        gp.objects[0] = new BlueCar(gp);
        gp.objects[0].worldX = gp.tilesize * 8;
        gp.objects[0].worldY = gp.tilesize * 4;

        gp.objects[1] = new RedCar(gp);
        gp.objects[1].worldX = gp.tilesize * 5;
        gp.objects[1].worldY = gp.tilesize * 9;

        gp.objects[2] = new CyanCar(gp);
        gp.objects[2].worldX = gp.tilesize * 4;
        gp.objects[2].worldY = gp.tilesize * 5;

        gp.objects[3] = new GreenCar(gp);
        gp.objects[3].worldX = gp.tilesize * 1;
        gp.objects[3].worldY = gp.tilesize * 10;

        gp.objects[4] = new OrangeCar(gp);
        gp.objects[4].worldX = gp.tilesize * 2;
        gp.objects[4].worldY = gp.tilesize * 11;
        gp.objects[4].direction = "right";

        gp.objects[5] = new PurpleCar(gp);
        gp.objects[5].worldX = gp.tilesize * 2;
        gp.objects[5].worldY = gp.tilesize * 15;

        gp.objects[6] = new YellowCar(gp);
        gp.objects[6].worldX = gp.tilesize * 1;
        gp.objects[6].worldY = gp.tilesize * 16;

        gp.objects[7] = new RedCar(gp);
        gp.objects[7].worldX = gp.tilesize * 6;
        gp.objects[7].worldY = gp.tilesize * 17;
    }

    public void updateObject(){
        for (int i = 0; i < gp.objects.length; i++){
            if (gp.objects[i] != null){
                switch (gp.objects[i].direction){
                    case "right":
                        gp.objects[i].image = gp.objects[i].right1;
                        gp.objects[i].worldX += gp.objects[i].speed;
                        break;
                    case "left":
                        gp.objects[i].image = gp.objects[i].left1;
                        gp.objects[i].worldX -= gp.objects[i].speed;
                        break;
                }
                int worldCol = gp.objects[i].worldX / gp.tilesize;
                if(worldCol < 0){
                    gp.objects[i].direction = "right";
                    gp.objects[i].image = gp.objects[i].right1;
                }
                else if(worldCol > 7){
                    gp.objects[i].direction = "left";
                    gp.objects[i].image = gp.objects[i].left1;
                }
            }
        }
    }
}
