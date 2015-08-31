package Game;

import GameCharacter.Gus;
import Player.Computer.Opponent;
import Player.Human.Player;
import javax.swing.JFrame;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class GamePreparationTest {

    //Pelin aloittaminen ja valikkoon palaaminen
    //jatetaan testaamatta koska ne luovat uusia luokkia GameScreen luokan kautta ja se menisi
    //jo kovin sekavaksi
    GamePreparation gp;

    @Before
    public void setUp() {
        gp = new GamePreparation(2, new JFrame(), new GameScreen(new JFrame()));
    }

//    @Test
//    public void canMakePlayer() {
//        Player bp = gp.makePlayer(1, 1);
//        assertEquals(bp.getCharacter().getClass(), new Gus().getClass());
//    }
//
//    @Test
//    public void canMakeOpponent() {
//        Opponent bo = gp.makeOpponent(1, 1, 1);
//        assertEquals(bo.getCharacter().getClass(), new Gus().getClass());
//    }

    @Test
    public void canChangePlayerCharacter() {
        assertEquals(gp.getPlayerCharacter(), 1);
        gp.nextPlayerCharacter();
        assertEquals(gp.getPlayerCharacter(), 2);
        gp.nextPlayerCharacter();
        assertEquals(gp.getPlayerCharacter(), 3);
        gp.nextPlayerCharacter();
        assertEquals(gp.getPlayerCharacter(), 1);
        gp.previousPlayerCharacter();
        assertEquals(gp.getPlayerCharacter(), 3);
        gp.previousPlayerCharacter();
        assertEquals(gp.getPlayerCharacter(), 2);
    }

    @Test
    public void canChangeOpponentCharacter() {
        assertEquals(gp.getOpponentCharacter(), 1);
        gp.nextOpponentCharacter();
        assertEquals(gp.getOpponentCharacter(), 2);
        gp.nextOpponentCharacter();
        assertEquals(gp.getOpponentCharacter(), 3);
        gp.nextOpponentCharacter();
        assertEquals(gp.getOpponentCharacter(), 1);
        gp.previousOpponentCharacter();
        assertEquals(gp.getOpponentCharacter(), 3);
        gp.previousOpponentCharacter();
        assertEquals(gp.getOpponentCharacter(), 2);
    }

}
