package org.smg.tdddemo;

import java.util.Arrays;

public class Game {
    private int currRoll=0;
    int[] allRolls;

    public int score(int[] rolls) {
        int score = 0;
        int frame = 1;
        allRolls = Arrays.copyOf(rolls, rolls.length);
        while (frame <= 10 && currRoll<=rolls.length-1) {
            score += scoreFrame();
            frame++;
        }
        return score;
    }

    private int scoreFrame() {
        if (rolledAStrike()) {
            return scoreAStrike();
        } else if (rolledASpare()) {
            return scoreASpare();
        } else {
            return rolledAnOpenFrame();
        }
    }

    private boolean rolledASpare() {
        return allRolls[currRoll] + allRolls[currRoll + 1] == 10;
    }

    private boolean rolledAStrike() {
        return allRolls[currRoll] == 10;
    }

    private int rolledAnOpenFrame() {
        int frameScore;
        frameScore = allRolls[currRoll] + allRolls[currRoll+1];
        currRoll +=2;
        return frameScore;
    }

    private int scoreASpare() {
        int frameScore;
        frameScore = 10 + allRolls[currRoll+2];
        currRoll += 2;
        return frameScore;
    }

    private int scoreAStrike() {
        int frameScore;
        frameScore =  10 + allRolls[currRoll+1] + allRolls[currRoll+2];
        currRoll++;
        return frameScore;
    }
}
