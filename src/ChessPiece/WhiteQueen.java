package ChessPiece;

import java.io.IOException;

public class WhiteQueen extends Piece {
    public WhiteQueen(int tileSize) throws IOException {
        super("images/WhiteQueenPNG.png", tileSize, new byte[]{
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00010000
        });
    }
}