package ChessPiece;

import java.io.IOException;

public class WhiteKing extends Piece {
    public WhiteKing(int tileSize) throws IOException {
        super("images/WhiteKingPNG.png", tileSize, new byte[]{
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00001000
        });
    }
}