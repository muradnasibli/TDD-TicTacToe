package TicTacToeTdd;

public class TicTacToe {

    private char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

    private char lastPlayer = '\0';

    public String play(int x, int y) {

        checkXAxis(x);
        checkYAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);

        for (int index = 0; index < 3; index++) {
            if (board[0][index] == lastPlayer &&
                    board[1][index] == lastPlayer &&
                    board[2][index] == lastPlayer) {
                return lastPlayer + " is the winner";
            }
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

}
