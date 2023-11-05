import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class GameFrame extends JFrame{

    GamePanel panel;

    GameFrame() throws IOException {
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Chess");
        this.setBackground(Color.black);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}