import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Car extends Entity {
    public Car(GamePanel gp) {
        super(gp);
        collision = false;
        direction = "left";
        speed = 6;
        getImage();
        this.trueHeight = gp.tilesize;
        this.trueWidth = gp.tilesize * 2;
        this.defaultHitBoxX = 8;
        this.defaultHitBoxY = 8;
        setCollisionBox(new Rectangle(0, 0, 32 * 2, 32));

    }

    public void getImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Cars/blue_car_left.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Cars/blue_car_right.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Cars/blue_car_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    class BlueCar extends Car{
        public BlueCar(GamePanel gp){
            super(gp);
            getImage();
        }
        public void getImage(){
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/Cars/blue_car_left.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/Cars/blue_car_right.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/Cars/blue_car_left.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    class CyanCar extends Car{
        public CyanCar(GamePanel gp){
            super(gp);
            getImage();
        }
        public void getImage(){
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/Cars/cyan_car_left.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/Cars/cyan_car_right.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/Cars/cyan_car_left.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    class GreenCar extends Car{
        public GreenCar(GamePanel gp){
            super(gp);
            getImage();
        }
        public void getImage(){
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/Cars/green_car_left.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/Cars/green_car_right.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/Cars/green_car_left.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    class OrangeCar extends Car{
        public OrangeCar(GamePanel gp){
            super(gp);
            getImage();
        }
        public void getImage(){
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/Cars/orange_car_left.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/Cars/orange_car_right.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/Cars/orange_car_left.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    class PurpleCar extends Car{
        public PurpleCar(GamePanel gp){
            super(gp);
            getImage();
        }
        public void getImage(){
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/Cars/purple_car_left.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/Cars/purple_car_right.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/Cars/purple_car_left.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    class RedCar extends Car{
        public RedCar(GamePanel gp){
            super(gp);
            getImage();
        }
        public void getImage(){
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/Cars/red_car_left.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/Cars/red_car_right.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/Cars/red_car_left.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    class YellowCar extends Car{
        public YellowCar(GamePanel gp){
            super(gp);
            getImage();
        }
        public void getImage(){
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/Cars/yellow_car_left.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/Cars/yellow_car_right.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/Cars/yellow_car_left.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
