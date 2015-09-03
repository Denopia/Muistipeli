/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameCharacter;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ApolloTest {

    private Apollo apollo;

    @Before
    public void setUp() {
        apollo = new Apollo();
    }

    @Test
    public void canSetAndGetHpAndEnergy() {
        assertEquals(apollo.getHp(), 30);
        assertEquals(apollo.getEnergy(), 15);
        apollo.setHp(1);
        assertEquals(apollo.getHp(), 1);
        apollo.setEnergy(2);
        assertEquals(apollo.getEnergy(), 2);
    }

    @Test
    public void canSetAndGetImagePaths() {
        apollo.setImages1();
        apollo.setNeutral();
        Assert.assertEquals("character/apollo/apollo_neutral.png", apollo.getCurrentImage());
        apollo.setHp(2);
        apollo.setNeutral();
        Assert.assertEquals("character/apollo/apollo_damaged.png", apollo.getCurrentImage());
        apollo.setHappy();
        Assert.assertEquals("character/apollo/apollo_yes.png", apollo.getCurrentImage());
        apollo.setUnhappy();
        Assert.assertEquals("character/apollo/apollo_no.png", apollo.getCurrentImage());
        apollo.setTakeDamage();
        Assert.assertEquals("character/apollo/apollo_take_damage.png", apollo.getCurrentImage());
        apollo.setGiveDamage();
        Assert.assertEquals("character/apollo/apollo_give_damage.png", apollo.getCurrentImage());
    }
}
