import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorsGameTest {

    private RockPaperScissorsGame game;

    @BeforeEach
    void setUp() {
        game = new RockPaperScissorsGame();
    }

    @Test
    void testInitialGameStats() {
        assertEquals(0, game.getTotalGames());
        assertEquals(0, game.getPlayer1Wins());
        assertEquals(0, game.getTotalDraws());
        assertEquals(0, game.getOpponentWins());
        assertEquals(0.0, game.getWinRate());
        assertEquals(0.0, game.getDrawRate());
    }

    @Test
    void testPlayGameIncrementsTotalGames() {
        game.playGame(1); // Simulate playing with "Rock"
        assertEquals(1, game.getTotalGames());
    }

    @Test
    void testPlayGameUpdatesStatsCorrectly() {
        game.playGame(1); // Play with "Rock"
        assertTrue(game.getTotalGames() > 0);
        assertTrue(game.getPlayer1Wins() >= 0);
        assertTrue(game.getOpponentWins() >= 0);
        assertTrue(game.getTotalDraws() >= 0);
    }

    @Test
    void testWinRateCalculation() {
        game.playGame(1); // Simulate a game
        game.calculateWinRate();
        assertTrue(game.getWinRate() >= 0 && game.getWinRate() <= 100);
    }

    @Test
    void testDrawRateCalculation() {
        game.playGame(1); // Simulate a game
        game.calculateDrawRate();
        assertTrue(game.getDrawRate() >= 0 && game.getDrawRate() <= 100);
    }

    @Test
    void testChoiceTracking() {
        game.playGame(1); // Rock
        game.playGame(2); // Paper
        game.playGame(3); // Scissors

        assertEquals(1, game.getRockCount());
        assertEquals(1, game.getPaperCount());
        assertEquals(1, game.getScissorsCount());
    }

    @Test
    void testMoveToString() {
        assertEquals("Rock", game.moveToString(1));
        assertEquals("Paper", game.moveToString(2));
        assertEquals("Scissors", game.moveToString(3));
        assertEquals("Invalid Selection, Play Again", game.moveToString(4));
    }

    @Test
    void testGameResultsAreStored() {
        game.playGame(1); // Play one game
        ArrayList<String> results = game.getGameResults();
        assertNotNull(results);
        assertEquals(1, results.size());
    }

    @Test
    void testChoicesStringOutput() {
        game.playGame(1); // Rock
        game.playGame(2); // Paper
        String choicesOutput = game.getChoicesString();
        assertNotNull(choicesOutput);
        assertTrue(choicesOutput.contains("Rock"));
        assertTrue(choicesOutput.contains("Paper"));
    }

    @Test
    void testWinDrawStringOutput() {
        game.playGame(1); // Simulate a game
        game.calculateWinRate();
        game.calculateDrawRate();
        String winDrawOutput = game.getWinsDrawsString();
        assertNotNull(winDrawOutput);
        assertTrue(winDrawOutput.contains("Win Rate"));
        assertTrue(winDrawOutput.contains("Draw Rate"));
    }
}
