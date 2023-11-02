import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private HashMap<PieceType,byte[]> bitBoards = new HashMap<>();

    enum PieceType{
        WHITE_PAWN, BLACK_PAWN,
        WHITE_KNIGHT, BLACK_KNIGHT,
        WHITE_BISHOP, BLACK_BISHOP,
        WHITE_ROOK, BLACK_ROOK,
        WHITE_QUEEN, BLACK_QUEEN,
        WHITE_KING, BLACK_KING
    }

    private void resetBoard(){
        final byte[] DEFAULT_WHITE_PAWNS = {
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B11111111,
                (byte) 0B00000000
        };
        final byte[] DEFAULT_BLACK_PAWNS = {
                (byte) 0B00000000,
                (byte) 0B11111111,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000
        };
        final byte[] DEFAULT_WHITE_KNIGHTS = {
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B01000010
        };
        final byte[] DEFAULT_BLACK_KNIGHTS = {
                (byte) 0B01000010,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000
        };
        final byte[] DEFAULT_WHITE_BISHOPS = {
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00100100
        };
        final byte[] DEFAULT_BLACK_BISHOPS = {
                (byte) 0B00100100,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000
        };
        final byte[] DEFAULT_WHITE_ROOKS = {
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B10000001
        };
        final byte[] DEFAULT_BLACK_ROOKS = {
                (byte) 0B10000001,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000
        };
        final byte[] DEFAULT_WHITE_QUEENS = {
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00010000
        };
        final byte[] DEFAULT_BLACK_QUEENS = {
                (byte) 0B00010000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000
        };
        final byte[] DEFAULT_WHITE_KINGS = {
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00001000
        };
        final byte[] DEFAULT_BLACK_KINGS = {
                (byte) 0B00001000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000,
                (byte) 0B00000000
        };

        bitBoards.put(PieceType.WHITE_PAWN,DEFAULT_WHITE_PAWNS);
        bitBoards.put(PieceType.BLACK_PAWN,DEFAULT_BLACK_PAWNS);
        bitBoards.put(PieceType.WHITE_KNIGHT,DEFAULT_WHITE_KNIGHTS);
        bitBoards.put(PieceType.BLACK_KNIGHT,DEFAULT_BLACK_KNIGHTS);
        bitBoards.put(PieceType.WHITE_BISHOP,DEFAULT_WHITE_BISHOPS);
        bitBoards.put(PieceType.BLACK_BISHOP,DEFAULT_BLACK_BISHOPS);
        bitBoards.put(PieceType.WHITE_ROOK,DEFAULT_WHITE_ROOKS);
        bitBoards.put(PieceType.BLACK_ROOK,DEFAULT_BLACK_ROOKS);
        bitBoards.put(PieceType.WHITE_QUEEN,DEFAULT_WHITE_QUEENS);
        bitBoards.put(PieceType.BLACK_QUEEN,DEFAULT_BLACK_QUEENS);
        bitBoards.put(PieceType.WHITE_KING,DEFAULT_WHITE_KINGS);
        bitBoards.put(PieceType.BLACK_KING,DEFAULT_BLACK_KINGS);
    }

    public Board(){
        resetBoard();
    }

    public void draw(Graphics graphics, int tileSize){
        drawBoard(graphics,tileSize);
        drawBitBoards(tileSize, graphics);
    }

    public void drawBoard(Graphics graphics, int tileSize){
        for(int row = 0; row < 8; row++){
            for(int column = 0; column < 8; column++){
                if ((row + column) % 2 == 0) {
                    graphics.setColor(new Color(135,115,100));
                } else {
                    graphics.setColor(new Color(50,50,50));
                }
                graphics.fillRect(column*tileSize,row*tileSize,tileSize,tileSize);
            }
        }
    }

    private void drawBitBoards(int tileSize, Graphics graphics){
        for(Map.Entry<PieceType,byte[]> entry: bitBoards.entrySet()){
            drawBitBoard(entry.getKey(),tileSize,graphics);
        }
    }

    private void drawBitBoard(PieceType type, int tileSize, Graphics graphics){
        for(int row = 0; row < 8; row++){
            int rowBits = bitBoards.get(type)[row];
            for(int column = 7; column >= 0; column--){
                if((rowBits & 1) ==1){
                    drawPiece(row,column,type,tileSize,graphics);
                }
                rowBits = rowBits >> 1;
            }
        }
    }

    private void drawPiece(int row, int column, PieceType type, int tileSize, Graphics graphics){
        switch (type){
            case WHITE_PAWN:
                graphics.setColor(Color.WHITE);
                graphics.fillOval(column*tileSize,row*tileSize,tileSize,tileSize);
                break;
            case BLACK_PAWN:
                graphics.setColor(Color.BLACK);
                graphics.fillOval(column*tileSize,row*tileSize,tileSize,tileSize);
                break;
            case WHITE_KNIGHT:
                graphics.setColor(Color.WHITE);
                graphics.fillOval(column*tileSize,row*tileSize,tileSize/2,tileSize);
                break;
            case BLACK_KNIGHT:
                graphics.setColor(Color.BLACK);
                graphics.fillOval(column*tileSize,row*tileSize,tileSize/2,tileSize);
                break;
            case WHITE_BISHOP:
                graphics.setColor(Color.WHITE);
                graphics.drawOval(column*tileSize,row*tileSize,tileSize/2,tileSize);
                break;
            case BLACK_BISHOP:
                graphics.setColor(Color.BLACK);
                graphics.drawOval(column*tileSize,row*tileSize,tileSize/2,tileSize);
                break;
            case WHITE_ROOK:
                graphics.setColor(Color.WHITE);
                graphics.fillRect(column*tileSize,row*tileSize,tileSize/2,tileSize);
                break;
            case BLACK_ROOK:
                graphics.setColor(Color.BLACK);
                graphics.fillRect(column*tileSize,row*tileSize,tileSize/2,tileSize);
                break;
            case WHITE_QUEEN:
                graphics.setColor(Color.WHITE);
                graphics.drawRect(column*tileSize,row*tileSize,tileSize/2,tileSize);
                break;
            case BLACK_QUEEN:
                graphics.setColor(Color.BLACK);
                graphics.drawRect(column*tileSize,row*tileSize,tileSize/2,tileSize);
                break;
            case WHITE_KING:
                graphics.setColor(Color.WHITE);
                graphics.fillRect(column*tileSize,row*tileSize,tileSize,tileSize);
                break;
            case BLACK_KING:
                graphics.setColor(Color.BLACK);
                graphics.fillRect(column*tileSize,row*tileSize,tileSize,tileSize);
                break;
            default:
                break;
        }
    }

}
