package Game;

import Controller.BattleTileController;
import Graphics.DrawingBoardBattleSingle;
import Player.BattleOpponentAI;
import Player.BattlePlayer;
import Tile.BattleTile;
import UserInterface.MouseMovementListenerBattleSinglePlayerGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

public class BattleSinglePlayerGame {

    private GameScreen gameScreen;
    private JFrame frame;
    private DrawingBoardBattleSingle dbbs;
    private BattleTileController tc;
    private MouseMovementListenerBattleSinglePlayerGame mouseListener;
    private BattlePlayer player;
    private BattleOpponentAI opponent;
    private boolean playersTurn;
    private int pairs;
    private boolean mouseOnHit;

    public BattleSinglePlayerGame(int pairs, JFrame frame, GameScreen gs) {
        mouseOnHit = false;
        this.pairs = pairs;
        this.player = new BattlePlayer();
        this.opponent = new BattleOpponentAI(this);
        playersTurn = true;
        this.frame = frame;
        this.gameScreen = gs;
        this.tc = new BattleTileController(pairs);
        this.tc.shuffleTiles();
        this.dbbs = new DrawingBoardBattleSingle(this);
        this.mouseListener = new MouseMovementListenerBattleSinglePlayerGame(this);
        this.frame.add(dbbs);
        this.frame.addMouseListener(mouseListener);
        this.frame.addMouseMotionListener(mouseListener);
        dbbs.repaint();
    }

    public ArrayList<BattleTile> getTiles() {
        return tc.getTiles();
    }

    public BattleTileController getController() {
        return tc;
    }

    public BattlePlayer getPlayer() {
        return player;
    }

    public BattleOpponentAI getOpponent() {
        return opponent;
    }

    public boolean isPlayersTurn() {
        return this.playersTurn;
    }

    public void refresh() {
        dbbs.repaint();
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
                    endTurnCheck();
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
                    endTurnCheck();
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
        if (opponent.getCharacter().getHp() < 1 || player.getCharacter().getHp() < 1) {
            gameScreen.buildMainMenu();
        }
    }

    public void checkRefill() {
        if (tc.pairedTiles() == tc.getTiles().size() / 2) {
            this.tc.newTiles();
            this.tc.shuffleTiles();
            opponent.forgetAll();
        }
        refresh();
    }

    private void endTurnCheck() {
        checkRefill();
        gameOver();
    }

    public void highlightHit() {
        mouseOnHit = true;
    }

    public void unHighlightHit() {
        mouseOnHit = false;
    }

    public void hitOpponent() {
        if (player.getCharacter().getEnergy() >= 6) {
            player.getCharacter().setEnergy(player.getCharacter().getEnergy() - 6);
            opponent.getCharacter().setHp(opponent.getCharacter().getHp() - 6);
        }
        endTurnCheck();
        refresh();
    }

    public boolean getHitH() {
        return mouseOnHit;
    }
}
