package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import app.Player;
import app.Options.Move;

public class PlayerTest {

    @Test
    public void playerWonWithPaper() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.PAPER);
        opponent.setMove(Move.ROCK);

        player.play(opponent);

        assertTrue(player.getVictories() > 0);
        assertFalse(opponent.getVictories() > 0);
    }

    @Test
    public void playerWonWithPaperTwo() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.PAPER);
        opponent.setMove(Move.SCISSORS);

        player.play(opponent);

        assertTrue(player.getVictories() > 0);
        assertFalse(opponent.getVictories() > 0);
    }

    @Test
    public void playerWonWithRock() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.ROCK);
        opponent.setMove(Move.SCISSORS);

        player.play(opponent);

        assertTrue(player.getVictories() > 0);
        assertFalse(opponent.getVictories() > 0);
    }

    @Test
    public void playerWonWithRockTwo() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.ROCK);
        opponent.setMove(Move.PAPER);

        player.play(opponent);

        assertTrue(player.getVictories() > 0);
        assertFalse(opponent.getVictories() > 0);
    }

    @Test
    public void playerWonWithScissors() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.SCISSORS);
        opponent.setMove(Move.PAPER);

        player.play(opponent);

        assertTrue(player.getVictories() > 0);
        assertFalse(opponent.getVictories() > 0);
    }

    @Test
    public void playerWonWithScissorsTwo() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.SCISSORS);
        opponent.setMove(Move.ROCK);

        player.play(opponent);

        assertTrue(player.getVictories() > 0);
        assertFalse(opponent.getVictories() > 0);
    }

    @Test
    public void playerBeatsOpponentWithRockAgainstScissorsEverytime() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.ROCK);
        opponent.setMove(Move.SCISSORS);

        var testTimes = 10;
        for (var i = 0; i < testTimes; i++) 
            player.play(opponent);
        
        assertEquals(10, player.getVictories());
    }

    @Test
    public void playerBeatsOpponentWithRockAgainstPaperEverytime() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.ROCK);
        opponent.setMove(Move.PAPER);

        var testTimes = 10;
        for (var i = 0; i < testTimes; i++) 
            player.play(opponent);
        
        assertEquals(10, player.getVictories());
    }

    @Test
    public void playerBeatsOpponentWithPaperAgainstScissorsEverytime() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.PAPER);
        opponent.setMove(Move.SCISSORS);

        var testTimes = 20;
        for (var i = 0; i < testTimes; i++) 
            player.play(opponent);
        
        assertEquals(20, player.getVictories());
    }

    @Test
    public void playerBeatsOpponentWithPaperAgainstRockEverytime() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.PAPER);
        opponent.setMove(Move.ROCK);

        var testTimes = 20;
        for (var i = 0; i < testTimes; i++) 
            player.play(opponent);
        
        assertEquals(20, player.getVictories());
    }

    @Test
    public void playerBeatsOpponentWithScissorsAgainstPaperEverytime() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.SCISSORS);
        opponent.setMove(Move.PAPER);

        var testTimes = 30;
        for (var i = 0; i < testTimes; i++) 
            player.play(opponent);
        
        assertEquals(30, player.getVictories());
    }

    @Test
    public void playerBeatsOpponentWithScissorsAgainstRockEverytime() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.SCISSORS);
        opponent.setMove(Move.ROCK);

        var testTimes = 30;
        for (var i = 0; i < testTimes; i++) 
            player.play(opponent);
        
        assertEquals(30, player.getVictories());
    }

    @Test
    public void sameMovesTie() {
        var player = new Player("Jogador Teste");
        var opponent = new Player("Oponente Teste");

        player.setMove(Move.SCISSORS);
        opponent.setMove(Move.SCISSORS);

        player.play(opponent);

        player.setMove(Move.PAPER);
        opponent.setMove(Move.PAPER);

        player.play(opponent);

        player.setMove(Move.ROCK);
        opponent.setMove(Move.ROCK);

        player.play(opponent);
        
        assertEquals(3, player.getTies());
        assertEquals(3, opponent.getTies());
    }
}