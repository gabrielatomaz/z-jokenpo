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
        },
        PAPER {
            public boolean wins(Move move) {
                return move == Move.ROCK;
            }

            @Override
            public boolean loses(Move move) {
                return move == Move.SCISSORS;
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
        };

        public abstract boolean wins(Move move);

        public abstract boolean loses(Move move);
    }

    public enum Opponent {
        COMPUTER, PERSON
    }

    private Opponent opponent;
    private Move move;

    public void setOpponent(String opponent) {
        this.opponent = opponent.toLowerCase().charAt(0) == 'c' ? Opponent.COMPUTER : Opponent.PERSON;
    }

    public Opponent getOpponent() {
        return this.opponent;
    }

    public void setMove(String move) {
        if (move.charAt(0) == 'p') {
            if (move.charAt(1) == 'e')
                this.move = Move.ROCK;
            else
                this.move = Move.PAPER;
        } else {
            this.move = Move.SCISSORS;
        }
    }

    public Move getMove() {
        return this.move;
    }
}