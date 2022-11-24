package org.bowling;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {

    BowlingGame game;

    @BeforeEach
    public void init(){
        game = new BowlingGame();
    }

    @AfterEach
    void tearDown() {
        game = null;
    }

    /**
     * Test : tous les essais KO,
     * Nombre de quilles tombées = 0 sur chaque tour
     * Total score = 0
     */
    @Test
    void testScoreNull(){
        openFrameGenerator(10, 0, 0);
        assertEquals(0, game.score());
    }

    /**
     * Test : tous les essais OK,
     * Nombre de quilles tombées = 5 sur chaque tour
     * Total score = 50
     */
    @Test
    void testFramesScoresFive(){
        openFrameGenerator(4, 2, 3);
        openFrameGenerator(6, 4, 1);
        assertEquals(50, game.score());
    }

    /**
     * Test : spare sur le premier tour, et (0, 3) sur le tour suivant, puis (0, 0) sur le reste
     * Nombre de quilles tombées = 13
     * Total score = 13
     */
    @Test
    void testSpareWithNextTourKo(){
        game.addSpare(2, 8);
        game.addOpenFrame(0, 3);
        openFrameGenerator(8, 0, 0);
        assertEquals(13, game.score());
    }

    /**
     * Test : spare sur le premier tour, et (4, 1) sur le tour suivant, puis (0, 0) sur le reste
     * Nombre de quilles tombées = 15
     * Total score = 19
     */
    @Test
    void testSpareWithNextTourOk(){
        game.addSpare(3, 7);
        game.addOpenFrame(4, 1);
        openFrameGenerator(8, 0, 0);
        assertEquals(19, game.score());
    }

    /**
     * Test : spare sur le dernier tour, et (0) sur l'essai Bonus, et (0, 0) sur le reste
     * Nombre de quilles tombées = 10
     * Total score = 10
     */
    @Test
    void testSpareFinalFrameWithBonusKo(){
        openFrameGenerator(9, 0, 0);
        game.addSpare(6, 4);
        game.addBonus(0);
        assertEquals(10, game.score());
    }

    /**
     * Test : spare sur le dernier tour, et (8) sur l'essai Bonus, et (0, 0) sur le reste
     * Nombre de quilles tombées = 18
     * Total score = 18
     */
    @Test
    void testSpareFinalFrameWithBonusOk(){
        openFrameGenerator(9, 0, 0);
        game.addSpare(6, 4);
        game.addBonus(8);
        assertEquals(18, game.score());
    }

    /**
     * Test : strike sur le premier tour, et (0, 0) sur le tour suivant, puis (0, 0) sur le reste
     * Nombre de quilles tombées = 10
     * Total score = 10
     */
    @Test
    void testStrikeWithNextTourKo(){
        game.addStrike();
        game.addOpenFrame(0, 0);
        openFrameGenerator(8, 0, 0);
        assertEquals(10, game.score());
    }

    /**
     * Test : strike sur le premier tour, et (1, 7) sur le tour suivant, puis (0, 0) sur le reste
     * Nombre de quilles tombées = 18
     * Total score = 26
     */
    @Test
    void testStrikeWithNextTourOk(){
        game.addStrike();
        game.addOpenFrame(1, 7);
        openFrameGenerator(8, 0, 0);
        assertEquals(26, game.score());
    }

    /**
     * Test : strike sur le dernier tour, et (0, 0) sur les essais Bonus, et (0, 0) sur le reste
     * Nombre de quilles tombées = 10
     * Total score = 10
     */
    @Test
    void testStrikeFinalFrameWithBonusKo(){
        openFrameGenerator(9, 0, 0);
        game.addStrike();
        game.addBonus(0);
        game.addBonus(0);
        assertEquals(10, game.score());
    }

    /**
     * Test : strike sur le dernier tour, et (8, 1) sur les essais Bonus, et (0, 0) sur le reste
     * Nombre de quilles tombées = 19
     * Total score = 19
     */
    @Test
    void testStrikeFinalFrameWithBonusOk(){
        openFrameGenerator(9, 0, 0);
        game.addStrike();
        game.addBonus(8);
        game.addBonus(1);
        assertEquals(19, game.score());
    }

    /**
     * Test : jeu contenant un spare, un strike avec bonus, et des tours OK
     * Nombre de quilles tombées = 62 + 8 en bonus
     * Total score = 75
     */
    @Test
    void testBowlingGameWithSpareAndStrike(){
        openFrameGenerator(2, 2, 5);
        game.addSpare(4, 6);
        game.addOpenFrame(5, 3);
        openFrameGenerator(5, 1, 3);
        game.addStrike();
        game.addBonus(4);
        game.addBonus(4);
        assertEquals(75, game.score());
    }


    /**
     * Génère un nombre précis de tours OpenFrame
     * @param rounds: nombre de tours à générer
     * @param firstTry : le score du premier essais des tours
     * @param secondTry : le score du second essais des tours
     */
    private void openFrameGenerator(int rounds, int firstTry, int secondTry){
        for(int i = 0; i < rounds; i++){
            game.addOpenFrame(firstTry, secondTry);
        }
    }
}