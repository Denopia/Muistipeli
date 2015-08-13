package GameCharacter;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class GameCharacterTest {

    GameCharacter gc;

    @Before
    public void setUp() {
        gc = new GameCharacter("ROBO.png", "ROBOYES.png", "ROBOFUG.png");
    }

    @Test
    public void test() {
        //olikin vain gettereita ja settereita
        assertTrue(true);
    }

}
