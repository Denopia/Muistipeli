package Player;

import GameCharacter.GameCharacter;
import GameCharacter.PBot;
import Tile.Tile;
import java.awt.Image;
import java.util.ArrayList;

public class Player {

    private GameCharacter gc;
    private ArrayList<Tile> tiles;

    public Player() {
        this.gc = new PBot();
        this.tiles = new ArrayList<Tile>();
    }

    public void addPair(Tile tile) {
        this.tiles.add(tile);
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
    
    public void setHappy(){
        this.gc.setCurrentImage(this.gc.getYes());
    }
    
    public void setUnhappy(){
        this.gc.setCurrentImage(this.gc.getNo());
    }
    
    public void setNeutral(){
        this.gc.setCurrentImage(this.gc.getBasic());
    }

}
