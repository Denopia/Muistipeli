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
        return tiles;
    }

    public void shuffleTiles() {
        Collections.shuffle(tiles);
        setCoordinates6x6();
    }

    public void setCoordinates6x6() {
        int x = 251;
        int y = 148;
        int z = 0;
        int p = 0;
        for (Tile tile : tiles) {
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

    /**
     * Palauta niiden laattojen lukumäärä jotka on käännetty näkyviin, mutta
     * eivät ole vielä muodostaneet paria
     *
     * @return Laattojen lukumäärä
     */
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

    /**
     * Palautetaan lista laatoista joilla on pari
     *
     * @return Laattalista
     */
    public ArrayList<Tile> getPairedTiles() {
        ArrayList<Tile> t = new ArrayList<>();
        for (Tile tile : tiles) {
            if (tile.getPaired()) {
                t.add(tile);
            }
        }
        return t;
    }

    /**
     * Palautetaan lista laatoista joilla ei ole paria
     *
     * @return Laattalista
     */
    public ArrayList<Tile> getHiddenTiles() {
        ArrayList<Tile> t = new ArrayList<>();
        for (Tile tile : tiles) {
            if (!tile.getPaired()) {
                t.add(tile);
            }
        }
        return t;
    }

    /**
     * Luodaan uudet pelilaatat
     */
    public final void newTiles() {
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

    /**
     * Tarkastaa kaikki käännetyt laatat ja jos löytyy pareja muodostaa niistä
     * parin ja lisää sen pelaajalle
     *
     * @param player Pelaaja jolle pari lisätään
     * @return Jos löytyy pari palautetaan true, jos ei löydy palautetaan false
     */
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

    /**
     * Tarkastaa kaikki käännetyt laatat ja jos löytyy pareja muodostaa niistä
     * parin ja lisää sen pelaajalle
     *
     * @param opponent Vastustaja jolle pari lisätään
     * @return Jos löytyy pari palautetaan true, jos ei löydy palautetaan false
     */
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

    /**
     * Käänetään parittomat laatat piiloon
     */
    public void cleanTiles() {
        unTurnUnpairedTiles();

    }

}
