import java.awt.*;

public class Board {
    public Board(){}
    public void draw(Graphics graphics){
        int tileSize = 60;
        for(int row = 0; row < 8; row++){
            for(int column = 0; column < 8; column++){
                if ((row + column) % 2 == 0) {
                    graphics.setColor(new Color(135,115,100));
                } else {
                    graphics.setColor(new Color(50,50,50));
                }
                graphics.fillRect(column*tileSize,row*tileSize,tileSize,tileSize);
            }
        }
    }
}
