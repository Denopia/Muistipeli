package Game.GameModes;

import TileController.TileController;
import Game.GameScreen;
import Graphics.DrawingBoardSinglePlayerGame;
import Player.Computer.Opponent;
import Player.Human.Player;
import Tile.Tile;
import UserInterface.MouseListener.MouseListenerSinglePlayerGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Tappeluyksinpeli. TietÃƒÆ’Ã‚Â¤ÃƒÆ’Ã‚Â¤ hiiren sijainnin nappuloiden
 * pÃƒÆ’Ã‚Â¤ÃƒÆ’Ã‚Â¤llÃƒÆ’Ã‚Â¤. Suorittaa pelin toimintoja kun hiirellÃƒÆ’Ã‚Â¤
 * klikkaa nappeja ja pelilaattoja. TietÃƒÆ’Ã‚Â¤ÃƒÆ’Ã‚Â¤ myÃƒÆ’Ã‚Â¶s pelaajat.
 *
 */
public class SinglePlayerGame {

    private GameScreen gameScreen;
    private JFrame frame;
    private DrawingBoardSinglePlayerGame dbbs;
    private TileController tc;
    private MouseListenerSinglePlayerGame mouseListener;
    private Player player;
    private Opponent opponent;
    private boolean playersTurn;

    private boolean horRow1;
    private boolean horRow2;
    private boolean horRow3;
    private boolean horRow4;
    private boolean horRow5;
    private boolean horRow6;

    private int pairs;
    private boolean mouseOnHit;
    private boolean mouseOnSkill1;

    public SinglePlayerGame(int pairs, JFrame frame, GameScreen gs, Player bp, Opponent bo) {
        this.mouseOnSkill1 = false;
        this.mouseOnHit = false;
        this.pairs = pairs;
        this.player = bp;
        this.opponent = bo;
        this.opponent.setGame(this);
        this.playersTurn = true;
        this.frame = frame;
        this.gameScreen = gs;
        this.tc = new TileController(pairs);
        this.tc.shuffleTiles();
        this.dbbs = new DrawingBoardSinglePlayerGame(this);
        this.mouseListener = new MouseListenerSinglePlayerGame(this);
        this.frame.add(dbbs);
        this.frame.addMouseListener(mouseListener);
        this.frame.addMouseMotionListener(mouseListener);
        dbbs.repaint();
    }

    /**
     * Asettaa kaikki rivit pois korostuksesta
     * Tähän hommaan tarvitaan joku erillinen luokka
     */
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
            player.useSkill1(tc, row, opponent);
            pairTiles();
        }
    }

    public ArrayList<Tile> getTiles() {
        return tc.getTiles();
    }

    public TileController getController() {
        return tc;
    }

    public Player getPlayer() {
        return player;
    }

    public Opponent getOpponent() {
        return opponent;
    }

    public boolean isPlayersTurn() {
        return playersTurn;
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
            timer = new Timer(1500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    endTurnCheck();
                    if (!playersTurn) {
                        opponent.spendTurn();
                    }
                }

            });
        } else {
            timer = new Timer(1500, new ActionListener() {
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
        tc.cleanTiles();
        player.setNeutral();
        opponent.setNeutral();    
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
    
    public boolean getHitH() {
        return mouseOnHit;
    }

    public boolean getSkill1H() {

        return mouseOnSkill1;
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

    public void backToMenu() {
        this.gameScreen.buildMainMenu();
    }
}
