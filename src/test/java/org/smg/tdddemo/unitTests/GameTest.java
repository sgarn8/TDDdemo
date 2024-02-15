package org.smg.tdddemo.unitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.smg.tdddemo.Game;

public class GameTest {
    private static Game game;
    @BeforeEach
    public void setup() {
        game = new Game(); // failes after this until Game class is created
    }
    @Test 
    public void givenAnEmptyGame_returnScoreOf0 () {
        int[] rolls={ };
        Assertions.assertNotNull(game, "A Game instance was not instantiated");
        Assertions.assertEquals(0, game.score(rolls),
                "ScoreOfEmptyGame did not equal 0");
    }

    @Test
    public void givenA1PinRollThen1Gutter_returnScoreOf1() {
        int[] rolls = {1,0};
        Assertions.assertEquals(1, game.score(rolls));
    }

    @Test
    public void given10FramesOf1PinRollFollowedByGutter_returnScoreOf10() {
        int[] rolls = {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0};
        Assertions.assertEquals(10, game.score(rolls));
    }
    @Test
    public void givenAStrikeRollFollowedBy2_1PinRolls_returnScoreOf14() {
        Game game = new Game();
        int[] rolls = {10,1,1};
        Assertions.assertEquals(14, game.score(rolls));
    }
    @Test
    public void given12_Strikes_returnScoreOf300_PerfectGame() {
        Game game = new Game();
        int[] rolls = {10,10,10,10,10,10,10,10,10,10,10,10};
        Assertions.assertEquals(300, game.score(rolls));
    }

    @Test
    public void givenASpareRollFollowedBy2Gutters_returnScoreOf10() {
        Game game = new Game();
        int[] rolls = {0,10,0,0};
        Assertions.assertEquals(10, game.score(rolls));
    }

    @Test
    public void givenASpareFollowedByAStrikeFollowedBy2Gutters_returnScoreOf30() {
        Game game = new Game();
        int[] rolls = {0,10,10,0,0};
        Assertions.assertEquals(30, game.score(rolls));
    }

    @Test
    public void given10_9PinSparesFollowedByA9PinRoll_returnScoreOf190() {
        Game game = new Game();
        int[] rolls = {9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9};
        Assertions.assertEquals(190, game.score(rolls));
    }

    @Test
    public void given10_8PinSparesFollowedByA8PinRoll_returnScoreOf18() {
        Game game = new Game();
        int[] rolls = {8,2,8,2,8,2,8,2,8,2,8,2,8,2,8,2,8,2,8,2,8};
        Assertions.assertEquals(180, game.score(rolls));
    }

    @Test
    public void given11_StrikesFollowedByA9PinRoll_returnScoreOf299() {
        Game game = new Game();
        int[] rolls = {10,10,10,10,10,10,10,10,10,10,10,9};
        Assertions.assertEquals(299, game.score(rolls));
    }
}
