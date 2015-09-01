package Game.GameModes;

import Controller.TileController;
import Game.GameScreen;
import Graphics.DrawingBoardSinglePlayerGame;
import Controller.SinglePlayerGameAttackController;
import Controller.SinglePlayerGameHighlightController;
import Player.Computer.Opponent;
import Player.Human.Player;
import UserInterface.MouseListener.MouseListenerSinglePlayerGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Yksinpeli. TietÃƒÆ’Ã‚Â¤ÃƒÆ’Ã‚Â¤ hiiren sijainnin nappuloiden
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
    private int pairs;
    private SinglePlayerGameHighlightController hController;
    private SinglePlayerGameAttackController aController;

    public SinglePlayerGame(int pairs, JFrame frame, GameScreen gs, Player bp, Opponent bo) {
        this.aController = new SinglePlayerGameAttackController(this);
        this.hController = new SinglePlayerGameHighlightController();
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
        player.addTurn();
    }

    public SinglePlayerGameAttackController getAController() {
        return aController;
    }

    public SinglePlayerGameHighlightController getHController() {
        return hController;
    }

    public TileController getTController() {
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

    /**
     * Kaskee pelaajaa kayttamaan taidon
     */
    public void playerUseSkill() {
        if (player.useSkill(this)) {
            player.addTurn();
            pairTiles();
        }
    }

    /**
     * Vaihtaa vuorossa olevaa pelaajaa jos nykyisen pelaajan siirrot loppu
     */
    public void passTurn() {
        if (playersTurn) {
            player.removeTurn();
            if (player.getTurns() < 1) {
                opponent.setHitThisTurnFalse();
                opponent.addTurn();
                playersTurn = !playersTurn;
            }
        } else {
            opponent.removeTurn();
            if (opponent.getTurns() < 1) {
                player.setHitThisTurnFalse();
                player.addTurn();
                playersTurn = !playersTurn;
            }
        }
    }

    public void pairTiles() {
        Timer timer;
        if (playersTurn) {
            boolean pair = tc.checkPairsForPlayer(this);
            if (!pair) {
                player.setUnhappy();
            }
            timer = turnEndTimer(pair);
        } else {
            boolean pair = tc.checkPairsForOpponent(this);
            if (!pair) {
                opponent.setUnhappy();
            }
            timer = turnEndTimer(pair);
        }
        timer.setRepeats(false);
        timer.start();
        passTurn();
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
                    endTurnCheck();
                    if (!playersTurn) {
                        opponent.spendTurn();
                    }
                }
            });
        }
        return timer;
    }

    /**
     * Tarkistaa onko pelin syytä loppua toisen pelaajan voittoon
     */
    public void gameOver() {
        if (opponent.getCharacter().getHp() < 1 || player.getCharacter().getHp() < 1) {
            gameScreen.buildMainMenu();
        }
    }

    /**
     * Tarkistaa pitaako luoda kentalle uudet laatat
     */
    public void checkRefill() {
        if (tc.getTilesPaired() == tc.getTiles().size() / 2) {
            tc.newTiles();
            tc.shuffleTiles();
            opponent.getTileController().forgetAll();
        }
        refresh();
    }

    /**
     * Suorittaa vuoron lopussa puhdistuksen. Laattakontrolleri siistii
     * laattalista, pelaajat asetetaan neutraaliin tilaan, tarkastetaan
     * joudutaanko luomaan uudet laatat, poistetaan korostus kaikista
     * elementeista, ja tarkastetaan loppuuko peli
     */
    public void endTurnCheck() {
        tc.unTurnUnpairedTiles();
        player.setNeutral();
        opponent.setNeutral();
        checkRefill();
        hController.unHighlightAll();
        gameOver();
    }

    /**
     * Paivittaa piirtoalustan
     */
    public void refresh() {
        dbbs.repaint();
    }

    /**
     * Lopttaa pelin ja kaskee peliruutua rakentamaan paavalikon
     */
    public void backToMenu() {
        gameScreen.buildMainMenu();
    }
//"turn+1", "energy+1", "hit+1", "health+1", "skull", "turn+2", "energy+2", "hit+2", "health+2"

    public void setFaces(String effect) {
        if (playersTurn) {
            if (effect.equals(tc.getEffects()[0]) || effect.equals(tc.getEffects()[1])
                    || effect.equals(tc.getEffects()[3]) || effect.equals(tc.getEffects()[5])
                    || effect.equals(tc.getEffects()[6]) || effect.equals(tc.getEffects()[8])) {
                player.setHappy();
            } else if (effect.equals(tc.getEffects()[2]) || effect.equals(tc.getEffects()[7])) {
                player.setGiveDamage();
                opponent.setTakeDamage();
            } else if (effect.equals(tc.getEffects()[4])) {
                player.setTakeDamage();
            }
        } else {
            if (effect.equals(tc.getEffects()[0]) || effect.equals(tc.getEffects()[1])
                    || effect.equals(tc.getEffects()[3]) || effect.equals(tc.getEffects()[5])
                    || effect.equals(tc.getEffects()[6]) || effect.equals(tc.getEffects()[8])) {
                opponent.setHappy();
            } else if (effect.equals(tc.getEffects()[2]) || effect.equals(tc.getEffects()[7])) {
                opponent.setGiveDamage();
                player.setTakeDamage();
            } else if (effect.equals(tc.getEffects()[4])) {
                opponent.setTakeDamage();
            }
        }
    }

}
