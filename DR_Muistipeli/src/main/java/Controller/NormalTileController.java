package Controller;

import Player.AIOpponent.AINormalOpponent;
import Player.Human.NormalPlayer;
import Tile.NormalTile;
import java.util.ArrayList;
import java.util.Collections;

public class NormalTileController {

    private ArrayList<NormalTile> tiles;

    public NormalTileController(int pairs) {
        this.tiles = new ArrayList<>();
        int i = 1;
        for (int j = 0; j < pairs; j++) {
            String pname = "watch2x" + i + ".png";
            tiles.add(new NormalTile(i, "watchBlank2x.png", "watchHighlight2x.png", pname));
            tiles.add(new NormalTile(i, "watchBlank2x.png", "watchHighlight2x.png", pname));
            i++;
            if (i == 10) {
                i = 1;
            }
        }
    }

    public ArrayList<NormalTile> getTiles() {
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
        for (NormalTile tile : this.tiles) {
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
            for (NormalTile tile : tiles) {
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
        for (NormalTile tile : tiles) {
            if (tile.getTurned()) {
                tilesTurned++;
            }
        }
        return tilesTurned;
    }

    public void unHighlightAll() {
        for (NormalTile tile : tiles) {
            tile.unHighlight();
        }
    }

    public void pairTiles() {
        for (NormalTile tile : tiles) {
            if (tile.getTurned()) {
                tile.pair();
            }
        }
    }

    public void pairTiles(NormalPlayer player) {
        for (NormalTile tile : tiles) {
            if (tile.getTurned()) {
                tile.pair();
                player.addScoredPair(tile);
            }
        }
    }

    public void pairTiles(AINormalOpponent opponent) {
        for (NormalTile tile : tiles) {
            if (tile.getTurned()) {
                tile.pair();
                opponent.addScoredPair(tile);
            }
        }
    }

    public void unTurnTiles() {
        for (NormalTile tile : tiles) {
            tile.unTurn();
        }
    }

    public void unTurnUnpairedTiles() {
        for (NormalTile tile : tiles) {
            if (!tile.getPaired()) {
                tile.unTurn();
            }
        }
    }

    public int pairedTiles() {
        int pt = 0;
        for (NormalTile tile : tiles) {
            if (tile.getPaired()) {
                pt++;
            }
        }
        return pt;
    }

    public ArrayList<NormalTile> getPairedTiles() {
        ArrayList<NormalTile> t = new ArrayList<>();
        for (NormalTile tile : tiles) {
            if (tile.getPaired()) {
                t.add(tile);
            }
        }
        return t;
    }

    public ArrayList<NormalTile> getFlippedTiles() {
        ArrayList<NormalTile> t = new ArrayList<>();
        for (NormalTile tile : tiles) {
            if (tile.getTurned()) {
                t.add(tile);
            }
        }
        return t;
    }

    public ArrayList<NormalTile> getHiddenTiles() {
        ArrayList<NormalTile> t = new ArrayList<>();
        for (NormalTile tile : tiles) {
            if (!tile.getPaired()) {
                t.add(tile);
            }
        }
        return t;
    }

}
