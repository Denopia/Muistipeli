package Game.GameModes;

import Game.GameScreen;
import GameCharacter.Gus;
import Player.Computer.Opponent;
import Player.Human.Player;
import javax.swing.JFrame;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class SinglePlayerGameTest {

    //Taas on kasa gettereita ja settereita, framen repainttailua ja muuta, mita
    //ei viitsi testata.
    SinglePlayerGame bspg;

    @Before
    public void setUp() {
        bspg = new SinglePlayerGame(4, new JFrame(), new GameScreen(new JFrame()), new Player(), new Opponent());
    }

    @Test
    public void canHitOpponentOnlyIfEnoughEnergy() {
        bspg.getPlayer().setCharacter(new Gus());
        bspg.getOpponent().setCharacter(new Gus());
        bspg.getPlayer().getCharacter().setEnergy(6);
        bspg.getOpponent().getCharacter().setHp(12);
        bspg.hitOpponent();
        assertEquals(bspg.getOpponent().getCharacter().getHp(), 6);
        assertEquals(bspg.getPlayer().getCharacter().getEnergy(), 0);
        bspg.hitOpponent();
        assertEquals(bspg.getOpponent().getCharacter().getHp(), 6);
        assertEquals(bspg.getPlayer().getCharacter().getEnergy(), 0);
    }

}
