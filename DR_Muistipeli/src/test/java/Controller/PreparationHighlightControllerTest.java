package Controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PreparationHighlightControllerTest {

    private PreparationHighlightController c;

    @Before
    public void setUp() {
        c = new PreparationHighlightController();
    }

    @Test
    public void canToggleA1() {
        Assert.assertFalse(c.getA1());
        c.highlightA1();
        Assert.assertTrue(c.getA1());
        c.unHighlightAll();
        Assert.assertFalse(c.getA1());
    }

    @Test
    public void canToggleA2() {
        Assert.assertFalse(c.getA2());
        c.highlightA2();
        Assert.assertTrue(c.getA2());
        c.unHighlightAll();
        Assert.assertFalse(c.getA2());
    }

    @Test
    public void canToggleA3() {
        Assert.assertFalse(c.getA3());
        c.highlightA3();
        Assert.assertTrue(c.getA3());
        c.unHighlightAll();
        Assert.assertFalse(c.getA3());
    }

    @Test
    public void canToggleA4() {
        Assert.assertFalse(c.getA4());
        c.highlightA4();
        Assert.assertTrue(c.getA4());
        c.unHighlightAll();
        Assert.assertFalse(c.getA4());
    }

    @Test
    public void canToggleD1() {
        Assert.assertFalse(c.getD1());
        c.highlightD1();
        Assert.assertTrue(c.getD1());
        c.unHighlightAll();
        Assert.assertFalse(c.getD1());
    }

    @Test
    public void canToggleD2() {
        Assert.assertFalse(c.getD2());
        c.highlightD2();
        Assert.assertTrue(c.getD2());
        c.unHighlightAll();
        Assert.assertFalse(c.getD2());
    }

    @Test
    public void canToggleD3() {
        Assert.assertFalse(c.getD3());
        c.highlightD3();
        Assert.assertTrue(c.getD3());
        c.unHighlightAll();
        Assert.assertFalse(c.getD3());
    }

    @Test
    public void canToggleD4() {
        Assert.assertFalse(c.getD4());
        c.highlightD4();
        Assert.assertTrue(c.getD4());
        c.unHighlightAll();
        Assert.assertFalse(c.getD4());
    }

    @Test
    public void canToggleMenu() {
        Assert.assertFalse(c.getMenu());
        c.highlightMenu();
        Assert.assertTrue(c.getMenu());
        c.unHighlightAll();
        Assert.assertFalse(c.getMenu());
    }

    @Test
    public void canToggleStart() {
        Assert.assertFalse(c.getStart());
        c.highlightStart();
        Assert.assertTrue(c.getStart());
        c.unHighlightAll();
        Assert.assertFalse(c.getStart());
    }
}
