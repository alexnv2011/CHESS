public class Queen extends ChessPiece {
    public Queen (String color) {
        super(color);
    }
    public String getColor(){
        return this.color;
    }
    public String getSymbol() {
        return "Q";
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

        boolean res90 = (deltaCol>0 && deltaLine==0)  || (deltaCol==0 && deltaLine>0);
        boolean resDiag = (deltaCol == deltaLine);
        boolean endOk = chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayer);

        if (!endOk) {
            return false;
        }

        boolean res90Between = true;
        // 90 - check null between start to end
        if (deltaCol>0) { // column move
            if (toColumn > column) { // move right
                for (int col = column+1; col < toColumn; col++) {
                    if (chessBoard.board[line][col] != null) {
                        res90Between = false;
                    }
                }
            } else { // move left
                for (int col = toColumn-1; col > column; col--) {
                    if (chessBoard.board[line][col] != null) {
                        res90Between = false;
                    }
                }
            }
        }
        if (deltaLine>0) { // line move
            if (toLine > line) { // move up
                for (int lin = line+1; lin < toLine; lin++) {
                    if (chessBoard.board[lin][column] != null) {
                        res90Between = false;
                    }
                }
            } else { // move down
                for (int lin = toLine-1; lin > line; lin--) {
                    if (chessBoard.board[lin][column] != null) {
                        res90Between = false;
                    }
                }
            }
        }


        boolean resDiagBetween = true;
        // diagonal - check null between start to end
        if (toColumn > column) { // move right
            if (toLine > line) { // move up
                for (int i = 1; i < (toColumn - column); i++) {
                    if (chessBoard.board[line + i][column + i] != null) {
                        resDiagBetween = false;
                    }
                }
            } else { // move down
                for (int i = 1; i < (toColumn - column); i++) {
                    if (chessBoard.board[line - i][column + i] != null) {
                        resDiagBetween = false;
                    }
                }
            }

        } else { // move left
            if (toLine > line) { // move up
                for (int i = 1; i < (column - toColumn); i++) {
                    if (chessBoard.board[line + i][column - i] != null) {
                        resDiagBetween = false;
                    }
                }
            } else { // move down
                for (int i = 1; i < (column - toColumn); i++) {
                    if (chessBoard.board[toLine - i][column - i] != null) {
                        resDiagBetween = false;
                    }
                }
            }
        }



        return (res90 && res90Between) || (resDiag && resDiagBetween);
    }
}