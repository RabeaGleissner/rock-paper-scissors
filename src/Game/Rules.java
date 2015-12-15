package game;

import static game.Move.*;

public class Rules {

    private Move humanChoice;
    private Move computerChoice;

    public Rules(Move humanChoice, Move computerChoice) {
        this.humanChoice = humanChoice;
        this.computerChoice = computerChoice;
    }

    public GameEnd gameEndState() {
        Move winningMove = winningMove();

        if (winningMove == humanChoice) {
            return GameEnd.HUMAN_WIN;
        } else if (winningMove == computerChoice) {
            return GameEnd.COMPUTER_WIN;
        } else if (draw()) {
            return GameEnd.DRAW;
        } else {
            return null;
        }
    }

    private Move winningMove() {
        if (paperWins() ) {
            return PAPER;
        } else if (rockWins()) {
            return ROCK;
        } else  {
            return SCISSORS;
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

    private boolean draw() {
        return humanChoice == computerChoice;
    }
}
