package Player.Human;

import GameCharacter.GameCharacter;
import GameCharacter.Gus;
import GameCharacter.PBot;
import Tile.NormalTile;
import java.awt.Image;
import java.util.ArrayList;

/**
 * Pitää sisällään ihmispelaajan tiedot.
 * 
 */
public class NormalPlayer {

    private GameCharacter gc;
    private ArrayList<NormalTile> scoredTiles;

    public NormalPlayer() {
        this.scoredTiles = new ArrayList<>();
    }
    
    public void setCharacter(GameCharacter gc) {
        this.gc = gc;
    }

    public int getNumberOfPairsScored() {
        return this.scoredTiles.size();
    }

    public void addScoredPair(NormalTile tile) {
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
        this.gc.setCurrentImage(this.gc.getYes());
    }

    public void setUnhappy() {
        this.gc.setCurrentImage(this.gc.getNo());
    }

    public void setNeutral() {
        this.gc.setCurrentImage(this.gc.getBasic());
    }

}
