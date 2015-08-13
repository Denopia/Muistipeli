package Player;

import GameCharacter.GameCharacter;
import GameCharacter.PBot;
import Tile.BattleTile;
import java.awt.Image;
import java.util.ArrayList;

public class BattlePlayer {

    private GameCharacter gc;
    private ArrayList<BattleTile> scoredTiles;

    public BattlePlayer() {
        this.gc = new PBot();
        this.scoredTiles = new ArrayList<>();
    }

    public int getNumberOfPairsScored() {
        return this.scoredTiles.size();
    }

    public void addScoredPair(BattleTile tile) {
        this.gc.setEnergy(this.gc.getEnergy() + 3);
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

    public GameCharacter getCharacter() {
      return this.gc;
    }

}
