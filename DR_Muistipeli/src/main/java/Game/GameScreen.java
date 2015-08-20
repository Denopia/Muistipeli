package Game;

import Game.GameModes.NormalSinglePlayerGame;
import Game.GameModes.BattleSinglePlayerGame;
import Game.GameModes.BattleMultiPlayerGame;
import Player.AIOpponent.AIBattleOpponent;
import Player.Human.BattlePlayer;
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
    private MainMenu mainMenu;
    private NormalSinglePlayerGame normalSinglePlayerGame;
    private BattleSinglePlayerGame battleSinglePlayerGame;
    private BattleMultiPlayerGame twoPlayerGame;
    private GamePreparation gamePrep;

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
     * Tekee päävalikon ja laittaa sen ruutuun
     */
    public void buildMainMenu() {
        clearFrame();
        this.mainMenu = new MainMenu(this.frame, this);
        this.frame.revalidate();
        this.frame.repaint();
    }

    /**
     * Tekee pelin valmisteluruudun ja laittaa sen ruutuun
     *
     * @param gameMode Pelimoodi
     */
    public void buildPreparation(int gameMode) {
        clearFrame();
        this.gamePrep = new GamePreparation(gameMode, this.frame, this);
        this.frame.revalidate();
        this.frame.repaint();
    }

    /**
     * Tekee normaalin yksinpeli ja laittaa sen ruutuun Vaati muokkausta
     * samanlaiseksi kuin alempi metodi!
     *
     * @param d Haluttu vaikeustaso
     * @param p Haluttu pelaajan pelihahmo
     * @param o Haluttu vastustajan pelihahmo
     */
    public void buildNormalSinglePlayerGame(int d, int p, int o) {
        clearFrame();
        this.normalSinglePlayerGame = new NormalSinglePlayerGame(18, this.frame, this, d, p, o);
        this.frame.revalidate();
        this.frame.repaint();
    }

    /**
     * Tekee tappeluyksinpeli ja laittaa sen ruutuun
     *
     * @param p Pelaaja
     * @param o Vastustaja
     */
    void buildBattleSinglePlayerGame(BattlePlayer p, AIBattleOpponent o) {
        clearFrame();
        this.battleSinglePlayerGame = new BattleSinglePlayerGame(18, this.frame, this, p, o);
        this.frame.revalidate();
        this.frame.repaint();
    }

    /**
     * Tekee kaksinpeli ja laittaa sen ruutuun Mutta ei oikeesti tee vielä
     * mitään
     */
    public void buildTwoPlayerGame() {
        this.twoPlayerGame = new BattleMultiPlayerGame();
    }

    /**
     * Sulkee ikkunan eli samalla sammuttaa pelin
     */
    public void closeScreen() {
        this.frame.dispose();
    }

}
