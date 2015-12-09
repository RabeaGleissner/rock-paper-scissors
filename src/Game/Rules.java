package game;

import java.util.Objects;

public class Rules {

    private Move humanChoice;
    private Move computerChoice;

    public Rules(Move humanChoice, Move computerChoice) {
        this.humanChoice = humanChoice;
        this.computerChoice = computerChoice;
    }

    public Winner findWinner() {
        Move winningMove = winningMove();

        if (winningMove == humanChoice) {
            return Winner.HUMAN;
        } else if (winningMove == computerChoice) {
            return Winner.COMPUTER;
        } else if (draw()) {
            return Winner.DRAW;
        } else {
            return null;
        }
    }

    private Move winningMove() {
        if (paperWins() ) {
            return Move.PAPER;
        } else if (rockWins()) {
            return Move.ROCK;
        } else if (scissorsWin()) {
            return Move.SCISSORS;
        } else {
            return null;
        }
    }

    private boolean paperWins() {
        return ((humanChoice == Move.ROCK) && (computerChoice == Move.PAPER)) ||
                ((humanChoice  == Move.PAPER) && (computerChoice == Move.ROCK));
    }

    private boolean rockWins() {
        return ((humanChoice == Move.ROCK) && (computerChoice == Move.SCISSORS)) ||
                ((humanChoice == Move.SCISSORS) && (computerChoice == Move.ROCK));
    }

    private boolean scissorsWin() {
        return ((humanChoice == Move.PAPER) && (computerChoice == Move.SCISSORS)) ||
                ((humanChoice == Move.SCISSORS) && (computerChoice == Move.PAPER));
    }

    private boolean draw() {
        return Objects.equals(humanChoice, computerChoice);
    }
}
