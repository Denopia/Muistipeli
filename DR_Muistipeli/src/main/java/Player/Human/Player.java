package Player.Human;

import Game.GameModes.SinglePlayerGame;
import GameCharacter.GameCharacter;
import Tile.Tile;
import java.awt.Image;
import java.util.ArrayList;

/**
 * Pitää sisällään ihmispelaajan tiedot.
 */
public class Player {

    private GameCharacter gc;
    private ArrayList<Tile> scoredTiles;
    private boolean hitThisTurn;
    private boolean skillSelected;
    private boolean neautralState;
    private int turnsLeft;

    public Player() {
        turnsLeft = 0;
        this.neautralState = true;
        this.scoredTiles = new ArrayList<>();
        this.hitThisTurn = false;
        this.skillSelected = false;

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

    public void setNeutralStateTrue() {
        neautralState = true;
    }

    public void setNeutralStateFalse() {
        neautralState = false;
    }

    public boolean getNeutralState() {
        return neautralState;
    }

    public void setCharacter(GameCharacter gc) {
        this.gc = gc;
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

    public int getNumberOfPairsScored() {
        return scoredTiles.size();
    }

    /**
     * Lisaa laatan pelaajan kaantamiin pareihin
     *
     * @param tile Laatta mika on osa paria jonka pelaaja on muodostanut
     */
    public void addScoredPair(Tile tile) {
        scoredTiles.add(tile);
    }

    public Image getPortrait() {
        return gc.getCurrentImage();
    }

    public void scorePair() {
        setHappy();
    }

    public void failPair() {
        setUnhappy();
    }

    public void setHappy() {
        gc.setHappy();
        setNeutralStateFalse();
    }

    public void setUnhappy() {
        gc.setUnhappy();
        setNeutralStateFalse();
    }

    public void setNeutral() {
        gc.setNeutral();
        setNeutralStateTrue();
    }

    public void setTakeDamage() {
        gc.setTakeDamage();
        setNeutralStateFalse();
    }

    public void setGiveDamage() {
        gc.setGiveDamage();
        setNeutralStateFalse();
    }

    public GameCharacter getCharacter() {
        return gc;
    }

    public void selectSkil1() {
        skillSelected = true;
    }

    public void deselectSkil() {
        skillSelected = false;
    }

    public boolean getSkillSelected() {
        return skillSelected;
    }

    /**
     * Kayttaa pelaajan pelihahmon taidon
     *
     * @param game
     * @return
     */
    public boolean useSkill(SinglePlayerGame game) {
        return gc.useSkill(game);
    }

}
