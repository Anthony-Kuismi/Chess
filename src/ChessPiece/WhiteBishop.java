package ChessPiece;

import java.io.IOException;

public class WhiteBishop extends Piece {
    public WhiteBishop(int tileSize) throws IOException {
        super("images/WhiteBishopPNG.png", tileSize, new byte[]{
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00100100
        });
    }
}