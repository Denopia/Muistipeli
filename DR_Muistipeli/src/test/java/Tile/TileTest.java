package Tile;

import org.junit.Before;

public class TileTest {

    private Tile t;

    @Before
    public void setUp() {
        t = new Tile("health+2", "watchblank2x.png", "watchhighlight2x.png", "watch2x1turn.png");
    }

}
