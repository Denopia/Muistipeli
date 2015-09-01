package Game;

import Graphics.DrawingBoardInstructions;
import Controller.InstructionsHighlightController;
import UserInterface.MouseListener.MouseListenerInstructions;
import javax.swing.JFrame;

/**
 * Sisältää ohjeet ja näyttää ne framessa
 *
 */
public class Instructions {

    private JFrame frame;
    private DrawingBoardInstructions dbi;
    private GameScreen gameScreen;
    private MouseListenerInstructions mouseListener;
    private InstructionsHighlightController hController;
    

    public Instructions(JFrame frame, GameScreen gs) {
        this.frame = frame;
        this.dbi = new DrawingBoardInstructions(this);
        this.gameScreen = gs;
        this.mouseListener = new MouseListenerInstructions(this);
        this.hController = new InstructionsHighlightController();

        this.frame.addMouseListener(this.mouseListener);
        this.frame.addMouseMotionListener(this.mouseListener);
        this.frame.add(dbi);
    }

    public InstructionsHighlightController getHController() {
        return hController;
    }
    
    public void refresh(){
        dbi.repaint();
    }
    
    public void backToMenu() {
        gameScreen.buildMainMenu();
    }

}
