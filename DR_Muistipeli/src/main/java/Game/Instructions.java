package Game;

import Graphics.DrawingBoardInstructions;
import Controller.InstructionsHighlightController;
import UserInterface.MouseListener.MouseListenerInstructions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Sisältää ohjeet
 */
public class Instructions {

    private JFrame frame;
    private DrawingBoardInstructions dbi;
    private GameScreen gameScreen;
    private MouseListenerInstructions mouseListener;
    private InstructionsHighlightController hController;
    private final int refreshRate;

    /**
     * Konstruktori
     *
     * @param frame frame mihin ohjeet lisataan
     * @param gs GameScreen olio mita kasketaan tekemaan toimintoja
     * @param refreshRate kuinka usein yksi kuva nakyy ruudulla
     */
    public Instructions(JFrame frame, GameScreen gs, int refreshRate) {
        this.frame = frame;
        this.dbi = new DrawingBoardInstructions(this);
        this.gameScreen = gs;
        this.mouseListener = new MouseListenerInstructions(this);
        this.hController = new InstructionsHighlightController();
        this.refreshRate = refreshRate;

        this.dbi.addMouseListener(this.mouseListener);
        this.dbi.addMouseMotionListener(this.mouseListener);
        this.frame.add(dbi);
        Timer t = repainter(dbi, refreshRate);
        t.setRepeats(true);
        t.start();
    }

    /**
     * Palauttaa korostus-kontrollerin
     *
     * @return kontrolleri
     */
    public InstructionsHighlightController getHController() {
        return hController;
    }

    /**
     * Kaskee GameScreen-luokkaa rakentamaan valikkoruudun
     */
    public void backToMenu() {
        gameScreen.buildMainMenu();
    }

    private final Timer repainter(final DrawingBoardInstructions d, int refreshRate) {
        Timer timer = new Timer(refreshRate, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                d.repaint();
            }

        });
        return timer;
    }
}
