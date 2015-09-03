package Game;

import Game.GameModes.SinglePlayerGame;
import Player.Computer.Opponent;
import Player.Human.Player;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 * Kontrolloi pelin framea. Luo pelit ja valikon seka ohjeet ja antaa framen
 * niille kayttoon. Kun naita ei ena tarvita, tyhjenta framen ja rakentaa uuden
 * tarvittavan nakyman.
 *
 */
public class GameScreen {

    private final JFrame frame;
    private final int refreshRate;

    /**
     * Konstruktori
     *
     * @param frame frame johon tulee tavaraa
     * @param RefreshRate kuinka kauan yksi kuva nakyy ruudulla
     */
    public GameScreen(JFrame frame, int RefreshRate) {
        this.frame = frame;
        this.refreshRate = RefreshRate;
    }

    /**
     * Tyhjentaa peliruudun piirtoalustoista
     */
    public void clearFrame() {
        frame.getContentPane().removeAll();
    }

    /**
     * Tekee pavalikon
     */
    public void buildMainMenu() {
        clearFrame();
        MainMenu menu = new MainMenu(frame, this, refreshRate);
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
        GamePreparation gamePrep = new GamePreparation(gameMode, frame, this, refreshRate);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Tekee yksinpelin
     *
     * @param p Pelaaja
     * @param o Vastustaja
     */
    void buildBattleSinglePlayerGame(Player p, Opponent o) {
        clearFrame();
        SinglePlayerGame battleSinglePlayerGame = new SinglePlayerGame(18, frame, this, p, o, refreshRate);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Tekee ohjeruudun
     */
    void buildInstructionScreen() {
        clearFrame();
        Instructions ins = new Instructions(frame, this, refreshRate);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Sulkee ikkunan, mika myos sammuttaa pelin
     */
    public void closeScreen() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

}
