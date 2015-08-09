package Controller;

import Player.OpponentAI;
import Player.Player;
import Tile.Tile;
import java.util.ArrayList;
import java.util.Collections;

public class TileController {

    private ArrayList<Tile> tiles;

    public TileController(int pairs) {
        this.tiles = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < pairs; j++) {
            String pname = "watch2x" + i + ".png";
            tiles.add(new Tile(i, "watchBlank2x.png", "watchHighlight2x.png", pname));
            tiles.add(new Tile(i, "watchBlank2x.png", "watchHighlight2x.png", pname));
            i++;
            if (i == 10) {
                i = 0;
            }
        }
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

    public boolean checkPair() {
        int firstTileId = 123456789;
        int secondTileId = 987654321;
        boolean f = false;
        if (getTilesTurned() == 2) {
            for (Tile tile : tiles) {
                if (tile.getTurned()) {
                    if (!f) {
                        firstTileId = tile.getId();
                        f = true;
                    } else {
                        secondTileId = tile.getId();
                    }
                }
            }
        }
        return firstTileId == secondTileId;
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
        for (Tile tile : tiles) {
            if (tile.getTurned()) {
                tile.pair();
                player.addScoredPair(tile);
            }
        }
    }

    public void pairTiles(OpponentAI opponent) {
        for (Tile tile : tiles) {
            if (tile.getTurned()) {
                tile.pair();
                opponent.addScoredPair(tile);
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

}
