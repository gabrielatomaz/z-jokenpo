package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import app.Options.Move;

public class MoveTest {
    @Test
    public void rockWinsScissors() {
        assertTrue(Move.ROCK.wins(Move.SCISSORS));
        assertFalse(Move.ROCK.loses(Move.SCISSORS));
    }

    @Test
    public void rockWinsPaper() {
        assertTrue(Move.ROCK.wins(Move.PAPER));
        assertFalse(Move.ROCK.loses(Move.PAPER));
    }

    @Test
    public void paperWinsScissors() {
        assertTrue(Move.PAPER.wins(Move.SCISSORS));
        assertFalse(Move.PAPER.loses(Move.SCISSORS));
    }

    @Test
    public void paperWinsRock() {
        assertTrue(Move.PAPER.wins(Move.ROCK));
        assertFalse(Move.PAPER.loses(Move.ROCK));
    }

    @Test
    public void scissorsWinsPaper() {
        assertTrue(Move.SCISSORS.wins(Move.PAPER));
        assertFalse(Move.SCISSORS.loses(Move.PAPER));
    }

    @Test
    public void scissorsWinsRock() {
        assertTrue(Move.SCISSORS.wins(Move.ROCK));
        assertFalse(Move.SCISSORS.loses(Move.ROCK));
    }
}