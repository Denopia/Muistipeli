package Game.GameModes;

import Game.GameScreen;
import javax.swing.JFrame;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class NormalSinglePlayerGameTest {

    NormalSinglePlayerGame NSPG;

    @Before
    public void setUp() {
        NSPG = new NormalSinglePlayerGame(4, new JFrame(), new GameScreen(new JFrame()), 1, 1, 1);
    }

    @Test
    public void turnChanges() {
        assertTrue(NSPG.isPlayersTurn());
        NSPG.changeTurn();
        assertFalse(NSPG.isPlayersTurn());
    }

}
