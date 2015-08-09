package Game;

import Controller.TileController;
import Tile.Tile;
import Graphics.DrawingBoardBackground;
import Player.OpponentAI;
import Player.Player;
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
    private Player player;
    private OpponentAI opponent;
    private boolean playersTurn;

    public SinglePlayerGame(int pairs, JFrame frame, GameScreen gs) {
        this.player = new Player();
        this.opponent = new OpponentAI(this);
        playersTurn = true;
        this.frame = frame;
        this.gameScreen = gs;
        this.tc = new TileController(pairs);
        this.tc.shuffleTiles();
        this.dbbg = new DrawingBoardBackground(this.tc.getTiles(), player, opponent);
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

    public boolean isPlayersTurn() {
        return this.playersTurn;
    }

    public void refresh() {
        dbbg.repaint();
        gameOver();
    }

    public void twoTilesTurned() {
        boolean pairFlipped = tc.checkPair();
        Timer timer = turnEndTimer(pairFlipped);
        resolvePair(pairFlipped);
        timer.setRepeats(false);
        timer.start();
    }

    public Timer turnEndTimer(boolean pair) {
        Timer timer;
        if (pair) {
            timer = new Timer(999, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (playersTurn) {
                        tc.pairTiles(player);
                    } else {
                        tc.pairTiles(opponent);
                    }
                    player.setNeutral();
                    opponent.setNeutral();
                    refresh();
                    if (!playersTurn) {
                        opponent.spendTurn();
                    }
                }
            });
        } else {
            timer = new Timer(999, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    playersTurn = !playersTurn;
                    opponent.addSeenTile(tc.getFlippedTiles().get(0));
                    opponent.addSeenTile(tc.getFlippedTiles().get(1));
                    tc.unTurnUnpairedTiles();
                    player.setNeutral();
                    opponent.setNeutral();
                    refresh();
                    if (!playersTurn) {
                        opponent.spendTurn();
                    }
                }
            });
        }
        return timer;
    }

    public void resolvePair(Boolean pair) {
        if (playersTurn) {
            if (pair) {
                player.scorePair();
                opponent.commentOnPlayersPair();
            } else {
                player.failPair();
            }
        } else {
            if (pair) {
                opponent.scorePair();
            } else {
                opponent.failPair();
            }
        }
    }

    public void gameOver() {
        if (tc.pairedTiles() == 36) {
            gameScreen.buildMainMenu();
        }
    }
}
