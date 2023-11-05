package ChessPiece;

import java.io.IOException;

public class WhiteKnight extends Piece {
    public WhiteKnight(int tileSize) throws IOException {
        super("images/WhiteKnightPNG.png", tileSize, new byte[]{
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B01000010
        });
    }
}
