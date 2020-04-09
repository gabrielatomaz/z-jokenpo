import java.util.ArrayList;

public class Player {
    private String name;
    private Options.Move move;
    private int victories;
    private int defeats;
    private int ties;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Options.Move getMove() {
        return this.move;
    }

    public void setMove(Options.Move move) {
        this.move = move;
    }

    public void addVictories() {
        this.victories++;
    }

    public int getVictories() {
        return this.victories;
    }

    public void addDefeats() {
        this.defeats++;
    }

    public int getDefeats() {
        return this.defeats;
    }

    public int setWins() {
        return this.wins;
    }

    public void addTies() {
        this.ties++;
    }

    public int getTies() {
        return this.ties;
    }

    public void play(Player playerOne, Player playerTwo) {
        Options.Move playerTwoMove = playerTwo.name == Options.Opponent.COMPUTER.toString()
                ? Options.Move.values()[(int) (Math.random() * Options.Move.values().length)]
                : playerTwo.getMove();

        if (playerOne.move.wins(playerTwoMove)) {
            playerOne.addVictories();
            playerTwo.addDefeats();
        } else if (playerOne.move.loses(playerTwoMove)) {
            playerTwo.addVictories();
            playerOne.addDefeats();
        } else {
            playerTwo.addTies();
            playerOne.addTies();
        }
    }
}