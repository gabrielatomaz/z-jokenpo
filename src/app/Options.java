package app;

public class Options {
    public enum Move {
        ROCK {
            @Override
            public boolean wins(Move move) {
                return move == Move.SCISSORS;
            }

            @Override
            public boolean loses(Move move) {
                return move == Move.PAPER;
            }

            @Override
            public String toString() {
                return "Pedra";
            }
        },
        PAPER {
            public boolean wins(Move move) {
                return move == Move.ROCK;
            }

            @Override
            public boolean loses(Move move) {
                return move == Move.SCISSORS;
            }

            @Override
            public String toString() {
                return "Papel";
            }
        },
        SCISSORS {
            public boolean wins(Move move) {
                return move == Move.PAPER;
            }

            @Override
            public boolean loses(Move move) {
                return move == Move.ROCK;
            }

            @Override
            public String toString() {
                return "Tesoura";
            }
        };

        public abstract boolean wins(Move move);

        public abstract boolean loses(Move move);

        public static Move convert(String move) {
            if (move.charAt(0) == 'p')
                return move.charAt(1) == 'e' ? Move.ROCK : Move.PAPER;

            return Move.SCISSORS;
        }
    }

    public enum Opponent {
        COMPUTER {
            @Override
            public String toString() {
                return "Computador";
            }
        },
        PERSON {
            @Override
            public String toString() {
                return "Pessoa";
            }
        };

        public static Opponent convert(String opponent) {
            return opponent.toLowerCase().charAt(0) == 'c' ? Opponent.COMPUTER : Opponent.PERSON;
        }
    }
}