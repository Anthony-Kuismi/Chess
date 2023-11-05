import ChessPiece.*;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int tileSize;
    private HashMap<PieceType,Piece> pieces = new HashMap<>();
    private PieceType selectedPiece = null;
    private boolean whiteTurn = true;

    enum PieceType{
        WHITE_PAWN, BLACK_PAWN,
        WHITE_KNIGHT, BLACK_KNIGHT,
        WHITE_BISHOP, BLACK_BISHOP,
        WHITE_ROOK, BLACK_ROOK,
        WHITE_QUEEN, BLACK_QUEEN,
        WHITE_KING, BLACK_KING
    }

    public Board(int tileSize) throws IOException {
        this.tileSize = tileSize;

        pieces.put(PieceType.WHITE_PAWN,new WhitePawn(tileSize));
        pieces.put(PieceType.BLACK_PAWN,new BlackPawn(tileSize));
        pieces.put(PieceType.WHITE_KNIGHT,new WhiteKnight(tileSize));
        pieces.put(PieceType.BLACK_KNIGHT,new BlackKnight(tileSize));
        pieces.put(PieceType.WHITE_BISHOP,new WhiteBishop(tileSize));
        pieces.put(PieceType.BLACK_BISHOP,new BlackBishop(tileSize));
        pieces.put(PieceType.WHITE_ROOK,new WhiteRook(tileSize));
        pieces.put(PieceType.BLACK_ROOK,new BlackRook(tileSize));
        pieces.put(PieceType.WHITE_QUEEN,new WhiteQueen(tileSize));
        pieces.put(PieceType.BLACK_QUEEN,new BlackQueen(tileSize));
        pieces.put(PieceType.WHITE_KING,new WhiteKing(tileSize));
        pieces.put(PieceType.BLACK_KING,new BlackKing(tileSize));
    }

    public void draw(Graphics graphics, int x, int y){
        drawBoard(graphics);
        drawPieces(graphics);
        if(selectedPiece !=null){
            graphics.drawImage(pieces.get(selectedPiece).getImage(),x-tileSize/2,y-tileSize/2,null);
        }
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
        for(Map.Entry<PieceType,Piece> entry: pieces.entrySet()){
            entry.getValue().draw(graphics);
        }
    }

    private PieceType getPieceAt(int row, int column){
        for(Map.Entry<PieceType,Piece> entry: pieces.entrySet()){
            if(entry.getValue().onSquare(row,column)){
                return entry.getKey();
            }
        }
        return null;
    }

    private void selectPiece(int row, int column){
        selectedPiece = getPieceAt(row,column);
        if(whiteTurn){
            if(selectedPiece == PieceType.BLACK_PAWN|| selectedPiece == PieceType.BLACK_KNIGHT||
                    selectedPiece == PieceType.BLACK_BISHOP||selectedPiece == PieceType.BLACK_ROOK||
                    selectedPiece == PieceType.BLACK_QUEEN||selectedPiece == PieceType.BLACK_KING
            ){
                selectedPiece = null;
                return;
            }
        }else{
            if(!(selectedPiece == PieceType.BLACK_PAWN|| selectedPiece == PieceType.BLACK_KNIGHT||
                    selectedPiece == PieceType.BLACK_BISHOP||selectedPiece == PieceType.BLACK_ROOK||
                    selectedPiece == PieceType.BLACK_QUEEN||selectedPiece == PieceType.BLACK_KING)
            ){
                selectedPiece = null;
                return;
            }
        }
        if(selectedPiece != null){
            pieces.get(selectedPiece).pickUp(row, column);
        }
    }

    private void placePiece(int row, int column){
        PieceType capture = getPieceAt(row, column);
        if(capture!=null){
            pieces.get(capture).pickUp(row, column);
        }
        pieces.get(selectedPiece).place(row,column);
    }

    public void movePiece(int x, int y){
        int column = x/tileSize;
        int row = y/tileSize;
        if(selectedPiece == null){
            selectPiece(row,column);
        }else{
            placePiece(row,column);
            selectedPiece = null;
            whiteTurn = !whiteTurn;
        }
    }
}
