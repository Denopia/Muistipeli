package Tile;

import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class NormalTileTest {

    NormalTile tile;

    @Before
    public void setup() {
        tile = new NormalTile(1, "watchBlank2x.png", "watchhighlight2x.png", "watch2x0.png");
    }

    @Test
    public void correctId() {
        assertEquals(1, tile.getId());
    }

    @Test
    public void canAssignCoordinates() {
        tile.setCoordinates(2, 4);
        assertEquals(2, tile.getX());
        assertEquals(4, tile.getY());
    }

    @Test
    public void canTurnOnlyUnturned() {
        assertEquals(false, tile.getTurned());
        tile.turn();
        assertEquals(true, tile.getTurned());
        tile.pair();
        assertEquals(false, tile.getTurned());
        tile.turn();
        assertEquals(false, tile.getTurned());
        
    }

    @Test
    public void canPair() {
        assertEquals(false, tile.getPaired());
        tile.pair();
        assertEquals(true, tile.getPaired());
    }

    @Test
    public void canUnturn() {
        assertEquals(false, tile.getTurned());
        tile.turn();
        assertEquals(true, tile.getTurned());
        tile.unTurn();
        assertEquals(false, tile.getTurned());
        tile.turn();
        tile.pair();
        assertEquals(false, tile.getTurned());
        tile.unTurn();
        assertEquals(true, tile.getPaired());
    }

    @Test
    public void canHighlight() {
        assertEquals(false, tile.getHighlight());
        tile.highlight();
        assertEquals(true, tile.getHighlight());
        tile.unHighlight();
        assertEquals(false, tile.getHighlight());
        tile.pair();
        tile.highlight();
        assertEquals(false, tile.getHighlight());
        tile.unHighlight();
        assertEquals(false, tile.getHighlight());
    }

}
