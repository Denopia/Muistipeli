package Game;

import Graphics.DrawingBoardMenu;
import UserInterface.MouseListener.MouseListenerMainMenu;
import javax.swing.JFrame;

/**
 * Pelin päävalikko. Tietää missä hiiri sijaitsee ja käynnistää pelin
 * valmistelun kun haluttua pelimoodia klikataan. Antaa myös mahdollisuuden
 * katsoa ohjeet. Rakentaa näkymät GameScreenin kautta.
 *
 */
public class MainMenu {

    private JFrame frame;
    private DrawingBoardMenu dbm;
    private GameScreen gameScreen;
    private MouseListenerMainMenu mouseListener;
    private boolean mouseOnSPG;
    private boolean mouseOnIns;
    private boolean mouseOnExit;

    public MainMenu(JFrame frame, GameScreen gs) {
        
        this.frame = frame;
        this.gameScreen = gs;
        this.dbm = new DrawingBoardMenu(this);
        this.mouseListener = new MouseListenerMainMenu(this);
        this.frame.addMouseListener(mouseListener);
        this.frame.addMouseMotionListener(mouseListener);
        this.frame.add(dbm);
        unHighlightAll();
    }

    public void highlightSPG() {
        if (!mouseOnSPG) {
            unHighlightAll();
            mouseOnSPG = true;
            refresh();
        }
    }

    public void highlightIns() {
        if (!mouseOnIns) {
            unHighlightAll();
            mouseOnIns = true;
            refresh();
        }
    }

    public void highlightExit() {
        if (!mouseOnExit) {
            unHighlightAll();
            mouseOnExit = true;
            refresh();
        }
    }

    public boolean getIns() {
        return mouseOnIns;
    }

    public boolean getExit() {
        return mouseOnExit;
    }

    public boolean getSPG() {
        return mouseOnSPG;
    }

    public final void unHighlightAll() {
        mouseOnExit = false;
        mouseOnIns = false;
        mouseOnSPG = false;
    }

    public void unHighlightAllAndDraw() {
        unHighlightAll();
        refresh();
    }

    public void showInstructions() {
        System.out.println("Näytä ohjeet!");
    }

    public void closeGame() {
        gameScreen.closeScreen();
    }

    public void refresh() {
        dbm.repaint();
    }

    public void startPreparationScreen(int i) {
        gameScreen.buildPreparation(i);
    }

}
