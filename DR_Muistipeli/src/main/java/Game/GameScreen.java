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
        this.frame.getContentPane().removeAll();
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
        MainMenu menu = new MainMenu(this.frame, this);
        this.frame.revalidate();
        this.frame.repaint();
    }

    /**
     * Tekee pelin valmisteluruudun
     *
     * @param gameMode Pelimoodi
     */
    public void buildPreparation(int gameMode) {
        clearFrame();
        GamePreparation gamePrep = new GamePreparation(gameMode, this.frame, this);
        this.frame.revalidate();
        this.frame.repaint();
    }


    /**
     * Tekee tappeluyksinpeli
     *
     * @param p Pelaaja
     * @param o Vastustaja
     */
    void buildBattleSinglePlayerGame(Player p, Opponent o) {
        clearFrame();
        SinglePlayerGame battleSinglePlayerGame = new SinglePlayerGame(18, this.frame, this, p, o);
        this.frame.revalidate();
        this.frame.repaint();
    }

    /**
     * Sulkee ikkunan, mikä sammuttaa pelin
     */
    public void closeScreen() {
        this.frame.dispose();
    }

}
