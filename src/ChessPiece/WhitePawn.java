package ChessPiece;

import java.io.IOException;

public class WhitePawn extends Piece {
    public WhitePawn(int tileSize) throws IOException {
        super("images/WhitePawnPNG.png", tileSize, new byte[]{
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B11111111,
                (byte) 0B00000000
        });
    }
}
