package Controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InstructionsHighlightControllerTest {

    private InstructionsHighlightController c;

    @Before
    public void setUp() {
        c = new InstructionsHighlightController();
    }
    
    @Test 
    public void canToggleHighlight(){
        Assert.assertFalse(c.getMenuH());
        c.highlightMenu();
        Assert.assertTrue(c.getMenuH());
        c.unHighlightMenu();
        Assert.assertFalse(c.getMenuH());
    }

}
