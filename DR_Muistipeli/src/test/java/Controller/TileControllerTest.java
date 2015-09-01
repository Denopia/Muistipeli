package Controller;

import Game.GameModes.SinglePlayerGame;
import Game.GameScreen;
import GameCharacter.Gus;
import Player.Computer.Opponent;
import Player.Human.Player;
import Tile.Tile;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TileControllerTest {

    private TileController c;

    @Before
    public void setUp() {
        c = new TileController(18);
    }

    @Test
    public void canSetCoordinates() {
        c.setCoordinates6x6();
        Assert.assertEquals(251, c.getTiles().get(0).getX());
        Assert.assertEquals(148, c.getTiles().get(0).getY());
    }

    @Test
    public void canUnturnAll() {
        Assert.assertEquals(0, c.getTilesTurned());
        c.getTiles().get(0).turn();
        c.getTiles().get(1).turn();
        c.getTiles().get(2).turn();
        Assert.assertEquals(3, c.getTilesTurned());
        c.unTurnTiles();
        Assert.assertEquals(0, c.getTilesTurned());
    }

    @Test
    public void canUnhighlightAll() {
        Assert.assertEquals(false, c.getTiles().get(0).getHighlight());
        c.getTiles().get(0).highlight();
        Assert.assertEquals(true, c.getTiles().get(0).getHighlight());
        c.unHighlightAll();
        Assert.assertEquals(false, c.getTiles().get(0).getHighlight());
    }

    @Test
    public void canUnTurnUnpairedTilesAndPairedTilesStayPaired() {
        Assert.assertEquals(0, c.getTilesTurned());
        c.getTiles().get(0).turn();
        c.getTiles().get(1).turn();
        c.getTiles().get(2).turn();
        Assert.assertEquals(3, c.getTilesTurned());
        c.getTiles().get(0).pair();
        c.getTiles().get(2).pair();
        c.unTurnUnpairedTiles();
        Assert.assertEquals(0, c.getTilesTurned());
        Assert.assertEquals(true, c.getTiles().get(0).getPaired());
        Assert.assertEquals(true, c.getTiles().get(2).getPaired());
    }

    @Test
    public void canGetTilesTurned() {
        Assert.assertEquals(0, c.getTilesTurned());
        c.getTiles().get(0).turn();
        c.getTiles().get(1).turn();
        c.getTiles().get(2).turn();
        Assert.assertEquals(3, c.getTilesTurned());
    }

    @Test
    public void canGetTilesPaired() {
        Assert.assertEquals(0, c.getTilesTurned());
        c.getTiles().get(0).pair();
        c.getTiles().get(1).pair();
        c.getTiles().get(2).pair();
        Assert.assertEquals(3, c.getTilesPaired());
    }

    @Test
    public void canCheckIfAnyTileIsTurned() {
        Assert.assertFalse(c.tileIsTurned());
        c.getTiles().get(0).turn();
        Assert.assertTrue(c.tileIsTurned());
    }

    @Test
    public void canGetAListOfPairedTiles() {
        Tile tile = c.getTiles().get(0);
        tile.pair();
        ArrayList<Tile> tiles = c.getPairedTiles();
        Assert.assertEquals(tile, tiles.get(0));
    }

    @Test
    public void canGetAListOfHiddenTiles() {
        Tile tile = c.getTiles().get(0);
        for (Tile tile2 : c.getTiles()) {
            tile2.turn();
        }
        tile.unTurn();
        ArrayList<Tile> tiles = c.getHiddenTiles();
        Assert.assertEquals(tile, tiles.get(0));
    }

    @Test
    public void canTurnAListOfTiles() {
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(c.getTiles().get(0));
        Assert.assertFalse(c.getTiles().get(0).getTurned());
        c.turnTheseTiles(tiles);
        Assert.assertTrue(c.getTiles().get(0).getTurned());
    }

    @Test
    public void tileEffectsWorkWithPlayer() {
        Tile tile = new Tile("health+2", "watchblank2x.png", "watchhighlight2x.png", "watch2x1turn.png");
        Player p = new Player();
        p.setCharacter(new Gus());
        Opponent o = new Opponent();
        o.setCharacter(new Gus());
        SinglePlayerGame g = new SinglePlayerGame(18, new JFrame(), new GameScreen(new JFrame()), p, o);
        p.getCharacter().setHp(10);
        Assert.assertEquals(10, p.getCharacter().getHp());
        c.doTileEffectForPlayer(g, tile);
        Assert.assertEquals(12, p.getCharacter().getHp());
    }

    @Test
    public void tileEffectsWorkWithOpponent() {
        Tile tile = new Tile("health+2", "watchblank2x.png", "watchhighlight2x.png", "watch2x1turn.png");
        Player p = new Player();
        p.setCharacter(new Gus());
        Opponent o = new Opponent();
        o.setCharacter(new Gus());
        SinglePlayerGame g = new SinglePlayerGame(18, new JFrame(), new GameScreen(new JFrame()), p, o);
        o.getCharacter().setHp(10);
        Assert.assertEquals(10, o.getCharacter().getHp());
        c.doTileEffectForOpponent(g, tile);
        Assert.assertEquals(12, o.getCharacter().getHp());
    }

}
