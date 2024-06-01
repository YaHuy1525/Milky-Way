import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyhandler implements KeyListener {
    public boolean uppress, downpress, leftpress,rightpress;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W){
            uppress = true;
        }
        if (key == KeyEvent.VK_S){
            downpress = true;
        }
        if (key == KeyEvent.VK_D){
            rightpress = true;
        }
        if (key == KeyEvent.VK_A){
            leftpress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W){
            uppress = false;
        }
        if (key == KeyEvent.VK_S){
            downpress = false;
        }
        if (key == KeyEvent.VK_D){
            rightpress = false;
        }
        if (key == KeyEvent.VK_A){
            leftpress = false;
        }
    }
}
