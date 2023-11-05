package ChessPiece;

import java.io.IOException;

public class BlackRook extends Piece {
    public BlackRook(int tileSize) throws IOException {
        super("images/BlackRookPNG.png", tileSize, new byte[]{
                (byte) 0B10000001,
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