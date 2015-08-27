package Player.Human;

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
    private boolean skill1Selected;
    private boolean neautralState;

    public Player() {
        this.neautralState = true;
        this.scoredTiles = new ArrayList<>();
        this.hitThisTurn = false;
        this.skill1Selected = false;

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
     * @param tile Laatta mika on osa paria jonka pelaaja on muodostanut
     */
    public void addScoredPair(Tile tile) {
        gc.setEnergy(gc.getEnergy() + 1);
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
        skill1Selected = true;
    }

    public void deselectSkil1() {
        skill1Selected = false;
    }

    public boolean getSkill1Selected() {
        return skill1Selected;
    }

    /**
     * Kayttaa pelaajan pelihahmon taidon
     * @param tiles Pelin laatat
     * @param row Joku luku joka määrittelee kuinka taito toimii, tassa tapauksessa viela vain rivi
     * @return Laatat jotka kuuluvat taidon efektin alueeseen
     */
    public ArrayList<Tile> useSkill1(ArrayList<Tile> tiles, int row) {
        deselectSkil1();
        return gc.useSkill(tiles, row);
    }

}
