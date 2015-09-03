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
 * Yksinpeli. Tietaa pelaajat ja laatat (niiden kontrollerin). Hallinoi siis
 * kuinka yksinpeli tulee toimimaan (kuten kuinka vuorot vaihtuvat).
 *
 */
public class SinglePlayerGame {

    private GameScreen gameScreen;
    private JFrame frame;
    private DrawingBoardSinglePlayerGame dbsp;
    private TileController tc;
    private MouseListenerSinglePlayerGame mouseListener;
    private Player player;
    private Opponent opponent;
    private boolean playersTurn;
    private int pairs;
    private SinglePlayerGameHighlightController hController;
    private SinglePlayerGameAttackController aController;
    private final int refreshRate;

    /**
     * Konstruktori. Asettaa muistiin tarvittavat oliot ja valmistelee framen
     * niin etta peli nakyy siina.
     *
     * @param pairs Kuinka monta paria peliin tulee
     * @param frame Pelin frame
     * @param gs GameScreen luokka
     * @param bp Pelaaja
     * @param bo Vastustaja
     * @param refreshRate Kuinak kauan yksi kuva nakyy ruudulla ennen kuin se
     * paivitetaan
     */
    public SinglePlayerGame(int pairs, JFrame frame, GameScreen gs, Player bp, Opponent bo, int refreshRate) {
        this.refreshRate = refreshRate;
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
        this.dbsp = new DrawingBoardSinglePlayerGame(this);
        this.mouseListener = new MouseListenerSinglePlayerGame(this);
        this.frame.add(dbsp);
        this.dbsp.addMouseListener(mouseListener);
        this.dbsp.addMouseMotionListener(mouseListener);
        player.addMove();
        player.addHit();
        Timer t = repainter(dbsp, refreshRate);
        t.setRepeats(true);
        t.start();
    }

    private Timer repainter(final DrawingBoardSinglePlayerGame d, int refreshRate) {
        Timer timer = new Timer(refreshRate, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                d.repaint();
            }

        });
        return timer;
    }

    /**
     * Palauttaa hyokkayskontrollerin
     *
     * @return Kontrolleri
     */
    public SinglePlayerGameAttackController getAController() {
        return aController;
    }

    /**
     * Palauttaa korostuskontrollerin
     *
     * @return Kontrolleri
     */
    public SinglePlayerGameHighlightController getHController() {
        return hController;
    }

    /**
     * Palauttaa laattakontrollerin
     *
     * @return Kontrolleri
     */
    public TileController getTController() {
        return tc;
    }

    /**
     * Palauttaa pelaajan
     *
     * @return Pelaaja
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Palauttaa vastustajan
     *
     * @return Vastustaja
     */
    public Opponent getOpponent() {
        return opponent;
    }

    /**
     * Palauttaa arvon joka kertoo onko pelaajan vuoro
     *
     * @return True jos on pelaajan vuoro, false jos ei
     */
    public boolean isPlayersTurn() {
        return playersTurn;
    }

    /**
     * Kaskee pelaajaa kayttamaan taidon
     */
    public void playerUseSkill() {
        if (player.getCharacter().useSkill(this)) {
            player.addMove();
            pairTiles();
        }
    }

    /**
     * Vaihtaa vuorossa olevaa pelaajaa jos nykyisen pelaajan siirrot loppu
     */
    public void passTurn() {
        if (playersTurn) {
            player.removeMove();
            if (player.getMoves() < 1) {
                opponent.setHitsToOne();
                opponent.setMovesToOne();
                playersTurn = !playersTurn;
            }
        } else {
            opponent.removeMove();
            if (opponent.getMoves() < 1) {
                player.setHitsToOne();
                player.setMovesToOne();
                playersTurn = !playersTurn;
            }
        }
    }

    /**
     * Tarkastaa onko kaannetyissa laatoissa pareja, ja jos pari loytyy asettaa
     * oikeat kuvat ja tilat pelaajille ja luo timerit jotka lopettavat vuoron
     */
    public void pairTiles() {
        if (playersTurn) {
            boolean pair = tc.checkPairsForPlayer(this);
            if (!pair) {
                player.getCharacter().setUnhappy();
                player.setNeutralStateFalse();
            }
        } else {
            boolean pair = tc.checkPairsForOpponent(this);
            if (!pair) {
                opponent.getCharacter().setUnhappy();
                opponent.setNeutralStateFalse();
            }
        }
        passTurn();
        Timer timer = turnEndTimer();
        timer.setRepeats(false);
        timer.start();

    }

    /**
     * Palauttaa timerin joka tietyn ajan kuluttua vaihtaa vuoron seuraavalle
     * pelaajalle vuoron lopussa suoritettavan tarkastuksen jalkeen
     *
     * @return Timer
     */
    public Timer turnEndTimer() {
        Timer timer;
        timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                endTurnCheck();
                if (!playersTurn) {
                    opponent.spendTurn();
                }
            }
        });
        return timer;
    }

    /**
     * Tarkistaa onko pelin syyta loppua toisen pelaajan voittoon
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
    }

    /**
     * Suorittaa vuoron lopussa puhdistuksen. Laattakontrolleri siistii
     * laattalista, pelaajat asetetaan neutraaliin tilaan, tarkastetaan
     * joudutaanko luomaan uudet laatat, poistetaan korostus kaikista
     * elementeista, ja tarkastetaan loppuuko peli
     */
    public void endTurnCheck() {
        gameOver();
        tc.unTurnUnpairedTiles();
        player.setNeutralStateTrue();
        player.getCharacter().setNeutral();
        opponent.getCharacter().setNeutral();
        opponent.setNeutralStateTrue();
        checkRefill();
        hController.unHighlightAll();
    }

    /**
     * Lopttaa pelin ja kaskee peliruutua rakentamaan paavalikon
     */
    public void backToMenu() {
        gameScreen.buildMainMenu();
    }

    /**
     * Asettaa pelaajille oikeat kuvat laattojen efektien mukaan
     *
     * @param effect Laatan efekti
     */
    public void setCharacterPictures(String effect) {
        if (playersTurn) {
            setPlayerPicture(effect);
        } else {
            setOpponentPicture(effect);
        }
    }

    /**
     * Asettaa vastustajalle oikean kuvan laatan efektin mukaan
     *
     * @param effect Laatan efekti
     */
    public void setOpponentPicture(String effect) {
        if (effect.equals(tc.getEffects()[0]) || effect.equals(tc.getEffects()[1])
                || effect.equals(tc.getEffects()[3]) || effect.equals(tc.getEffects()[5])
                || effect.equals(tc.getEffects()[6]) || effect.equals(tc.getEffects()[8])) {
            opponent.getCharacter().setHappy();
            opponent.setNeutralStateFalse();
        } else if (effect.equals(tc.getEffects()[2]) || effect.equals(tc.getEffects()[7])) {
            opponent.getCharacter().setGiveDamage();
            opponent.setNeutralStateFalse();
            player.getCharacter().setTakeDamage();
            player.setNeutralStateFalse();
        } else if (effect.equals(tc.getEffects()[4])) {
            opponent.getCharacter().setTakeDamage();
            opponent.setNeutralStateFalse();
        }
    }

    /**
     * Asettaa pelaajalle oikean kuvan laatan efektin mukaan
     *
     * @param effect Laatan efekti
     */
    public void setPlayerPicture(String effect) {
        if (effect.equals(tc.getEffects()[0]) || effect.equals(tc.getEffects()[1])
                || effect.equals(tc.getEffects()[3]) || effect.equals(tc.getEffects()[5])
                || effect.equals(tc.getEffects()[6]) || effect.equals(tc.getEffects()[8])) {
            player.getCharacter().setHappy();
            player.setNeutralStateFalse();
        } else if (effect.equals(tc.getEffects()[2]) || effect.equals(tc.getEffects()[7])) {
            player.getCharacter().setGiveDamage();
            player.setNeutralStateFalse();
            opponent.getCharacter().setTakeDamage();
            opponent.setNeutralStateFalse();
        } else if (effect.equals(tc.getEffects()[4])) {
            player.getCharacter().setTakeDamage();
            player.setNeutralStateFalse();
        }
    }
}
