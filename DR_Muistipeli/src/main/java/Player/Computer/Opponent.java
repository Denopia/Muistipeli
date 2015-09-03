package Player.Computer;

import Game.GameModes.SinglePlayerGame;
import GameCharacter.GameCharacter;

/**
 * Yksinpelin vastustaja. Hallinoi vastustajan vuoroja ja tuntemia laattoja
 * erillisten olioiden kautta.
 */
public class Opponent {

    private SinglePlayerGame game;
    private OpponentTileController tiles;
    private OpponentTurnController turn;
    private boolean neutralState;
    private GameCharacter gc;
    private int difficulty;
    private int movesLeft;
    private int hitsLeft;

    /**
     * Konstruktori
     */
    public Opponent() {
        setNeutralStateTrue();
        movesLeft = 0;
        hitsLeft = 0;
        tiles = new OpponentTileController();
        turn = new OpponentTurnController(this);
    }

    /**
     * Lisaa vuoron
     */
    public void addMove() {
        movesLeft++;
    }

    /**
     * Poistaa vuoron
     */
    public void removeMove() {
        movesLeft--;
    }

    /**
     * Palauttaa vuorot
     *
     * @return vuorot
     */
    public int getMoves() {
        return movesLeft;
    }

    /**
     * Poistaa lyonnin
     */
    public void removeHit() {
        hitsLeft--;
    }

    /**
     * Lisaa lyonnin
     */
    public void addHit() {
        hitsLeft++;
    }

    /**
     * Asettaa lyonnit yhteen
     */
    public void setHitsToOne() {
        hitsLeft = 1;
    }

    /**
     * Palauttaa lyonnit
     *
     * @return lyonnit
     */
    public int getHitsLeft() {
        return hitsLeft;
    }

    /**
     * Palauttaa vastustajan laattakontrollerin
     *
     * @return kontrolleri
     */
    public OpponentTileController getTileController() {
        return tiles;
    }

    /**
     * Asettaa vastustajalle pelin
     *
     * @param game peli
     */
    public void setGame(SinglePlayerGame game) {
        this.game = game;
    }

    /**
     * Palauttaa pelin jossa vastustaja on osana
     *
     * @return peli
     */
    public SinglePlayerGame getGame() {
        return game;
    }

    /**
     * Asettaa vaikeustason
     *
     * @param i vaikeustaso
     */
    public void setDifficulty(int i) {
        difficulty = i;
    }

    /**
     * Palauttaa vaikeustason
     *
     * @return vaikeustaso
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Asettaa vastustajalle hahmon
     *
     * @param gc hahmo
     */
    public void setCharacter(GameCharacter gc) {
        this.gc = gc;
    }

    /**
     * Palauttaa vastustajan hahmon
     *
     * @return hahmo
     */
    public GameCharacter getCharacter() {
        return gc;
    }

    /**
     * Kayttaa vuoron
     */
    public void spendTurn() {
        turn.spendTurn();
    }

    /**
     * Aasettaa vuorot yhteen
     */
    public void setMovesToOne() {
        movesLeft = 1;
    }

    /**
     * Asettaa vastustajan neutraliin tilaan
     */
    public final void setNeutralStateTrue() {
        neutralState = true;
    }

    /**
     * Poistaa vastustajan neutraalista tilasta
     */
    public void setNeutralStateFalse() {
        neutralState = false;
    }

    /**
     * Palauttaa neutraalin tilan totuusarvon
     *
     * @return true jos on neutraali, false jos ei
     */
    public boolean getNeutralState() {
        return neutralState;
    }
}
