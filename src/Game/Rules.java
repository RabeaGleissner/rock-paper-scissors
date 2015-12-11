package game;

import static game.Move.*;

public class Rules {

    private Move humanChoice;
    private Move computerChoice;

    public Rules(Move humanChoice, Move computerChoice) {
        this.humanChoice = humanChoice;
        this.computerChoice = computerChoice;
    }

    public Winner gameEndState() {
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
            return PAPER;
        } else if (rockWins()) {
            return ROCK;
        } else if (scissorsWin()) {
            return SCISSORS;
        } else {
            return null;
        }
    }

    private boolean paperWins() {
        return ((humanChoice == ROCK) && (computerChoice == PAPER)) ||
                ((humanChoice  == PAPER) && (computerChoice == ROCK));
    }

    private boolean rockWins() {
        return ((humanChoice == ROCK) && (computerChoice == SCISSORS)) ||
                ((humanChoice == SCISSORS) && (computerChoice == ROCK));
    }

    private boolean scissorsWin() {
        return ((humanChoice == PAPER) && (computerChoice == SCISSORS)) ||
                ((humanChoice == SCISSORS) && (computerChoice == PAPER));
    }

    private boolean draw() {
        return humanChoice == computerChoice;
    }
}
