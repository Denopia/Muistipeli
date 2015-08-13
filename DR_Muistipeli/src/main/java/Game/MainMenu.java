package Game;

import Graphics.DrawingBoardMenu;
import UserInterface.MouseMovementListenerMainMenu;
import javax.swing.JFrame;

public class MainMenu {

    private JFrame frame;
    private DrawingBoardMenu dbm;
    private GameScreen gameScreen;
    private MouseMovementListenerMainMenu mouseListener;
    private boolean mouseOnIns;
    private boolean mouseOnNSPG;
    private boolean mouseOnNMPG;
    private boolean mouseOnBSPG;
    private boolean mouseOnBMPG;
    private boolean mouseOnExit;

    public MainMenu(JFrame frame, GameScreen gs) {
        this.frame = frame;
        this.gameScreen = gs;
        this.dbm = new DrawingBoardMenu();
        this.mouseListener = new MouseMovementListenerMainMenu(this);
        this.frame.addMouseListener(mouseListener);
        this.frame.addMouseMotionListener(mouseListener);
        this.frame.add(dbm);
        unHighlightAll();
    }

    public void highlightNSPG() {
        if (!mouseOnNSPG) {
            unHighlightAll();
            mouseOnNSPG = true;
            refresh(1);
        }
    }
    
    public void highlightNMPG() {
        if (!mouseOnNMPG) {
            unHighlightAll();
            mouseOnNMPG = true;
            refresh(2);
        }
    }
    
    public void highlightBSPG() {
        if (!mouseOnBSPG) {
            unHighlightAll();
            mouseOnBSPG = true;
            refresh(3);
        }
    }
    
    public void highlightBMPG() {
        if (!mouseOnBMPG) {
            unHighlightAll();
            mouseOnBMPG = true;
            refresh(4);
        }
    }

    public void highlightIns() {
        if (!mouseOnIns) {
            unHighlightAll();
            mouseOnIns = true;
            refresh(5);
        }
    }

    public void highlightExit() {
        if (!mouseOnExit) {
            unHighlightAll();
            mouseOnExit = true;
            refresh(6);
        }
    }

    public void unHighlightAll() {
        mouseOnExit = false;
        mouseOnIns = false;
        mouseOnNSPG = false;
        mouseOnNMPG = false;
        mouseOnBSPG = false;
        mouseOnBMPG = false;
    }

    public void unHighlightAllAndDraw() {
        unHighlightAll();
        refresh(0);
    }

    public void startNormalSinglePlayerGame() {
        gameScreen.buildSinglePlayerGame();
    }

    public void showInstructions() {
        System.out.println("Näytä ohjeet!");
    }

    public void closeGame() {
        gameScreen.closeScreen();
    }

    public void refresh(int state) {
        dbm.setImage(state);
        this.dbm.repaint();
    }

}
