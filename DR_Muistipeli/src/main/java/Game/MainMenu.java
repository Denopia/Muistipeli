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
    private boolean mouseOnSPG;
    private boolean mouseOnTPG;
    private boolean mouseOnExit;

    public MainMenu(JFrame frame, GameScreen gs) {
        this.frame = frame;
        this.gameScreen = gs;
        this.dbm = new DrawingBoardMenu();
        this.mouseListener = new MouseMovementListenerMainMenu(this);
        this.frame.addMouseListener(mouseListener);
        this.frame.addMouseMotionListener(mouseListener);
        this.frame.add(dbm);
        this.mouseOnIns = false;
        this.mouseOnSPG = false;
        this.mouseOnTPG = false;
        this.mouseOnExit = false;
    }

    public void highlightSPG() {
        if (!mouseOnSPG) {
            mouseOnExit = false;
            mouseOnIns = false;
            mouseOnTPG = false;
            mouseOnSPG = true;
            dbm.setImage(1);
            refresh();
        }
    }

    public void highlightIns() {
        if (!mouseOnIns) {
            mouseOnExit = false;
            mouseOnIns = true;
            mouseOnTPG = false;
            mouseOnSPG = false;
            dbm.setImage(2);
            refresh();
        }
    }

    public void highlightExit() {
        if (!mouseOnExit) {
            mouseOnExit = true;
            mouseOnIns = false;
            mouseOnTPG = false;
            mouseOnSPG = false;
            dbm.setImage(3);
            refresh();
        }
    }

    public void unHighlightAll() {
        mouseOnExit = false;
        mouseOnIns = false;
        mouseOnSPG = false;
        mouseOnTPG = false;
        dbm.setImage(0);
        refresh();
    }

    public void startSinglePlayerGame() {
        gameScreen.buildSinglePlayerGame();
    }
    
    public void showInstructions(){
        System.out.println("Näytä ohjeet!");
    }

    public void closeGame() {
        gameScreen.closeScreen();
    }

    public void refresh() {
        this.dbm.repaint();
    }

}
