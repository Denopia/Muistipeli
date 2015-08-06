package Game;

import Controller.TileController;
import Tile.Tile;
import Graphics.DrawingBoardBackground;
import UserInterface.MouseMovementListenerSinglePlayerGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SinglePlayerGame {

    private GameScreen gameScreen;
    private JFrame frame;
    private DrawingBoardBackground dbbg;
    private TileController tc;
    private MouseMovementListenerSinglePlayerGame mouseListener;

    public SinglePlayerGame(int pairs, JFrame frame, GameScreen gs) {
        this.frame = frame;
        this.gameScreen = gs;
        this.tc = new TileController(pairs);
        this.tc.shuffleTiles();
        this.dbbg = new DrawingBoardBackground(getTiles());
        this.mouseListener = new MouseMovementListenerSinglePlayerGame(this);
        this.frame.add(dbbg);
        this.frame.addMouseListener(mouseListener);
        this.frame.addMouseMotionListener(mouseListener);
        dbbg.repaint();
    }

    public ArrayList<Tile> getTiles() {
        return tc.getTiles();
    }

    public TileController getController() {
        return tc;
    }

    public void refresh() {
        dbbg.repaint();
        gameOver();
    }

    public void twoTilesTurned() {
        Timer timer;
        if (tc.checkPair()) {
            timer = new Timer(999, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    tc.pairTiles();
                    refresh();
                }
            });
        } else {
            timer = new Timer(999, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    tc.unTurnUnpairedTiles();
                    refresh();
                }
            });
        }
        timer.setRepeats(false);
        timer.start();
    }

    public void gameOver() {
        if (tc.pairedTiles() == 36) {
            gameScreen.buildMainMenu();
        }
    }
}
