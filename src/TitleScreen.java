import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends JFrame{
    private JPanel panel;
    private JLabel title;
    private JButton playbutton;
    private JButton quitButton;

    public TitleScreen(GamePanel gp){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       setBackground(Color.BLACK);
       setContentPane(panel);
        setLocationRelativeTo(null);
       pack();
        setSize(700,300);
        setVisible(true);
       title.setFont(new Font("Times new Roman", Font.BOLD, 50));
      title.setBackground(Color.BLACK);
        playbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == playbutton){
                    gp.currentScreen = 1;
                    gp.setupGame();
                    dispose();
                    gp.setVisible(true);
                    JFrame window = new JFrame("Milky Way");
                    //window.setSize(16,12);
                    window.setResizable(false);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JLabel label = new JLabel();
                    label.setIcon(new ImageIcon());
                    window.add(label);
                    window.add(gp);
                    window.pack();
                    window.setLocationRelativeTo(null);
                    window.setVisible(true);
                    gp.startgamethread();
                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == quitButton){
                    dispose();
                }
            }
        });
    }
}
