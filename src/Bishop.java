public class Bishop extends ChessPiece {
    public Bishop (String color) {
        super(color);
    }
    public String getColor(){
        return this.color;
    }
    public String getSymbol() {
        return "B";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(inBoard(line, column) && inBoard(toLine, toColumn))) {
            return false;
        }
        if ((line == toLine) && (column == toColumn)) { // no move --> false
            return false;
        }

        int deltaLine = Math.abs(toLine - line);
        int deltaCol = Math.abs(toColumn - column);

        if (deltaCol != deltaLine) {  // if not diagonal move --> false
            return false;
        }

        // check null between start to end
        if (toColumn > column) { // move right
            if (toLine > line) { // move up
                for (int i = 1; i < (toColumn - column); i++) {
                    if (chessBoard.board[line + i][column + i] != null) {
                        return false;
                    }
                }
            } else { // move down
                for (int i = 1; i < (toColumn - column); i++) {
                    if (chessBoard.board[line - i][column + i] != null) {
                        return false;
                    }
                }
            }

        } else { // move left
            if (toLine > line) { // move up
                for (int i = 1; i < (column - toColumn); i++) {
                    if (chessBoard.board[line + i][column - i] != null) {
                        return false;
                    }
                }
            } else { // move down
                for (int i = 1; i < (column - toColumn); i++) {
                    if (chessBoard.board[toLine - i][column - i] != null) {
                        return false;
                    }
                }
            }
        }


        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayer);
    }
}
