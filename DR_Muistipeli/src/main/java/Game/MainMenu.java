package Game;

import Graphics.DrawingBoardMenu;
import Controller.MainMenuHighlightController;
import UserInterface.MouseListener.MouseListenerMainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Pelin paavalikko. Kaskee GameScreenia luomaan eri nakymia
 */
public class MainMenu {

    private JFrame frame;
    private DrawingBoardMenu dbm;
    private GameScreen gameScreen;
    private MouseListenerMainMenu mouseListener;
    private MainMenuHighlightController hController;
    private final int refreshRate;

    /**
     * Konstruktori
     *
     * @param frame frame johon valikko laitetaan
     * @param gs GameScreen olio
     * @param refreshRate kuinka kauan yksi kuva nakyy ruudulla ennen kuin
     * piirretaan uusi
     */
    public MainMenu(JFrame frame, GameScreen gs, int refreshRate) {
        this.frame = frame;
        this.dbm = new DrawingBoardMenu(this);
        this.gameScreen = gs;
        this.mouseListener = new MouseListenerMainMenu(this);
        this.hController = new MainMenuHighlightController();
        this.refreshRate = refreshRate;
        this.dbm.addMouseListener(mouseListener);
        this.dbm.addMouseMotionListener(mouseListener);
        this.frame.add(dbm);
        Timer t = repainter(dbm, refreshRate);
        t.setRepeats(true);
        t.start();
    }

    /**
     * Palauttaa korostus-kontrollerin
     *
     * @return kontroller
     */
    public MainMenuHighlightController getHController() {
        return hController;
    }

    private final Timer repainter(final DrawingBoardMenu d, int refreshRate) {
        Timer timer = new Timer(refreshRate, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                d.repaint();
            }

        });
        return timer;
    }

    /**
     * Kaskee peli-ikkunaa luomaan pelin valmisteluruudun
     *
     * @param i Pelimoodi
     */
    public void startPreparationScreen(int i) {
        gameScreen.buildPreparation(i);
    }

    /**
     * Kaskee peli-ikkunaa luomaan ohjeruudun
     */
    public void showInstructions() {
        gameScreen.buildInstructionScreen();
    }

    /**
     * Kaskee peli-ikkunaa sammuttamaan pelin
     */
    public void closeGame() {
        gameScreen.closeScreen();
    }

}
