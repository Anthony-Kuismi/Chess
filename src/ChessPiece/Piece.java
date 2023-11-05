package ChessPiece;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public abstract class Piece {
    final Image image;
    final int tileSize;
    final byte[] DEFAULT_POSITIONS;
    byte[] currentPositions;

    public Piece(String filePath, int tileSize, byte[] defaultPosition) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(filePath));
        this.image = bufferedImage.getScaledInstance(tileSize,tileSize,Image.SCALE_SMOOTH);
        this.tileSize = tileSize;
        this.DEFAULT_POSITIONS = defaultPosition;
        this.currentPositions = defaultPosition;
    }

    public void draw(Graphics graphics){
        for(int row = 0; row < 8; row++){
            int rowBits = currentPositions[row];
            for(int column = 7; column >= 0; column--){
                if((rowBits & 1) ==1){
                    graphics.drawImage(image,column*tileSize,row*tileSize,null);
                }
                rowBits = rowBits >> 1;
            }
        }
    }

    public boolean onSquare(int row, int column){
        byte mask = (byte) Math.pow(2,(7-column));
        return (currentPositions[row] & mask) == mask;
    }

    public void place(int row, int column){
        byte mask = (byte) Math.pow(2,(7-column));
        currentPositions[row] = (byte) (currentPositions[row]|mask);
    }

    public void pickUp(int row, int column){
        byte mask = (byte) Math.pow(2,(7-column));
        if((currentPositions[row] & mask) == mask){
            currentPositions[row] = (byte) (currentPositions[row]^mask);
        }
    }

    public Image getImage() {
        return image;
    }
}
