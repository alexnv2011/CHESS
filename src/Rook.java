public class Rook extends ChessPiece {
    public Rook (String color) {
        super(color);
    }
    public String getColor(){
        return this.color;
    }
    public String getSymbol() {
        return "R";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(inBoard(line, column) && inBoard(toLine, toColumn))) {
            return false;
        }
        if ((line == toLine) && (column == toColumn)) {
            return false;
        }

        int deltaLine = Math.abs(toLine - line);
        int deltaCol = Math.abs(toColumn - column);

        boolean res = (deltaCol>0 && deltaLine==0) || (deltaCol==0 && deltaLine>0);
        if (!res) {
            return false; }

        // check null between start to end
        if (deltaCol>0) { // column move
            if (toColumn > column) { // move right
                for (int col = column+1; col < toColumn; col++) {
                    if (chessBoard.board[line][col] != null) {
                        return false;
                    }
                }
            } else { // move left
                for (int col = toColumn-1; col > column; col--) {
                    if (chessBoard.board[line][col] != null) {
                        return false;
                    }
                }
            }
        }

        if (deltaLine>0) { // line move
            if (toLine > line) { // move up
                for (int lin = line+1; lin < toLine; lin++) {
                    if (chessBoard.board[lin][column] != null) {
                        return false;
                    }
                }
            } else { // move down
                for (int lin = toLine-1; lin > line; lin--) {
                    if (chessBoard.board[lin][column] != null) {
                        return false;
                    }
                }
            }
        }

        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayer);
    }
}
