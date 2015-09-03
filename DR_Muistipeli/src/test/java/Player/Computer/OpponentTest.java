package Player.Computer;

import GameCharacter.Apollo;
import GameCharacter.GameCharacter;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class OpponentTest {

    Opponent o;

    @Before
    public void setUp() {
        o = new Opponent();
    }

    @Test
    public void canSetAndGetDifficulty() {
        o.setDifficulty(2);
        assertEquals(o.getDifficulty(), 2);

    }

    @Test
    public void canAddAndSubtractHits() {
        Assert.assertEquals(0, o.getHitsLeft());
        o.addHit();
        o.addHit();
        Assert.assertEquals(2, o.getHitsLeft());
        o.removeHit();
        Assert.assertEquals(1, o.getHitsLeft());
    }
    
    @Test
    public void canAddAndSubtractMoves() {
        Assert.assertEquals(0, o.getMoves());
        o.addMove();
        o.addMove();
        Assert.assertEquals(2, o.getMoves());
        o.removeMove();
        Assert.assertEquals(1, o.getMoves());
    }
    
    @Test
    public void canSetCharacter() {
        GameCharacter c = new Apollo();
        Assert.assertNull(o.getCharacter());
        o.setCharacter(c);
        Assert.assertEquals(new Apollo().getClass(), o.getCharacter().getClass());
    }
  

}
