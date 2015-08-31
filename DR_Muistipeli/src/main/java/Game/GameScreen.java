package Game;

import Game.GameModes.SinglePlayerGame;
import Player.Computer.Opponent;
import Player.Human.Player;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 * Kontrolloi pelin framea. Luo pelit ja valikon sekä ohjeet ja antaa framen
 * niille käyttöön. Kun näitä ei enää tarvita, tyhjentää framen ja rakentaa
 * uuden tarvittavan näkymän.
 *
 */
public class GameScreen {

    private final JFrame frame;

    public GameScreen(JFrame frame) {
        this.frame = frame;
    }

    /**
     * Tyhjentää peliruudun piirtoalustoista ja hiirenkuuntelijoista
     */
    public void clearFrame() {
        frame.getContentPane().removeAll();
        for (MouseListener m : frame.getMouseListeners()) {
            frame.removeMouseListener(m);
        }
        for (MouseMotionListener m : frame.getMouseMotionListeners()) {
            frame.removeMouseMotionListener(m);
        }
    }

    /**
     * Tekee päävalikon
     */
    public void buildMainMenu() {
        clearFrame();
        MainMenu menu = new MainMenu(frame, this);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Tekee pelin valmisteluruudun
     *
     * @param gameMode Pelimoodi
     */
    public void buildPreparation(int gameMode) {
        clearFrame();
        GamePreparation gamePrep = new GamePreparation(gameMode, frame, this);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Tekee tappeluyksinpeli
     *
     * @param p Pelaaja
     * @param o Vastustaja
     */
    void buildBattleSinglePlayerGame(Player p, Opponent o) {
        clearFrame();
        SinglePlayerGame battleSinglePlayerGame = new SinglePlayerGame(18, frame, this, p, o);
        frame.revalidate();
        frame.repaint();
    }

    void buildInstructionScreen() {
        clearFrame();
        Instructions ins = new Instructions(frame, this);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Sulkee ikkunan, mikä sammuttaa pelin
     */
    public void closeScreen() {
        frame.dispose();
    }

}
