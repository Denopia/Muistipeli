package Player.Computer;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

//Jatetaan testaamatta metodit jotka kasittelevat kuvia pelihahmon kautta ja ne metodit jotka vain
//kutsuvat vastustajan apuluokkia OpponentTileController ja OpponentTurnCOntroller
//jotka kuitenkin testataan erikseen
public class OpponentTest {

    Opponent op;

    @Before
    public void setUp() {
        op = new Opponent();
    }

    @Test
    public void canSetAndGetValues1() {
        op.setDifficulty(2);
        assertEquals(op.getDifficulty(), 2);

    }

    @Test
    public void canSetAndGetValues2() {
        Assert.assertFalse(op.getHitThisTurn());
        op.setHitThisTurnTrue();
        Assert.assertTrue(op.getHitThisTurn());
        op.setHitThisTurnFalse();
        Assert.assertFalse(op.getHitThisTurn());

    }

}
