package TileController;

import Player.AIOpponent.AIBattleOpponent;
import Player.Human.BattlePlayer;
import Tile.BattleTile;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Kontrolloi pelin pelilaattoja
 *
 */
public class BattleTileController {

    private ArrayList<BattleTile> tiles;
    private int pairs;

    public BattleTileController(int pairs) {
        this.pairs = pairs;
        this.tiles = new ArrayList<>();
        newTiles();
    }

    public ArrayList<BattleTile> getTiles() {
        return this.tiles;
    }

    public void shuffleTiles() {
        Collections.shuffle(this.tiles);
        setCoordinates6x6();
    }

    public void setCoordinates6x6() {
        int x = 251;
        int y = 148;
        int z = 0;
        int p = 0;
        for (BattleTile tile : this.tiles) {
            tile.setCoordinates(x, y);
            tile.setPlacement(p);
            p++;
            x += 85;
            z += 1;
            if (z == 6) {
                x = 251;
                y += 85;
                z = 0;
            }
        }
    }

    public int getTilesTurned() {
        int tilesTurned = 0;
        for (BattleTile tile : tiles) {
            if (tile.getTurned()) {
                tilesTurned++;
            }
        }
        return tilesTurned;
    }

    public void unHighlightAll() {
        for (BattleTile tile : tiles) {
            tile.unHighlight();
        }
    }

    public void pairTiles() {
        for (BattleTile tile : tiles) {
            if (tile.getTurned()) {
                tile.pair();
            }
        }
    }

    public void pairTiles(BattlePlayer player) {
        boolean addOne = true;
        for (BattleTile tile : tiles) {
            if (tile.getTurned()) {
                tile.pair();
                if (addOne) {
                    player.addScoredPair(tile);
                    addOne = false;
                }
            }
        }
    }

    public void pairTiles(AIBattleOpponent opponent) {
        boolean addOne = true;
        for (BattleTile tile : tiles) {
            if (tile.getTurned()) {
                tile.pair();
                if (addOne) {
                    opponent.addScoredPair(tile);
                    addOne = false;
                }
            }
        }
    }

    public void unTurnTiles() {
        for (BattleTile tile : tiles) {
            tile.unTurn();
        }
    }

    public void unTurnUnpairedTiles() {
        for (BattleTile tile : tiles) {
            if (!tile.getPaired()) {
                tile.unTurn();
            }
        }
    }

    public int pairedTiles() {
        int pt = 0;
        for (BattleTile tile : tiles) {
            if (tile.getPaired()) {
                pt++;
            }
        }
        return pt;
    }

    public ArrayList<BattleTile> getPairedTiles() {
        ArrayList<BattleTile> t = new ArrayList<>();
        for (BattleTile tile : tiles) {
            if (tile.getPaired()) {
                t.add(tile);
            }
        }
        return t;
    }

    public ArrayList<BattleTile> getFlippedTiles() {
        ArrayList<BattleTile> t = new ArrayList<>();
        for (BattleTile tile : tiles) {
            if (tile.getTurned()) {
                t.add(tile);
            }
        }
        return t;
    }

    public ArrayList<BattleTile> getHiddenTiles() {
        ArrayList<BattleTile> t = new ArrayList<>();
        for (BattleTile tile : tiles) {
            if (!tile.getPaired()) {
                t.add(tile);
            }
        }
        return t;
    }

    public void newTiles() {
        this.tiles = new ArrayList<>();
        int i = 1;
        for (int j = 0; j < pairs; j++) {
            String pname = "watch2x" + i + ".png";
            tiles.add(new BattleTile(i, "watchblank2x.png", "watchhighlight2x.png", pname));
            tiles.add(new BattleTile(i, "watchblank2x.png", "watchhighlight2x.png", pname));
            i++;
            if (i == 10) {
                i = 1;
            }
        }
    }

    public boolean checkPairs(BattlePlayer player) {
        boolean gotPair = false;
        for (BattleTile tile1 : tiles) {
            for (BattleTile tile2 : tiles) {
                if (tile1.getPlacement() != tile2.getPlacement()
                        && tile1.getId() == tile2.getId()
                        && tile1.getTurned() && tile2.getTurned()
                        && !tile1.getPaired()
                        && !tile2.getPaired()) {
                    tile1.pair();
                    tile2.pair();
                    player.addScoredPair(tile1);
                    gotPair = true;
                }
            }
        }
        return gotPair;
    }

    public boolean checkPairs(AIBattleOpponent opponent) {
        boolean gotPair = false;
        for (BattleTile tile1 : tiles) {
            for (BattleTile tile2 : tiles) {
                if (tile1.getPlacement() != tile2.getPlacement()
                        && tile1.getId() == tile2.getId()
                        && tile1.getTurned() && tile2.getTurned()
                        && !tile1.getPaired()
                        && !tile2.getPaired()) {
                    tile1.pair();
                    tile2.pair();
                    opponent.addScoredPair(tile1);
                    gotPair = true;
                }
            }
        }
        return gotPair;
    }

    public void cleanTiles(AIBattleOpponent opponent) {
        unTurnUnpairedTiles();

    }

}
