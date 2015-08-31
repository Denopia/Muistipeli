package Player.Computer;

import Game.GameModes.SinglePlayerGame;
import GameCharacter.GameCharacter;
import Tile.Tile;
import java.awt.Image;

/**
 * Yksinpelin vastustaja. PitÃ¤Ã¤ sisÃ¤llÃ¤Ã¤n tietokonevastuksen tiedot ja
 * suorittaa vastuksen vuoron.
 *
 * Vastustajalle olisi hyvä lisätä oma luokka laattojen käsittelyyn
 */
public class Opponent {

    private SinglePlayerGame game;
    private OpponentTileController tiles;
    private OpponentTurnController turn;
    private GameCharacter gc;
    private int difficulty;
    private boolean hitThisTurn;
    private int turnsLeft;

    public Opponent() {
        turnsLeft = 0;
        tiles = new OpponentTileController();
        turn = new OpponentTurnController(this);
        hitThisTurn = false;
    }
    
    public void addTurn(){
        turnsLeft++;
    }
    
    public void removeTurn(){
        turnsLeft--;
    }
    
    public int getTurns(){
        return turnsLeft;
    }

    public OpponentTileController getTileController() {
        return tiles;
    }

    public void setGame(SinglePlayerGame game) {
        this.game = game;
    }

    public SinglePlayerGame getGame() {
        return game;
    }

    public void setDifficulty(int i) {
        difficulty = i;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setCharacter(GameCharacter gc) {
        this.gc = gc;
    }

    public GameCharacter getCharacter() {
        return gc;
    }

    public void setHitThisTurnTrue() {
        hitThisTurn = true;
    }

    public void setHitThisTurnFalse() {
        hitThisTurn = false;
    }

    public boolean getHitThisTurn() {
        return hitThisTurn;
    }

    /**
     * Lisaa laatan vastustajan muodostamiin pareihin
     *
     * @param tile Laattaa joka kuuluu pariin
     */
    public void addScoredPair(Tile tile) {
        tiles.getScoredTiles().add(tile);
    }

    /**
     * Lisaa laatan vastustajan nakemiin laattoihin
     *
     * @param tile Laattaa joka on nahty
     */
    public void addSeenTile(Tile tile) {
        tiles.addKnownTile(tile);
    }

    /**
     * Poistaa laatan vastustajan nakemista laatoista
     *
     * @param tile Laattaa joka poistetaan
     */
    public void removeSeenTile(Tile tile) {
        tiles.getKnownTiles().remove(tile);
    }

    public String getPortrait() {
        return gc.getCurrentImage();
    }

    public void setHappy() {
        gc.setHappy();
    }

    public void setUnhappy() {
        gc.setUnhappy();
    }

    public void setNeutral() {
        gc.setNeutral();
    }

    public void setTakeDamage() {
        gc.setTakeDamage();
    }

    public void setGiveDamage() {
        gc.setGiveDamage();
    }

    /**
     * Siistii nahtyjen laattojen listan
     */
    public void cleanSeenTiles() {
        tiles.cleanKnownTiles(game);
    }

    /**
     * Kayttaa vuoron
     */
    public void spendTurn() {
        turn.spendTurn();
    }

}
