package Game.GameModes;

import Game.GameScreen;
import GameCharacter.Gus;
import Player.AIOpponent.AIBattleOpponent;
import Player.Human.BattlePlayer;
import javax.swing.JFrame;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BattleSinglePlayerGameTest {

    //Taas on kasa gettereita ja settereita, framen repainttailua ja muuta, mita
    //ei viitsi testata.
    BattleSinglePlayerGame bspg;

    @Before
    public void setUp() {
        bspg = new BattleSinglePlayerGame(4, new JFrame(), new GameScreen(new JFrame()), new BattlePlayer(), new AIBattleOpponent());
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
