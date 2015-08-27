package Tile;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


//Tassakin luokassa pyoritellaan kuvia joita ei nyt testata

public class TileTest {

    Tile tile;

    @Before
    public void setUp() {
        tile = new Tile(1, "watchblank2x.png", "watchblank2x.png", "watchblank2x.png");
    }

    @Test
    public void canSetAndGetValues() {
        tile.setCoordinates(7, 999);
        tile.setPlacement(45);
        assertEquals(tile.getPlacement(), 45);
        assertEquals(tile.getX(), 7);
        assertEquals(tile.getY(), 999);
        assertEquals(tile.getId(), 1);
        Assert.assertFalse(tile.getPaired());
        Assert.assertFalse(tile.getTurned());
    }

    @Test
    public void canHighlight() {
        Assert.assertFalse(tile.getHighlight());
        tile.highlight();
        Assert.assertTrue(tile.getHighlight());
        tile.unHighlight();
        Assert.assertFalse(tile.getHighlight());
    }
}
