package Tile;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TileTest {

    private Tile t;

    @Before
    public void setUp() {
        t = new Tile("health+2", "watchblank2x.png", "watchhighlight2x.png", "watch2x1turn.png");
    }

    @Test
    public void canSetAndGetCoordinates() {
        t.setCoordinates(1, 2);
        Assert.assertEquals(1, t.getX());
        Assert.assertEquals(2, t.getY());
    }

    @Test
    public void canSetAndGetPlacement() {
        t.setPlacement(3);
        Assert.assertEquals(3, t.getPlacement());
    }

    @Test
    public void canTurn() {
        Assert.assertFalse(t.getTurned());
        t.turn();
        Assert.assertTrue(t.getTurned());
        t.unTurn();
        Assert.assertFalse(t.getTurned());
    }

    @Test
    public void canHighlight() {
        Assert.assertFalse(t.getHighlight());
        t.highlight();
        Assert.assertTrue(t.getHighlight());
        t.unHighlight();
        Assert.assertFalse(t.getHighlight());
    }

    @Test
    public void canPair() {
        Assert.assertFalse(t.getPaired());
        t.pair();
        Assert.assertTrue(t.getPaired());
    }

    @Test
    public void canSetAndGetCurrentImagePath() {
        Assert.assertEquals("watchblank2x.png", t.getImage());
        Assert.assertEquals("watchhighlight2x.png", t.getHighlightBorder());
        t.turn();
        Assert.assertEquals("watch2x1turn.png", t.getImage());
    }

}
