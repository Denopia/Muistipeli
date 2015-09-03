package Game;

import GameCharacter.Gus;
import Player.Computer.Opponent;
import Player.Human.Player;
import javax.swing.JFrame;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

    //Ei testata metodeja jotka kaskevat GameScreenia tekemaan uusia luookkia

public class GamePreparationTest {

    GamePreparation gp;

    @Before
    public void setUp() {
        gp = new GamePreparation(1, new JFrame(), new GameScreen(new JFrame(), 1000), 1000);
    }

    @Test
    public void canMakePlayer() {
        Player bp = gp.makePlayer(1);
        assertEquals(bp.getCharacter().getClass(), new Gus().getClass());
    }

    @Test
    public void canMakeOpponent() {
        Opponent bo = gp.makeOpponent(1, 1);
        assertEquals(bo.getCharacter().getClass(), new Gus().getClass());
    }

    @Test
    public void canChangePlayerCharacter() {
        assertEquals(gp.getPlayerCharacter(), 1);
        gp.nextPlayerCharacter();
        assertEquals(gp.getPlayerCharacter(), 2);
        gp.nextPlayerCharacter();
        assertEquals(gp.getPlayerCharacter(), 1);
        gp.previousPlayerCharacter();
        assertEquals(gp.getPlayerCharacter(), 2);
    }

    @Test
    public void canChangeOpponentCharacter() {
        assertEquals(gp.getOpponentCharacter(), 1);
        gp.nextOpponentCharacter();
        assertEquals(gp.getOpponentCharacter(), 2);
        gp.nextOpponentCharacter();
        assertEquals(gp.getOpponentCharacter(), 1);
        gp.previousOpponentCharacter();
        assertEquals(gp.getOpponentCharacter(), 2);
    }

    @Test
    public void canChangeDifficulty() {
        assertEquals(2, gp.getDifficulty());
        gp.setDifficulty(1);
        assertEquals(1, gp.getDifficulty());
        gp.setDifficulty(3);
        assertEquals(3, gp.getDifficulty());
        gp.setDifficulty(4);
        assertEquals(4, gp.getDifficulty());
    }

    @Test
    public void canGetGameMode() {
        assertEquals(1, gp.getMode());
    }

}
