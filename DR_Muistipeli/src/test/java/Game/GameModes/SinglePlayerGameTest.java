package Game.GameModes;

import Game.GameScreen;
import GameCharacter.Gus;
import Player.Computer.Opponent;
import Player.Human.Player;
import javax.swing.JFrame;
import org.junit.Before;

//Kasittelee paljon muita luokkia ja testit menisi hankaliksi ja 
//suurimmaksi osaksi tulisi testailtua ne uudestaan

public class SinglePlayerGameTest {

    SinglePlayerGame bspg;
    Player player;
    Opponent opponent;

    @Before
    public void setUp() {
        player = new Player();
        opponent = new Opponent();
        player.setCharacter(new Gus());
        opponent.setCharacter(new Gus());
        bspg = new SinglePlayerGame(4, new JFrame(), new GameScreen(new JFrame(), 1000), player, opponent, 1000);
    }

}
