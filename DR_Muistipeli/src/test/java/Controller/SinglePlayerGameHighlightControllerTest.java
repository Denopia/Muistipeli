package Controller;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class SinglePlayerGameHighlightControllerTest {

    private SinglePlayerGameHighlightController c;

    @Before
    public void setUp() {
        c = new SinglePlayerGameHighlightController();
    }

    @Test
    public void getHighlightedVerticalRow() {
        Assert.assertEquals(-1, c.getVerRow());
        c.setVerRowTrue(6);
        Assert.assertEquals(6, c.getVerRow());
    }
    
    @Test
    public void getHighlightedHorizontalRow() {
        Assert.assertEquals(-1, c.getHorRow());
        c.setHorRowTrue(6);
        Assert.assertEquals(6, c.getHorRow());
    }
    
    @Test
    public void canToggleHit(){
        Assert.assertFalse(c.getHitH());
        c.highlightHit();
        Assert.assertTrue(c.getHitH());
        c.unHighlightHit();
        Assert.assertFalse(c.getHitH());
    }
    
    @Test
    public void canToggleSkill(){
        Assert.assertFalse(c.getSkillH());
        c.highlightSkill();
        Assert.assertTrue(c.getSkillH());
        c.unHighlightSkill();
        Assert.assertFalse(c.getSkillH());
    }
    
    @Test
    public void canToggleExit(){
        Assert.assertFalse(c.getExitH());
        c.highlightExit();
        Assert.assertTrue(c.getExitH());
        c.unHighlightExit();
        Assert.assertFalse(c.getExitH());
    }

}
