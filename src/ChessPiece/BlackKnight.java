package ChessPiece;

import java.io.IOException;

public class BlackKnight extends Piece {
    public BlackKnight(int tileSize) throws IOException {
        super("images/BlackKnightPNG.png", tileSize, new byte[]{
                (byte) 0B01000010,
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