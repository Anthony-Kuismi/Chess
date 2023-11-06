import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Board {
    private final int tileSize;
    private PieceType selectedPiece = null;
    private boolean whiteTurn = true;
    HashMap<PieceType,Image> pieceImages = new HashMap<>();

    enum PieceType{
        WHITE_PAWN, BLACK_PAWN,
        WHITE_KNIGHT, BLACK_KNIGHT,
        WHITE_BISHOP, BLACK_BISHOP,
        WHITE_ROOK, BLACK_ROOK,
        WHITE_QUEEN, BLACK_QUEEN,
        WHITE_KING, BLACK_KING
    }
    
    private final PieceType[][] boardState = {
            {PieceType.BLACK_ROOK, PieceType.BLACK_KNIGHT, PieceType.BLACK_BISHOP, PieceType.BLACK_QUEEN, PieceType.BLACK_KING, PieceType.BLACK_BISHOP, PieceType.BLACK_KNIGHT, PieceType.BLACK_ROOK},
            {PieceType.BLACK_PAWN, PieceType.BLACK_PAWN, PieceType.BLACK_PAWN, PieceType.BLACK_PAWN, PieceType.BLACK_PAWN, PieceType.BLACK_PAWN, PieceType.BLACK_PAWN, PieceType.BLACK_PAWN},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {PieceType.WHITE_PAWN, PieceType.WHITE_PAWN, PieceType.WHITE_PAWN, PieceType.WHITE_PAWN, PieceType.WHITE_PAWN, PieceType.WHITE_PAWN, PieceType.WHITE_PAWN, PieceType.WHITE_PAWN},
            {PieceType.WHITE_ROOK, PieceType.WHITE_KNIGHT, PieceType.WHITE_BISHOP, PieceType.WHITE_QUEEN, PieceType.WHITE_KING, PieceType.WHITE_BISHOP, PieceType.WHITE_KNIGHT, PieceType.WHITE_ROOK}
    };

    private void addImages(){
        addImage(PieceType.WHITE_PAWN, "images/WhitePawnPNG.png");
        addImage(PieceType.WHITE_KNIGHT, "images/WhiteKnightPNG.png");
        addImage(PieceType.WHITE_BISHOP, "images/WhiteBishopPNG.png");
        addImage(PieceType.WHITE_ROOK, "images/WhiteRookPNG.png");
        addImage(PieceType.WHITE_QUEEN, "images/WhiteQueenPNG.png");
        addImage(PieceType.WHITE_KING, "images/WhiteKingPNG.png");

        addImage(PieceType.BLACK_PAWN, "images/BlackPawnPNG.png");
        addImage(PieceType.BLACK_KNIGHT, "images/BlackKnightPNG.png");
        addImage(PieceType.BLACK_BISHOP, "images/BlackBishopPNG.png");
        addImage(PieceType.BLACK_ROOK, "images/BlackRookPNG.png");
        addImage(PieceType.BLACK_QUEEN, "images/BlackQueenPNG.png");
        addImage(PieceType.BLACK_KING, "images/BlackKingPNG.png");
    }

    public Board(int tileSize){
        this.tileSize = tileSize;
        addImages();
    }

    public void draw(Graphics graphics, int x, int y){
        drawBoard(graphics);
        drawPieces(graphics);
        if(selectedPiece != null){
            graphics.drawImage(pieceImages.get(selectedPiece),x-tileSize/2,y-tileSize/2,null);
        }
        String status = "Is white turn: " + whiteTurn;
        graphics.drawChars(status.toCharArray(), 0, status.length(), (int) (tileSize*8.5),tileSize/2);
    }

    public void drawBoard(Graphics graphics){
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

    private void drawPieces(Graphics graphics){
        for(int row = 0; row < 8; row++){
            for(int column = 0; column < 8; column++){
                PieceType type = boardState[row][column];
                if(type == null){continue;}
                graphics.drawImage(pieceImages.get(type),column*tileSize,row*tileSize,null);
            }
        }
    }

    private void addImage(PieceType type, String filePath){
        try{
            BufferedImage bufferedImage = ImageIO.read(new File(filePath));
            Image image = bufferedImage.getScaledInstance(tileSize,tileSize,Image.SCALE_SMOOTH);
            pieceImages.put(type,image);
        }catch (IOException e){
            System.out.println("Could not load file: " + filePath);
        }

    }

    private PieceType getPieceAt(int row, int column){
        return boardState[row][column];
    }

    private void pickUpPiece(int row, int column){
        selectedPiece = getPieceAt(row,column);
        if(selectedPiece == null){return;}
        if(whiteTurn ^ isWhitePiece(selectedPiece)){
            selectedPiece = null;
            return;
        }
        boardState[row][column] = null;
    }

    private void placePiece(int row, int column){
        PieceType currentPiece = boardState[row][column];
        if(currentPiece == null || (whiteTurn ^ isWhitePiece(currentPiece))){
            boardState[row][column] = selectedPiece;
            selectedPiece = null;
            whiteTurn = !whiteTurn;
        }
    }

    private boolean isWhitePiece(PieceType type){
        return type.ordinal()%2 == 0;
    }

    public void movePiece(int x, int y){
        int column = x/tileSize;
        int row = y/tileSize;
        if(selectedPiece == null){
            pickUpPiece(row,column);
        }else{
            placePiece(row,column);
        }
    }
}
