package ChessPiece;

import java.io.IOException;

public class WhiteRook extends Piece {
    public WhiteRook(int tileSize) throws IOException {
        super("images/WhiteRookPNG.png", tileSize, new byte[]{
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B10000001
        });
    }
}