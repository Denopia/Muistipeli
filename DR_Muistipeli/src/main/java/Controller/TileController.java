package Controller;

import Game.GameModes.SinglePlayerGame;
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
    private final String[] tileEffects = {"turn+1", "energy+1", "hit+1", "health+1", "skull", "turn+2", "energy+2", "hit+2", "health+2"};
    private final String[] tilePaths = {"watch2x1turn.png", "watch2x1energy.png",
        "watch2x1damage.png", "watch2x1health.png", "watch2xskull.png", "watch2x2turn.png",
        "watch2x2energy.png", "watch2x2damage.png", "watch2x2health.png"};

    /**
     * Konstruktori, luo laatat
     *
     * @param pairs Kuinka monta paria luodaan
     */
    public TileController(int pairs) {
        this.pairs = pairs;
        this.tiles = new ArrayList<>();
        newTiles();
    }

    /**
     * Palauttaa laattojen efektit listana
     *
     * @return Efektit
     */
    public String[] getEffects() {
        return tileEffects;
    }

    /**
     * Palauttaa listan kaikista laatoista
     *
     * @return Laatat
     */
    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    /**
     * Sekoittaa laatat, ja lopuksi asettaa niille uudet koordinaatit
     */
    public void shuffleTiles() {
        Collections.shuffle(tiles);
        setCoordinates6x6();
    }

    /**
     * Asettaa laatoille koordinaatit ja paikat
     */
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

    /**
     * Asettaa kaikki laatat korostamattomiksi
     */
    public void unHighlightAll() {
        for (Tile tile : tiles) {
            tile.unHighlight();
        }
    }

    /**
     * Piilottaa kaikki laatat
     */
    public void unTurnTiles() {
        for (Tile tile : tiles) {
            tile.unTurn();
        }
    }

    /**
     * Piilottaa kaikki laatat joilla ei ole paria
     */
    public void unTurnUnpairedTiles() {
        for (Tile tile : tiles) {
            if (!tile.getPaired()) {
                tile.unTurn();
            }
        }
    }

    /**
     * Palauttaa lukumaaran laatoista joille on loytynyt pari
     *
     * @return Parilaatat
     */
    public int getTilesPaired() {
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
        int i = 0;
        int p = 18;
        while (p > 0) {
            tiles.add(new Tile(tileEffects[i], "watchblank2x.png", "watchhighlight2x.png", tilePaths[i]));
            tiles.add(new Tile(tileEffects[i], "watchblank2x.png", "watchhighlight2x.png", tilePaths[i]));
            i++;
            p--;
            if (i == 8) {
                i = 0;
            }
        }
    }

    /**
     * Tarkastaa kaikki käännetyt laatat ja jos löytyy pareja muodostaa niistä
     * parin ja lisää sen pelaajalle
     *
     * @param game Peli jota kasitellaan
     * @return Jos löytyy pari palautetaan true, jos ei löydy palautetaan false
     */
    public boolean checkPairsForPlayer(SinglePlayerGame game) {
        boolean gotPair = false;
        for (Tile tile1 : tiles) {
            for (Tile tile2 : tiles) {
                if (tile1.getPlacement() != tile2.getPlacement()
                        && tile1.getEffect().equals(tile2.getEffect())
                        && tile1.getTurned() && tile2.getTurned()
                        && !tile1.getPaired()
                        && !tile2.getPaired()) {
                    tile1.pair();
                    tile2.pair();
                    gotPair = true;
                    doTileEffectForPlayer(game, tile1);
                    game.setCharacterPictures(tile1.getEffect());
                }
            }
        }
        return gotPair;
    }

    /**
     * Tarkastaa kaikki käännetyt laatat ja jos löytyy pareja muodostaa niistä
     * parin ja lisää sen pelaajalle
     *
     * @param game Peli jota kasitellaan
     * @return Jos löytyy pari palautetaan true, jos ei löydy palautetaan false
     */
    public boolean checkPairsForOpponent(SinglePlayerGame game) {
        boolean gotPair = false;
        for (Tile tile1 : tiles) {
            for (Tile tile2 : tiles) {
                if (tile1.getPlacement() != tile2.getPlacement()
                        && tile1.getEffect().equals(tile2.getEffect())
                        && tile1.getTurned() && tile2.getTurned()
                        && !tile1.getPaired()
                        && !tile2.getPaired()) {
                    tile1.pair();
                    tile2.pair();
                    gotPair = true;
                    doTileEffectForOpponent(game, tile1);
                    game.setCharacterPictures(tile1.getEffect());
                }
            }
        }
        return gotPair;
    }

    /**
     * Kaantaa tietyt laatat
     *
     * @param tiles Laatat jotka halutaan kaantaa
     */
    public void turnTheseTiles(ArrayList<Tile> tiles) {
        for (Tile tile : tiles) {
            tile.turn();
        }
    }

    /**
     * Tekee tietyn laatan efektin
     *
     * @param game Peli jota kasitellaan
     * @param tile Laatta jonka efekti halutaan suorittaa
     */
    public void doTileEffectForPlayer(SinglePlayerGame game, Tile tile) {
        if (tile.getEffect().equals(tileEffects[0])) {
            game.getPlayer().addHit();
            game.getPlayer().addMove();
        } else if (tile.getEffect().equals(tileEffects[1])) {
            game.getPlayer().getCharacter().setEnergy(game.getPlayer().getCharacter().getEnergy() + 1);
        } else if (tile.getEffect().equals(tileEffects[2])) {
            game.getOpponent().getCharacter().setHp(game.getOpponent().getCharacter().getHp() - 1);
        } else if (tile.getEffect().equals(tileEffects[3])) {
            game.getPlayer().getCharacter().setHp(game.getPlayer().getCharacter().getHp() + 1);
        } else if (tile.getEffect().equals(tileEffects[4])) {
            game.getPlayer().getCharacter().setHp(game.getPlayer().getCharacter().getHp() - 3);
        } else if (tile.getEffect().equals(tileEffects[5])) {
            game.getPlayer().addMove();
            game.getPlayer().addMove();
            game.getPlayer().addHit();
            game.getPlayer().addHit();
        } else if (tile.getEffect().equals(tileEffects[6])) {
            game.getPlayer().getCharacter().setEnergy(game.getPlayer().getCharacter().getEnergy() + 2);
        } else if (tile.getEffect().equals(tileEffects[7])) {
            game.getOpponent().getCharacter().setHp(game.getOpponent().getCharacter().getHp() - 2);
        } else if (tile.getEffect().equals(tileEffects[8])) {
            game.getPlayer().getCharacter().setHp(game.getPlayer().getCharacter().getHp() + 2);
        }
    }

    /**
     * Tekee tietyn laatan efektin
     *
     * @param game Peli jota kasitellaan
     * @param tile Laatta jonka efekti halutaan suorittaa
     */
    public void doTileEffectForOpponent(SinglePlayerGame game, Tile tile) {
        if (tile.getEffect().equals(tileEffects[0])) {
            game.getOpponent().addMove();
            game.getOpponent().addHit();
        } else if (tile.getEffect().equals(tileEffects[1])) {
            game.getOpponent().getCharacter().setEnergy(game.getOpponent().getCharacter().getEnergy() + 1);
        } else if (tile.getEffect().equals(tileEffects[2])) {
            game.getPlayer().getCharacter().setHp(game.getPlayer().getCharacter().getHp() - 1);
        } else if (tile.getEffect().equals(tileEffects[3])) {
            game.getOpponent().getCharacter().setHp(game.getOpponent().getCharacter().getHp() + 1);
        } else if (tile.getEffect().equals(tileEffects[4])) {
            game.getOpponent().getCharacter().setHp(game.getOpponent().getCharacter().getHp() - 3);
        } else if (tile.getEffect().equals(tileEffects[5])) {
            game.getOpponent().addMove();
            game.getOpponent().addMove();
            game.getOpponent().addHit();
            game.getOpponent().addHit();
        } else if (tile.getEffect().equals(tileEffects[6])) {
            game.getOpponent().getCharacter().setEnergy(game.getOpponent().getCharacter().getEnergy() + 2);
        } else if (tile.getEffect().equals(tileEffects[7])) {
            game.getPlayer().getCharacter().setHp(game.getPlayer().getCharacter().getHp() - 2);
        } else if (tile.getEffect().equals(tileEffects[8])) {
            game.getOpponent().getCharacter().setHp(game.getOpponent().getCharacter().getHp() + 2);
        }
    }

    /**
     * Tarkastaa onko edes yksi laattaa kaannetty, muttei laske mukaan
     * parillisia laattoja
     *
     * @return Onko laattaa kaannettyna
     */
    public boolean tileIsTurned() {
        for (Tile tile : tiles) {
            if (tile.getTurned()) {
                return true;
            }
        }
        return false;
    }
}
