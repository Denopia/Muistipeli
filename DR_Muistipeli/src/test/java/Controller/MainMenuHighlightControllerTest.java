package Controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainMenuHighlightControllerTest {

    private MainMenuHighlightController c;

    @Before
    public void setUp() {
        c = new MainMenuHighlightController();
    }

    @Test
    public void canToggleSinglePlayerGame() {
        Assert.assertFalse(c.getSPG());
        c.highlightSPG();
        Assert.assertTrue(c.getSPG());
        c.unHighlightAll();
        Assert.assertFalse(c.getSPG());
    }

    @Test
    public void canToggleInstructions() {
        Assert.assertFalse(c.getIns());
        c.highlightIns();
        Assert.assertTrue(c.getIns());
        c.unHighlightAll();
        Assert.assertFalse(c.getIns());
    }

    @Test
    public void canToggleExit() {
        Assert.assertFalse(c.getExit());
        c.highlightExit();
        Assert.assertTrue(c.getExit());
        c.unHighlightAll();
        Assert.assertFalse(c.getExit());
    }

}
