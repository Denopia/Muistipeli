package Controller;

import Tile.Tile;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TileControllerTest {

    TileController tc;

    @Before
    public void setup() {
        tc = new TileController(18);
    }

    @Test
    public void hasTiles() {
        assertNotEquals(null, tc.getTiles());
    }

    @Test
    public void canShuffle() {
        ArrayList<Tile> tiles = tc.getTiles();
        tc.shuffleTiles();
        //:]
    }

    @Test
    public void setsCoordinates() {
        assertEquals(0, tc.getTiles().get(0).getX());
        tc.setCoordinates6x6();
        assertEquals(251, tc.getTiles().get(0).getX());
    }

    @Test
    public void correctlyChecksPairs() {
        tc.getTiles().get(0).turn();
        tc.getTiles().get(1).turn();
        assertEquals(tc.checkPair(), true);
        tc.getTiles().get(0).unTurn();
        tc.getTiles().get(1).unTurn();
        tc.getTiles().get(2).turn();
        tc.getTiles().get(4).turn();
        assertEquals(tc.checkPair(), false);

    }

    @Test
    public void pairsTiles() {
        assertEquals(tc.pairedTiles(), 0);
        tc.getTiles().get(0).turn();
        tc.getTiles().get(1).turn();
        tc.pairTiles();
        assertEquals(tc.pairedTiles(), 2);
    }

    @Test
    public void canUnhighlightTiles() {
        assertEquals(tc.getTiles().get(0).getHighlight(), false);
        tc.getTiles().get(0).highlight();
        assertEquals(tc.getTiles().get(0).getHighlight(), true);
        tc.unHighlightAll();
        assertEquals(tc.getTiles().get(0).getHighlight(), false);
    }

    @Test
    public void canUnturnTiles() {
        assertEquals(tc.getTiles().get(0).getTurned(), false);
        tc.getTiles().get(0).turn();
        assertEquals(tc.getTiles().get(0).getTurned(), true);
        tc.unTurnTiles();
        assertEquals(tc.getTiles().get(0).getTurned(), false);
    }

    @Test
    public void cantUnturnPairedTiles() {
        tc.getTiles().get(0).turn();
        tc.getTiles().get(1).turn();
        tc.pairTiles();
        assertEquals(tc.getTiles().get(0).getTurned(), false);
        assertEquals(tc.getTiles().get(1).getTurned(), false);
        tc.unTurnUnpairedTiles();
        assertEquals(tc.getTiles().get(0).getTurned(), false);
        assertEquals(tc.getTiles().get(1).getTurned(), false);
    }
}
