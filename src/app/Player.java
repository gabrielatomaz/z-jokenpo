package app;

import app.Options.Move;
import app.Options.Opponent;

public class Player {
    private String name;
    private Move move;
    private int victories;
    private int defeats;
    private int ties;

    public Player() { }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Move getMove() {
        return this.move;
    }

    public void setMove(Move move) {
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
        Move opponentMove = opponent.name == Opponent.COMPUTER.toString()
                ? Move.values()[(int) (Math.random() * Move.values().length)]
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

        this.scoreboard();
        opponent.scoreboard();
    }

    public void defineMove() {
        var move = askMove(true);

        while (!(move.charAt(0) == 'p' || move.charAt(0) == 't') || move.length() < 2)
            move = askMove(false);

        this.setMove(Move.convert(move));
    }

    private void scoreboard() {
        System.out.format("========== RESULTADOS [%s] ==========\n", this.getName().toUpperCase());
        System.out.format("Vitórias: %d\n", this.getVictories());
        System.out.format("Derrotas: %d\n", this.getDefeats());
        System.out.format("Empates: %d\n", this.getTies());
    }

    private String askMove(boolean isFirstTime) {
        var moveQuestion = String.format("%s, pedra, papel ou tesoura?", this.getName());

        if (isFirstTime)
            System.out.println(moveQuestion);
        else
            System.out.format("Por favor, responda a pergunta corretamente!\n%s\n", moveQuestion);

        return new String(System.console().readPassword()).toLowerCase();
    }
}