package GameCharacter;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class GusTest {

    Gus gus;

    @Before
    public void setUp() {
        gus = new Gus();
    }

    @Test
    public void canSetAndGetHpAndEnergy() {
        assertEquals(gus.getHp(), 30);
        assertEquals(gus.getEnergy(), 15);
        gus.setHp(1);
        assertEquals(gus.getHp(), 1);
        gus.setEnergy(2);
        assertEquals(gus.getEnergy(), 2);
    }

    @Test
    public void canSetAndGetImagePaths() {
        gus.setImages1();
        gus.setNeutral();
        Assert.assertEquals("character/gus/gus_neutral.png", gus.getCurrentImage());
        gus.setHp(2);
        gus.setNeutral();
        Assert.assertEquals("character/gus/gus_damaged.png", gus.getCurrentImage());
        gus.setHappy();
        Assert.assertEquals("character/gus/gus_yes.png", gus.getCurrentImage());
        gus.setUnhappy();
        Assert.assertEquals("character/gus/gus_no.png", gus.getCurrentImage());
        gus.setTakeDamage();
        Assert.assertEquals("character/gus/gus_take_damage.png", gus.getCurrentImage());
        gus.setGiveDamage();
        Assert.assertEquals("character/gus/gus_give_damage.png", gus.getCurrentImage());
    }

}
