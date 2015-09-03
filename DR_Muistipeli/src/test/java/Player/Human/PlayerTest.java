package Player.Human;

import GameCharacter.Apollo;
import GameCharacter.GameCharacter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player p;

    @Before
    public void setUp() {
        p = new Player();
    }

    @Test
    public void canAddAndSubtractMoves() {
        Assert.assertEquals(0, p.getMoves());
        p.addMove();
        p.addMove();
        Assert.assertEquals(2, p.getMoves());
        p.removeMove();
        Assert.assertEquals(1, p.getMoves());
    }

    @Test
    public void canToggleNeutralState() {
        Assert.assertTrue(p.getNeutralState());
        p.setNeutralStateFalse();
        Assert.assertFalse(p.getNeutralState());
        p.setNeutralStateTrue();
        Assert.assertTrue(p.getNeutralState());
    }

    @Test
    public void canSetCharacter() {
        GameCharacter c = new Apollo();
        Assert.assertNull(p.getCharacter());
        p.setCharacter(c);
        Assert.assertEquals(new Apollo().getClass(), p.getCharacter().getClass());
    }

    @Test
    public void canAddAndSubtractHits() {
        Assert.assertEquals(0, p.getHitsLeft());
        p.addHit();
        p.addHit();
        Assert.assertEquals(2, p.getHitsLeft());
        p.removeHit();
        Assert.assertEquals(1, p.getHitsLeft());
    }

    @Test
    public void canToggleSkillSelected() {
        Assert.assertFalse(p.getSkillSelected());
        p.selectSkill();
        Assert.assertTrue(p.getSkillSelected());
        p.deselectSkill();
        Assert.assertFalse(p.getSkillSelected());
    }

}
