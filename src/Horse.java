public class Horse extends ChessPiece {
    public Horse (String color) {
        super(color);
    }

    public String getColor(){
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(inBoard(line, column) && inBoard(toLine, toColumn))) {
            return false;
        }

        int deltaX = Math.abs(toLine - line);
        int deltaY = Math.abs(toColumn - column);
        boolean res = ((deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2));
        boolean endOk = chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayer);
        return endOk && res;
    }

    public String getSymbol() {
        return "H";
    }

}
