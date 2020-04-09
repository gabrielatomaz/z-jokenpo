import java.util.Scanner;

public class Jokenpo {
    public static void main(String[] args) throws JokenpoException {
        try {
            System.out.println("Olá! :) \n===========Bem-vindo ao jogo=========== \n");

            var scanner = new Scanner(System.in);
            var options = new Options();
            var player = new Player();
            var opponentPlayer = new Player();
            
            System.out.println("Qual o seu nome?");
            player.setName(scanner.nextLine());
            
            var opponentQuestion = "Você deseja jogar com um computador ou oponente?";
            System.out.println(opponentQuestion);
            var opponent = scanner.nextLine().toLowerCase();
            while (!(opponent.charAt(0) == 'c' || opponent.charAt(0) == 'o')) {
                System.out.format("Por favor, responda a pergunta corretamente!\n%s\n", opponentQuestion);
                opponent = scanner.nextLine().toLowerCase();
            }
            options.setOpponent(opponent);
            
            var playing = true;
            while (playing) {
                var moveQuestion = String.format("%s, pedra, papel ou tesoura?", player.getName());
                System.out.println(moveQuestion);
                var move = scanner.nextLine().toLowerCase();
                while (!(move.charAt(0) == 'p' || move.charAt(0) == 't') || move.length() < 2) {
                    System.out.format("Por favor, responda a pergunta corretamente!\n%s\n", moveQuestion);
                    move = scanner.nextLine().toLowerCase();
                }
                options.setMove(move);

                player.setMove(options.getMove());

                if (options.getOpponent() == Options.Opponent.COMPUTER) {
                    opponentPlayer.setName(Options.Opponent.COMPUTER.toString());
                } else {
                    System.out.println("Qual o nome do seu oponente?");
                    opponentPlayer.setName(scanner.nextLine());

                    moveQuestion = String.format("%s, pedra, papel ou tesoura?", opponentPlayer.getName());
                    System.out.println(moveQuestion);
                    move = scanner.nextLine().toLowerCase();
                    while (!(move.charAt(0) == 'p' || move.charAt(0) == 't') || move.length() < 2) {
                        System.out.format("Por favor, responda a pergunta corretamente!\n%s\n", moveQuestion);
                        move = scanner.nextLine().toLowerCase();
                    }
                    options.setMove(move);

                    opponentPlayer.setMove(options.getMove());
                }

                player.play(player, opponentPlayer);

                player.scoreboard();
                opponentPlayer.scoreboard();

                System.out.println("Deseja jogar novamente?");
                playing = scanner.nextLine().toLowerCase().equals("sim");
            }
        } catch (Exception e) {
            throw new JokenpoException("Ops! Parece que alguma coisa deu errado!", e);
        }
    }
}