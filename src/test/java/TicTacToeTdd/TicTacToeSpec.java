package TicTacToeTdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TicTacToeSpec {

    private TicTacToe ticTacToe;

    @BeforeEach
    void init() {
        ticTacToe = new TicTacToe();
    }

    @Test
    void whenXOutsideBoardThenRuntimeException() {

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            ticTacToe.play(5, 2);
        });

        assertEquals("X is outside board", thrown.getMessage());
    }

    @Test
    void whenYOutsideBoardTheRuntimeException() {

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            ticTacToe.play(2, 5);
        });

        assertEquals("Y is outside board", thrown.getMessage());
    }

    @Test
    void whenOccupiedThenRuntimeException(){
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            ticTacToe.play(2,1); // X success
            ticTacToe.play(2,1); // O false
        });

        assertEquals("Box is occupied", thrown.getMessage());
    }

    @Test
    void givenFirstTurnWhenNextPlayerThenX(){
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    void givenLastTurnWhenNextPlayerThenO(){
        ticTacToe.play(1, 1);
        assertEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    void whenPlayThenNoWinner(){
        String actual = ticTacToe.play(1,1);
        assertEquals("No winner", actual);
    }

    @Test
    void whenPlayAndWholeHorizontalLineThenWinner(){
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // O
        String actual = ticTacToe.play(3, 1); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    void whenPlayAndWholeVerticalLineThenWinner(){
        ticTacToe.play(2, 1); // X
        ticTacToe.play(1, 1); // O
        ticTacToe.play(3, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        String actual = ticTacToe.play(1, 3); // O
        assertEquals("O is the winner", actual);
    }

    @Test
    void whenPlayAndWholeVerticalLineThenWinnerAnotherOption(){
        ticTacToe.play(3, 1); // X
        ticTacToe.play(2,2); // O
        ticTacToe.play(3,2); // X
        ticTacToe.play(2,3); // O
        String actual = ticTacToe.play(3,3); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    void whenPlayAndNoOneWinAfterVerticalAndHorizontalGame(){
        ticTacToe.play(1,1); // X
        ticTacToe.play(2,1); // O
        ticTacToe.play(1,2); // X
        ticTacToe.play(1,3); // O
        ticTacToe.play(2,2); // X
        ticTacToe.play(3,2); // O
        ticTacToe.play(2,3); // X
        ticTacToe.play(3,3); // O
        String actual = ticTacToe.play(3,1); // X
        assertEquals("No winner", actual);
    }

    @Test
    void whenPlayAndTopBottomDiagonalLineThenWinner(){
        ticTacToe.play(1,1); // X
        ticTacToe.play(1,2); // O
        ticTacToe.play(2,2); // X
        ticTacToe.play(2,1); // O
        String actual = ticTacToe.play(3,3); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    void whenPlayAndBottomTopDiagonalLineThenWinner(){
        ticTacToe.play(1,3); // X
        ticTacToe.play(1,1); // O
        ticTacToe.play(2,2); // X
        ticTacToe.play(2,3); // O
        String actual = ticTacToe.play(3,1); // X
        assertEquals("X is the winner", actual);
    }
}
