package Game.GameModes;

import TileController.BattleTileController;
import Game.GameScreen;
import Graphics.DrawingBoardBattleSingle;
import Player.AIOpponent.AIBattleOpponent;
import Player.Human.BattlePlayer;
import Tile.BattleTile;
import UserInterface.MouseListener.MouseMovementListenerBattleSinglePlayerGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Tappeluyksinpeli. TietÃƒÂ¤ÃƒÂ¤ hiiren sijainnin nappuloiden pÃƒÂ¤ÃƒÂ¤llÃƒÂ¤.
 * Suorittaa pelin toimintoja kun hiirellÃƒÂ¤ klikkaa nappeja ja pelilaattoja.
 * TietÃƒÂ¤ÃƒÂ¤ myÃƒÂ¶s pelaajat.
 *
 */
public class BattleSinglePlayerGame {

    private GameScreen gameScreen;
    private JFrame frame;
    private DrawingBoardBattleSingle dbbs;
    private BattleTileController tc;
    private MouseMovementListenerBattleSinglePlayerGame mouseListener;
    private BattlePlayer player;
    private AIBattleOpponent opponent;
    private boolean playersTurn;

    private boolean horRow1;
    private boolean horRow2;
    private boolean horRow3;
    private boolean horRow4;
    private boolean horRow5;
    private boolean horRow6;

    private ArrayList<Boolean> horizontalRows;

    private int pairs;
    private boolean mouseOnHit;
    private boolean mouseOnSkill1;

    public BattleSinglePlayerGame(int pairs, JFrame frame, GameScreen gs, BattlePlayer bp, AIBattleOpponent bo) {
        mouseOnSkill1 = false;
        mouseOnHit = false;
        this.pairs = pairs;
        this.player = bp;
        this.opponent = bo;
        this.opponent.setGame(this);
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

    public void setHorRowsFalse() {
        horRow1 = false;
        horRow2 = false;
        horRow3 = false;
        horRow4 = false;
        horRow5 = false;
        horRow6 = false;
    }

    public void setHorRowTrue(int i) {
        setHorRowsFalse();
        if (i == 1) {
            horRow1 = true;
        } else if (i == 2) {
            horRow2 = true;
        } else if (i == 3) {
            horRow3 = true;
        } else if (i == 4) {
            horRow4 = true;
        } else if (i == 5) {
            horRow5 = true;
        } else if (i == 6) {
            horRow6 = true;
        }
    }

    public int getHorRow() {
        if (horRow1 == true) {
            return 1;
        } else if (horRow2 == true) {
            return 2;
        } else if (horRow3 == true) {
            return 3;
        } else if (horRow4 == true) {
            return 4;
        } else if (horRow5 == true) {
            return 5;
        } else if (horRow6 == true) {
            return 6;
        } else {
            return -1;
        }
    }

    public void playerUseSkill1(int row) {
        if (player.getCharacter().getEnergy() >= 5) {
            player.getCharacter().setEnergy(player.getCharacter().getEnergy() - 5);
            this.player.useSkill1(this.tc, row);
            pairTiles();
        }

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

    public AIBattleOpponent getOpponent() {
        return opponent;
    }

    public boolean isPlayersTurn() {
        return this.playersTurn;
    }

    public void passTurn() {
        if (playersTurn) {
            opponent.setHitThisTurnFalse();
        } else {
            player.setHitThisTurnFalse();
        }
        playersTurn = !playersTurn;
    }

    public void refresh() {
        dbbs.repaint();
    }

    public void pairTiles() {
        Timer timer;
        if (playersTurn) {
            boolean pair = tc.checkPairs(player);
            if (pair) {
                player.setHappy();
            } else {
                player.setUnhappy();
            }
            timer = turnEndTimer(pair);
        } else {
            boolean pair = tc.checkPairs(opponent);
            if (pair) {
                opponent.setHappy();
            } else {
                opponent.setUnhappy();
            }
            timer = turnEndTimer(pair);
        }
        timer.setRepeats(false);
        timer.start();
    }

    public Timer turnEndTimer(boolean pair) {
        Timer timer;
        if (pair) {
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    endTurnCheck();
                    if (!playersTurn) {
                        opponent.spendTurn();
                    }
                }

            });
        } else {
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    passTurn();
                    endTurnCheck();
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
        tc.cleanTiles(opponent);
        player.setNeutral();
        opponent.setNeutral();
        refresh();
        checkRefill();
        unHighlightAll();
        gameOver();
    }

    public void highlightHit() {
        mouseOnHit = true;
    }

    public void unHighlightHit() {
        mouseOnHit = false;
    }

    public void highlightSkill1() {
        mouseOnSkill1 = true;
    }

    public void unHighlightSkill1() {
        mouseOnSkill1 = false;
    }

    public void unHighlightAll() {
        unHighlightSkill1();
        unHighlightHit();
        setHorRowsFalse();
    }

    public void hitOpponent() {
        if (!player.getHitThisTurn()) {
            if (player.getCharacter().getEnergy() > 0) {
                player.getCharacter().setEnergy(player.getCharacter().getEnergy() - 1);
                opponent.getCharacter().setHp(opponent.getCharacter().getHp() - 1);
                opponent.setTakeDamage();
                player.setGiveDamage();
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        player.setNeutral();
                        opponent.setNeutral();
                        endTurnCheck();
                        refresh();
                    }
                });
                timer.setRepeats(false);
                timer.start();
                player.setHitThisTurnTrue();
            }
        }
    }

    public void hitPlayer() {
        if (!opponent.getHitThisTurn()) {
            if (opponent.getCharacter().getEnergy() > 0) {
                opponent.getCharacter().setEnergy(opponent.getCharacter().getEnergy() - 1);
                player.getCharacter().setHp(player.getCharacter().getHp() - 1);
                player.setTakeDamage();
                opponent.setGiveDamage();
                refresh();
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        opponent.setNeutral();
                        player.setNeutral();
                        endTurnCheck();
                        refresh();
                    }
                });
                timer.setRepeats(false);
                timer.start();
                opponent.setHitThisTurnTrue();
            }
        }
    }

    public boolean getHitH() {
        return mouseOnHit;
    }

    public boolean getSkill1H() {

        return mouseOnSkill1;
    }
}
