package Player.Human;

import Player.Human.NormalPlayer;
import Tile.NormalTile;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class NormalPlayerTest {

    NormalPlayer player;

    @Before
    public void setUp() {
        player = new NormalPlayer();
    }

    @Test
    public void canScoreTiles() {
        assertEquals(player.getNumberOfPairsScored(), 0);
        player.addScoredPair(new NormalTile(1, "watchBlank2x.png", "watchBlank2x.png", "watchBlank2x.png"));
        assertEquals(player.getNumberOfPairsScored(), 1);
    }

}
