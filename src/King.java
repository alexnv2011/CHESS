public class King extends ChessPiece {
    public King (String color) {
        super(color);
    }
    public String getColor(){
        return this.color;
    }
    public String getSymbol() {
        return "K";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(inBoard(line, column) && inBoard(toLine, toColumn))) {
            return false; // out board
        }
        if ((line == toLine) && (column == toColumn)) {
            return false; // no move
        }

        int deltaLine = Math.abs(toLine - line);
        int deltaCol = Math.abs(toColumn - column);

        boolean resCol = deltaCol<2;
        boolean resLine = deltaLine<2;

        boolean endOk = chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayer);

        boolean isUnderAttack = isUnderAttack(chessBoard, toLine, toColumn);

        return resCol && resLine && endOk && !isUnderAttack;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int l = 0; l < 8; l++) {
            for (int c = 0; c < 8; c++) {
                // if enemy can move - true
                if (board.board[l][c] != null && !board.board[l][c].getColor().equals(board.nowPlayer)) {
                    if (board.board[l][c].canMoveToPosition(board, l, c, line, column) ) {
                        return true;
                    }
                }
            }
        }

        return false;

    }
}
