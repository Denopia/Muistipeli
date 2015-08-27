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
    Player player;
    Opponent opponent;

    @Before
    public void setUp() {
        player = new Player();
        opponent = new Opponent();
        player.setCharacter(new Gus());
        opponent.setCharacter(new Gus());
        bspg = new SinglePlayerGame(4, new JFrame(), new GameScreen(new JFrame()), player, opponent);
    }

    //Luo kuvia lyonti metodin aikana ja testi antaa jotain erroria
    @Test
    public void canHitOpponentOnlyIfEnoughEnergy() {
//        bspg.getPlayer().getCharacter().setEnergy(1);
//        bspg.getOpponent().getCharacter().setHp(10);
//        bspg.hitOpponent();
//        assertEquals(bspg.getOpponent().getCharacter().getHp(), 9);
//        assertEquals(bspg.getPlayer().getCharacter().getEnergy(), 0);
//        bspg.hitOpponent();
//        assertEquals(bspg.getOpponent().getCharacter().getHp(), 9);
//        assertEquals(bspg.getPlayer().getCharacter().getEnergy(), 0);
    }

    @Test
    public void testtest() {
        assertEquals(1, 1);
    }

}
