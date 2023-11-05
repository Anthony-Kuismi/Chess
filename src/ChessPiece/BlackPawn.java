package ChessPiece;

import java.io.IOException;

public class BlackPawn extends Piece {
    public BlackPawn(int tileSize) throws IOException {
        super("images/BlackPawnPNG.png", tileSize, new byte[]{
                (byte) 0B00000000,
                (byte) 0B11111111,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000
        });
    }
}
