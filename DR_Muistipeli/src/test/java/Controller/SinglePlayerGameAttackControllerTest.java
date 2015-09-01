package Controller;

import Game.GameModes.SinglePlayerGame;
import Game.GameScreen;
import GameCharacter.Gus;
import Player.Computer.Opponent;
import Player.Human.Player;
import javax.swing.JFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SinglePlayerGameAttackControllerTest {

    private SinglePlayerGameAttackController c;
    private Player p;
    private Opponent o;

    @Before
    public void setUp() {
        p = new Player();
        p.setCharacter(new Gus());
        o = new Opponent();
        o.setCharacter(new Gus());
        c = new SinglePlayerGameAttackController(new SinglePlayerGame(18, new JFrame(), new GameScreen(new JFrame()), p, o));
    }

    @Test
    public void canHitOpponent() {
        Assert.assertEquals(15, p.getCharacter().getEnergy());
        Assert.assertEquals(30, o.getCharacter().getHp());
        c.hitOpponent();
        Assert.assertEquals(14, p.getCharacter().getEnergy());
        Assert.assertEquals(29, o.getCharacter().getHp());
    }

    @Test
    public void canHitPlayer() {
        Assert.assertEquals(15, o.getCharacter().getEnergy());
        Assert.assertEquals(30, p.getCharacter().getHp());
        c.hitPlayer();
        Assert.assertEquals(14, o.getCharacter().getEnergy());
        Assert.assertEquals(29, p.getCharacter().getHp());
    }
    
    @Test
    public void canNotHitOpponentIfNoEnergy() {
        p.getCharacter().setEnergy(0);
        Assert.assertEquals(0, p.getCharacter().getEnergy());
        Assert.assertEquals(30, o.getCharacter().getHp());
        c.hitOpponent();
        Assert.assertEquals(0, p.getCharacter().getEnergy());
        Assert.assertEquals(30, o.getCharacter().getHp());
    }

    @Test
    public void canNotHitPlayerIfNoEnergy() {
        o.getCharacter().setEnergy(0);
        Assert.assertEquals(0, o.getCharacter().getEnergy());
        Assert.assertEquals(30, p.getCharacter().getHp());
        c.hitPlayer();
        Assert.assertEquals(0, o.getCharacter().getEnergy());
        Assert.assertEquals(30, p.getCharacter().getHp());
    }

}
