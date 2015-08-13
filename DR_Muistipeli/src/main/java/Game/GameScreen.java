package Game;

import Game.GameModes.NormalSinglePlayerGame;
import Game.GameModes.BattleSinglePlayerGame;
import Game.GameModes.BattleMultiPlayerGame;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class GameScreen {

    private final JFrame frame;
    private MainMenu mainMenu;
    private NormalSinglePlayerGame normalSinglePlayerGame;
    private BattleSinglePlayerGame battleSinglePlayerGame;
    private BattleMultiPlayerGame twoPlayerGame;

    public GameScreen(JFrame frame) {
        this.frame = frame;
    }

    public void clearFrame() {
        this.frame.getContentPane().removeAll();
        for (MouseListener m : frame.getMouseListeners()) {
            frame.removeMouseListener(m);
        }
        for (MouseMotionListener m : frame.getMouseMotionListeners()) {
            frame.removeMouseMotionListener(m);
        }
    }

    public void buildMainMenu() {
        clearFrame();
        this.mainMenu = new MainMenu(this.frame, this);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void buildNormalSinglePlayerGame() {
        clearFrame();
        this.normalSinglePlayerGame = new NormalSinglePlayerGame(18, this.frame, this);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void buildTwoPlayerGame() {
        this.twoPlayerGame = new BattleMultiPlayerGame();
    }

    public void closeScreen() {
        this.frame.dispose();
    }

    void buildBattleSinglePlayerGame() {
        clearFrame();
        this.battleSinglePlayerGame = new BattleSinglePlayerGame(18, this.frame, this);
        this.frame.revalidate();
        this.frame.repaint();
    }

}
