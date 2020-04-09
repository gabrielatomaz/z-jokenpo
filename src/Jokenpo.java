
import java.util.Scanner;
import Exceptions;

public class Jokenpo {
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

            opponentType = Options.Opponent.convert(opponentType).toString();

            if (opponentType == Options.Opponent.PERSON.toString()) {
                System.out.println("Qual o nome do seu oponente?");
                opponent.setName(scanner.nextLine());
            }

            var playing = true;
            while (playing) {
                var moveQuestion = String.format("%s, pedra, papel ou tesoura?", player.getName());
                System.out.println(moveQuestion);
                var move = scanner.nextLine().toLowerCase();

                while (!(move.charAt(0) == 'p' || move.charAt(0) == 't') || move.length() < 2) {
                    System.out.format("Por favor, responda a pergunta corretamente!\n%s\n", moveQuestion);
                    move = scanner.nextLine().toLowerCase();
                }

                player.setMove(Options.Move.convert(move));

                if (opponentType == Options.Opponent.COMPUTER.toString()) {
                    opponent.setName(Options.Opponent.COMPUTER.toString());
                } else {
                    moveQuestion = String.format("%s, pedra, papel ou tesoura?", opponent.getName());
                    System.out.println(moveQuestion);
                    move = scanner.nextLine().toLowerCase();
                    
                    while (!(move.charAt(0) == 'p' || move.charAt(0) == 't') || move.length() < 2) {
                        System.out.format("Por favor, responda a pergunta corretamente!\n%s\n", moveQuestion);
                        move = scanner.nextLine().toLowerCase();
                    }

                    opponent.setMove(Options.Move.convert(move));
                }

                player.play(opponent);

                player.scoreboard();
                opponent.scoreboard();

                System.out.println("Deseja jogar novamente?");
                playing = scanner.nextLine().toLowerCase().equals("sim");
            }
        } catch (Exception e) {
            throw new JokenpoException("Ops! Parece que alguma coisa deu errado!", e);
        }
    }
}