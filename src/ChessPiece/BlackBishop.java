package ChessPiece;

import java.io.IOException;

public class BlackBishop extends Piece {
    public BlackBishop(int tileSize) throws IOException {
        super("images/BlackBishopPNG.png", tileSize, new byte[]{
                (byte) 0B00100100,
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