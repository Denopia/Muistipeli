package GameCharacter;

import Tile.Tile;
import TileController.TileController;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

//Testit jaivat pieniksi koska loput metodit liittyvat kuviin joita ei kai tarvinnut testata
//En myoskaan testannut muita hahmoja koska toimivat tasmalleen samoin kuin tama luokka

public class GusTest {

    Gus gus;

    @Before
    public void setUp() {
        gus = new Gus();
    }

    @Test
    public void canSetAndGetValues1() {
        assertEquals(gus.getHp(), 30);
        assertEquals(gus.getEnergy(), 15);
        gus.setHp(1);
        assertEquals(gus.getHp(), 1);
        gus.setEnergy(2);
        assertEquals(gus.getEnergy(), 2);
    }

    @Test
    public void canUseSkill() {
//        TileController tc = new TileController(18);
//        tc.shuffleTiles();
//        ArrayList<Tile> tiles = gus.useSkill(tc.getTiles(), 2);
//        int i = 12;
//        for (Tile tile : tiles) {
//            assertEquals(tile.getPlacement(), i);
//            i++;
//        }
    }

}
