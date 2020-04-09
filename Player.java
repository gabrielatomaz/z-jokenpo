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
        this.victories += 1;
    }

    public int getVictories() {
        return this.victories;
    }

    public void addDefeats() {
        this.defeats += 1;
    }

    public int getDefeats() {
        return this.defeats;
    }

    public void addTies() {
        this.ties += 1;
    }

    public int getTies() {
        return this.ties;
    }

    public void play(Player playerOne, Player playerTwo) {
        Options.Move playerTwoMove = playerTwo.name == Options.Opponent.COMPUTER.toString()
                ? Options.Move.values()[(int) (Math.random() * Options.Move.values().length)]
                : playerTwo.getMove();

        System.out.println(String.format("========== %s VS %s ==========", playerOne.getMove(), playerTwoMove));

        var winnerText = "Jogador(a) %s ganhou! Parabéns. :)";
        if (playerOne.move.wins(playerTwoMove)) {
            playerOne.addVictories();
            playerTwo.addDefeats();

            System.out.println(String.format(winnerText, playerOne.getName()));
        } else if (playerOne.move.loses(playerTwoMove)) {
            playerTwo.addVictories();
            playerOne.addDefeats();

            System.out.println(String.format(winnerText, playerTwo.getName()));
        } else {
            playerTwo.addTies();
            playerOne.addTies();

            System.out.println("Empate!");
        }
    }

    public void scoreboard() {
        System.out.println(String.format("========== RESULTADOS %s ==========", this.getName()));
        System.out.println(String.format("Vitórias: %d", this.getVictories()));
        System.out.println(String.format("Derrotas: %d", this.getDefeats()));
        System.out.println(String.format("Empates: %d", this.getTies()));
    }
}