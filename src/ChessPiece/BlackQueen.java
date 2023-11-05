package ChessPiece;

import java.io.IOException;

public class BlackQueen extends Piece {
    public BlackQueen(int tileSize) throws IOException {
        super("images/BlackQueenPNG.png", tileSize, new byte[]{
                (byte) 0B00010000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000
        });
    }
}