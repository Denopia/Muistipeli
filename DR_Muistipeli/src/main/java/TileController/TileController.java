package TileController;

import Player.Computer.Opponent;
import Player.Human.Player;
import Tile.Tile;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Kontrolloi pelin pelilaattoja
 *
 */
public class TileController {

    private ArrayList<Tile> tiles;
    private int pairs;

    public TileController(int pairs) {
        this.pairs = pairs;
        this.tiles = new ArrayList<>();
        newTiles();
    }

    public ArrayList<Tile> getTiles() {
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
        for (Tile tile : this.tiles) {
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
        for (Tile tile : tiles) {
            if (tile.getTurned()) {
                tilesTurned++;
            }
        }
        return tilesTurned;
    }

    public void unHighlightAll() {
        for (Tile tile : tiles) {
            tile.unHighlight();
        }
    }

    public void pairTiles() {
        for (Tile tile : tiles) {
            if (tile.getTurned()) {
                tile.pair();
            }
        }
    }

    public void pairTiles(Player player) {
        boolean addOne = true;
        for (Tile tile : tiles) {
            if (tile.getTurned()) {
                tile.pair();
                if (addOne) {
                    player.addScoredPair(tile);
                    addOne = false;
                }
            }
        }
    }

    public void pairTiles(Opponent opponent) {
        boolean addOne = true;
        for (Tile tile : tiles) {
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
        for (Tile tile : tiles) {
            tile.unTurn();
        }
    }

    public void unTurnUnpairedTiles() {
        for (Tile tile : tiles) {
            if (!tile.getPaired()) {
                tile.unTurn();
            }
        }
    }

    public int pairedTiles() {
        int pt = 0;
        for (Tile tile : tiles) {
            if (tile.getPaired()) {
                pt++;
            }
        }
        return pt;
    }

    public ArrayList<Tile> getPairedTiles() {
        ArrayList<Tile> t = new ArrayList<>();
        for (Tile tile : tiles) {
            if (tile.getPaired()) {
                t.add(tile);
            }
        }
        return t;
    }

    public ArrayList<Tile> getFlippedTiles() {
        ArrayList<Tile> t = new ArrayList<>();
        for (Tile tile : tiles) {
            if (tile.getTurned()) {
                t.add(tile);
            }
        }
        return t;
    }

    public ArrayList<Tile> getHiddenTiles() {
        ArrayList<Tile> t = new ArrayList<>();
        for (Tile tile : tiles) {
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
            tiles.add(new Tile(i, "watchblank2x.png", "watchhighlight2x.png", pname));
            tiles.add(new Tile(i, "watchblank2x.png", "watchhighlight2x.png", pname));
            i++;
            if (i == 10) {
                i = 1;
            }
        }
    }

    public boolean checkPairs(Player player) {
        boolean gotPair = false;
        for (Tile tile1 : tiles) {
            for (Tile tile2 : tiles) {
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

    public boolean checkPairs(Opponent opponent) {
        boolean gotPair = false;
        for (Tile tile1 : tiles) {
            for (Tile tile2 : tiles) {
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

    public void cleanTiles(Opponent opponent) {
        unTurnUnpairedTiles();

    }

}
