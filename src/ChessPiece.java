public abstract class ChessPiece {
    String color;
    boolean check = true;
    public ChessPiece(String color) {
        this.color = color;
    }
    public abstract String getColor();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();

    protected boolean inBoard(int x, int y) { // in board
        return ((x>-1) && (x<8) && (y>-1) && (y<8));
    }
}