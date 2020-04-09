package app;

import java.util.Scanner;

import app.Options.Move;
import app.Options.Opponent;
import app.exceptions.JokenpoException;

public class App {
    public static void main(String[] args) throws JokenpoException {
        try {
            System.out.println("OLÁ! :)\n===========BEM-VINDO AO JOGO===========\n");

            var scanner = new Scanner(System.in);
            var player = new Player();
            var opponent = new Player();

            System.out.println("Qual o seu nome?");
            player.setName(scanner.nextLine());

            var opponentQuestion = "Você deseja jogar com um computador ou oponente?";
            System.out.println(opponentQuestion);
            var opponentType = scanner.nextLine().toLowerCase();

            while (!(opponentType.charAt(0) == 'c' || opponentType.charAt(0) == 'o')) {
                System.out.format("Por favor, responda a pergunta corretamente!\n%s\n", opponentQuestion);
                opponentType = scanner.nextLine().toLowerCase();
            }

            opponentType = Opponent.convert(opponentType).toString();

            if (opponentType == Opponent.PERSON.toString()) {
                System.out.println("Qual o nome do seu oponente?");
                opponent.setName(scanner.nextLine());
            }

            var playing = true;
            while (playing) {
                jokenpo(opponentType, player, opponent);

                player.play(opponent);

                player.scoreboard();
                opponent.scoreboard();

                System.out.println("Deseja jogar novamente?");
                playing = scanner.nextLine().toLowerCase().equals("sim");
            }
        } catch (Exception error) {
            throw new JokenpoException("Ops! Parece que alguma coisa deu errado!", error);
        }
    }

    public static void jokenpo(String opponentType, Player player, Player opponent) {
        defineMove(player);

        var computer = Opponent.COMPUTER.toString();
        if (opponentType == computer)
            opponent.setName(computer);
        else
            defineMove(opponent);
    }

    public static String askMove(Player player, boolean isFirstTime) {
        var moveQuestion = String.format("%s, pedra, papel ou tesoura?", player.getName());

        if (isFirstTime)
            System.out.println(moveQuestion);
        else
            System.out.format("Por favor, responda a pergunta corretamente!\n%s\n", moveQuestion);

        return new String(System.console().readPassword()).toLowerCase();
    }

    public static void defineMove(Player player) {
        var move = askMove(player, true);

        while (!(move.charAt(0) == 'p' || move.charAt(0) == 't') || move.length() < 2)
            move = askMove(player, false);

        player.setMove(Move.convert(move));
    }
}