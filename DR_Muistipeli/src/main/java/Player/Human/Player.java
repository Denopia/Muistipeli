package Player.Human;

import GameCharacter.GameCharacter;
import Player.Computer.Opponent;
import Tile.Tile;
import TileController.TileController;
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

    public Player() {
        this.scoredTiles = new ArrayList<>();
        this.hitThisTurn = false;
        this.skill1Selected = false;

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
     * Käyttää taidon, joka kääntää yhden rivin laattoja Tulisi olla oikeastaan
     * pelihahmolla tämä metodi Lisäksi varmaan parempi vain laittaa
     * palauttamaan lista käännettävistä laatoista pelille, joka voi sitten
     * kontrollerin kautta ne kääntää
     *
     * @param tc Laattakontrolleri
     * @param row Mille riville taito käytetään
     * @param bo Vastustaja
     */
    public void useSkill1(TileController tc, int row, Opponent bo) {
        int r = row * 6;
        for (int i = 0; i < 6; i++) {
            tc.getTiles().get(r).turn();
            bo.addSeenTile(tc.getTiles().get(r));
            r++;
        }
        deselectSkil1();
    }

}
