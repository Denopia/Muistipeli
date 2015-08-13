package Game.GameModes;

import Controller.NormalTileController;
import Game.GameScreen;
import Tile.NormalTile;
import Graphics.DrawingBoardNormalSingle;
import Player.AIOpponent.AINormalOpponent;
import Player.Human.NormalPlayer;
import UserInterface.MouseMovementListenerNormalSinglePlayerGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

public class NormalSinglePlayerGame {

    private GameScreen gameScreen;
    private JFrame frame;
    private DrawingBoardNormalSingle dbbg;
    private NormalTileController tc;
    private MouseMovementListenerNormalSinglePlayerGame mouseListener;
    private NormalPlayer player;
    private AINormalOpponent opponent;
    private boolean playersTurn;

    public NormalSinglePlayerGame(int pairs, JFrame frame, GameScreen gs) {
        this.player = new NormalPlayer();
        this.opponent = new AINormalOpponent(this);
        playersTurn = true;
        this.frame = frame;
        this.gameScreen = gs;
        this.tc = new NormalTileController(pairs);
        this.tc.shuffleTiles();
        this.dbbg = new DrawingBoardNormalSingle(this.tc.getTiles(), player, opponent);
        this.mouseListener = new MouseMovementListenerNormalSinglePlayerGame(this);
        this.frame.add(dbbg);
        this.frame.addMouseListener(mouseListener);
        this.frame.addMouseMotionListener(mouseListener);
        dbbg.repaint();
    }

    public ArrayList<NormalTile> getTiles() {
        return tc.getTiles();
    }

    public NormalTileController getController() {
        return tc;
    }

    public boolean isPlayersTurn() {
        return playersTurn;
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
                    changeTurn();
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

    public void changeTurn() {
        playersTurn = !playersTurn;
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
