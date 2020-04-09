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

    public void play(Player opponent) {
        Options.Move opponentMove = opponent.name == Options.Opponent.COMPUTER.toString()
                ? Options.Move.values()[(int) (Math.random() * Options.Move.values().length)]
                : opponent.getMove();

        System.out.format("========== %s VS %s ==========\n", this.getMove().toString().toUpperCase(),
                opponentMove.toString().toUpperCase());

        var winnerText = "Jogador(a) %s ganhou! Parabéns. :)\n";
        if (this.move.wins(opponentMove)) {
            this.addVictories();
            opponent.addDefeats();

            System.out.format(winnerText, this.getName());
        } else if (this.move.loses(opponentMove)) {
            opponent.addVictories();
            this.addDefeats();

            System.out.format(winnerText, opponent.getName());
        } else {
            this.addTies();
            opponent.addTies();

            System.out.println("Empate!");
        }
    }

    public void scoreboard() {
        System.out.format("========== RESULTADOS [%s] ==========\n", this.getName().toUpperCase());
        System.out.format("Vitórias: %d\n", this.getVictories());
        System.out.format("Derrotas: %d\n", this.getDefeats());
        System.out.format("Empates: %d\n", this.getTies());
    }
}