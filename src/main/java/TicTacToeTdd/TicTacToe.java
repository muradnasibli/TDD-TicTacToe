package TicTacToeTdd;

public class TicTacToe {

    private char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

    private char lastPlayer = '\0';

    private static final int SIZE = 3;

    public String play(int x, int y) {

        checkXAxis(x);
        checkYAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);

        if (isWin()){
            return lastPlayer + " is the winner";
        }

        return "No winner";
    }

    private void setBox(int x, int y, char lastPlayer) {

        if (board[x - 1][y - 1] != '-') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }

    private void checkXAxis(int x) {

        if (x < 1 || x > 3) {
            throw new RuntimeException("X is outside board");
        }
    }

    private void checkYAxis(int y) {

        if (y < 1 || y > 3) {
            throw new RuntimeException("Y is outside board");
        }
    }

    public char nextPlayer() {

        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

    private boolean isWin() {
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] + board[1][i] + board[2][i]
                    == (lastPlayer * SIZE)) {
                return true;
            }
        }
        return false;
    }
}
