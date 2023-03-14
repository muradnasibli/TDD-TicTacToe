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

        if (isWin(x, y)) {
            return lastPlayer + " is the winner";
        } else if (isDraw()) {
            return "The result is draw";
        } else {
            return "No winner";
        }
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

    private boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * 3;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';

        for (int i = 0, row = 0; i < SIZE; i++, row++) {
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }

        if (horizontal == playerTotal
                || vertical == playerTotal
                || diagonal1 == playerTotal
                || diagonal2 == playerTotal) {
            return true;
        }
        return false;
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
}
