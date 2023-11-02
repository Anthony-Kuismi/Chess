import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
    static final int GAME_WIDTH = 640;
    static final int GAME_HEIGHT = 640;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);

    Thread gameThread;
    Graphics graphics;
    Image image;
    Board board;

    GamePanel(){
        this.setFocusable(true);
        this.addKeyListener(new KeyList());
        this.addMouseListener(new MouseList());
        this.setPreferredSize(SCREEN_SIZE);

        board = new Board();
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }

    public void draw(Graphics g) {
        board.draw(g,getHeight()/8);
        Toolkit.getDefaultToolkit().sync();
    }
    public void update(){

    }

    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks =60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public class KeyList extends KeyAdapter{
        public void keyPressed(KeyEvent e) {

        }
    }

    public class MouseList extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            int x = MouseInfo.getPointerInfo().getLocation().x - getLocationOnScreen().x;
            int y = MouseInfo.getPointerInfo().getLocation().y - getLocationOnScreen().y;
        }
    }
}