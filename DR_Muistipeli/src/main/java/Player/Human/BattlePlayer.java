package Player.Human;

import GameCharacter.GameCharacter;
import Player.AIOpponent.AIBattleOpponent;
import Tile.BattleTile;
import TileController.BattleTileController;
import java.awt.Image;
import java.util.ArrayList;

/**
 * Pitää sisällään ihmispelaajan tiedot.
 *
 */
public class BattlePlayer {

    private GameCharacter gc;
    private ArrayList<BattleTile> scoredTiles;
    private boolean hitThisTurn;
    private boolean skill1Selected;

    public BattlePlayer() {
        this.scoredTiles = new ArrayList<>();
        hitThisTurn = false;
        skill1Selected = false;

    }

    public void setCharacter(GameCharacter gc) {
        this.gc = gc;
    }

    public void setHitThisTurnTrue() {
        this.hitThisTurn = true;
    }

    public void setHitThisTurnFalse() {
        this.hitThisTurn = false;
    }

    public boolean getHitThisTurn() {
        return this.hitThisTurn;
    }

    public int getNumberOfPairsScored() {
        return this.scoredTiles.size();
    }

    public void addScoredPair(BattleTile tile) {
        this.gc.setEnergy(this.gc.getEnergy() + 1);
        this.scoredTiles.add(tile);
    }

    public Image getPortrait() {
        return this.gc.getCurrentImage();
    }

    public void scorePair() {
        setHappy();
    }

    public void failPair() {
        setUnhappy();
    }

    public void setHappy() {
        this.gc.setHappy();
    }

    public void setUnhappy() {
        this.gc.setUnhappy();
    }

    public void setNeutral() {
        this.gc.setNeutral();
    }

    public void setTakeDamage() {
        this.gc.setTakeDamage();
    }

    public void setGiveDamage() {
        this.gc.setGiveDamage();
    }

    public GameCharacter getCharacter() {
        return this.gc;
    }

    public void selectSkil1() {
        this.skill1Selected = true;
    }

    public void deselectSkil1() {
        this.skill1Selected = false;
    }

    public boolean getSkill1Selected() {
        return skill1Selected;
    }

    public void useSkill1(BattleTileController tc, int row, AIBattleOpponent bo) {
        int r = row * 6;
        for (int i = 0; i < 6; i++) {
            tc.getTiles().get(r).turn();
            bo.addSeenTile( tc.getTiles().get(r));
            r++;
        }
        deselectSkil1();
    }

}
