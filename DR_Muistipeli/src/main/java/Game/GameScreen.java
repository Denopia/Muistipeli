package Game;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class GameScreen {

    private final JFrame frame;
    private MainMenu mainMenu;
    private SinglePlayerGame singlePlayerGame;
    private TwoPlayerGame twoPlayerGame;

    public GameScreen(JFrame frame) {
        this.frame = frame;
    }
    
    public void clearFrame(){
        this.frame.getContentPane().removeAll();
        for(MouseListener m : frame.getMouseListeners()){
            frame.removeMouseListener(m);
        }
        for(MouseMotionListener m : frame.getMouseMotionListeners()){
            frame.removeMouseMotionListener(m);
        }
    }

    public void buildMainMenu() {
        clearFrame();
        this.mainMenu = new MainMenu(this.frame, this);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void buildSinglePlayerGame() {
        clearFrame();
        this.singlePlayerGame = new SinglePlayerGame(18, this.frame, this);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void buildTwoPlayerGame() {
        this.twoPlayerGame = new TwoPlayerGame();
    }
    
    public void closeScreen(){
        this.frame.dispose();
    }

}
