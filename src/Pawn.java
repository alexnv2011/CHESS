public class Pawn extends ChessPiece {
    public Pawn (String color) {
        super(color);
    }
    public String getColor(){
        return this.color;
    }
    public String getSymbol() {
        return "P";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(inBoard(line, column) && inBoard(toLine, toColumn))) {
            return false;
        }
        int deltaLine = toLine - line;
        int deltaCol = toColumn - column;
        boolean res1W = (deltaCol == 0) && (deltaLine == 1) && this.color.equals("White"); // white go up
        boolean res1B = (deltaCol == 0) && (deltaLine == -1) && this.color.equals("Black"); // black go down
        boolean resStartW = (deltaCol == 0) && (deltaLine == 2) && (line == 1) && (chessBoard.board[2][column] == null) && this.color.equals("White");
        boolean resStartB = (deltaCol == 0) && (deltaLine == -2) && (line == 6) && (chessBoard.board[5][column] == null) && this.color.equals("Black");
        boolean endOk = chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayer);
        return endOk && (res1W || res1B || resStartW || resStartB);
    }
}
