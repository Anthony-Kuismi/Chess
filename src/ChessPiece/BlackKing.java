package ChessPiece;

import java.io.IOException;

public class BlackKing extends Piece {
    public BlackKing(int tileSize) throws IOException {
        super("images/BlackKingPNG.png", tileSize, new byte[]{
                (byte) 0B00001000,
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