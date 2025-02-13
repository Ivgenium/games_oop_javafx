package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BishopBlackTest {
    @Test
    public void whenAnObjectIsCreatedThanTheSameCell() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C8);
    }

    @Test
    public void whenAnObjectIsCopiedThanTheSameCell() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.copy(Cell.C8).position()).isEqualTo(Cell.C8);
    }

    @Test
    public void whenTheObjectWaysFromC1ToG5ThanSuccess() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5)).isEqualTo(expected);
    }

    @Test
    public void whenMoveThenImpossibleMoveException()
            throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            bishopBlack.way(Cell.C2);
        });
        assertThat(exception.getMessage()).isEqualTo(String.format("Could not move by diagonal from %s to %s", bishopBlack.position(), Cell.C2));
    }

    @Test
    public void whenTheObjectIsMovingDiagonally() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.isDiagonal(bishopBlack.position(), Cell.A6)).isTrue();
    }

    @Test
    public void whenTheObjectIsNotMovingDiagonally() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.isDiagonal(bishopBlack.position(), Cell.D6)).isFalse();
    }
}