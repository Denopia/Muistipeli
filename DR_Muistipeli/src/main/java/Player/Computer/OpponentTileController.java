package Player.Computer;

import Game.GameModes.SinglePlayerGame;
import Tile.Tile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Kontrolloi vastustajan nakemia laattoja
 */
public class OpponentTileController {

    private ArrayList<Tile> knownTiles;

    /**
     * Konstruktori, luo listan valmiiksi
     */
    public OpponentTileController() {
        knownTiles = new ArrayList<>();
    }

    /**
     * Palauttaa vastustajan tuntemat laatat
     *
     * @return Laattalista
     */
    public ArrayList<Tile> getKnownTiles() {
        return knownTiles;
    }

    /**
     * Lisaa laatan vastustajan nakemiin laattoihin
     *
     * @param tile Laattaa joka lisataan
     */
    public void addKnownTile(Tile tile) {
        boolean alreadyHere = false;
        for (Tile tile2 : knownTiles) {
            if (tile2.getPlacement() == tile.getPlacement()) {
                alreadyHere = true;
            }
        }
        if (!alreadyHere) {
            knownTiles.add(tile);
        }
    }

    /**
     * Unohtaa kaikki laatat
     */
    public void forgetAll() {
        knownTiles = new ArrayList<>();
    }

    /**
     * Poistaa nahdyista laatoista laatat joilla on jo pari jottei yriteta
     * kaantaa jo kaannettyja laattoja
     *
     * @param game Peli jonka laatat kaydaan lapi
     */
    public void cleanKnownTiles(SinglePlayerGame game) {
        for (Tile tile : game.getTController().getPairedTiles()) {
            knownTiles.remove(tile);
        }
    }

    /**
     * Helpoimman vaikeusasteen laattojen unohdusmetodi
     */
    public void forgetSomeTiles2ez() {
        forgetAll();
    }

    /**
     * Toiseksi helpoimman vaikeusasteen laattojen unohdusmetodi
     */
    public void forgetSomeTilesJustAverage() {
        if (knownTiles.size() <= 0) {
            return;
        }
        int removeThisMany;
        if (knownTiles.size() < 4) {
            removeThisMany = 1;
        } else if (knownTiles.size() < 8) {
            removeThisMany = 2;
        } else {
            removeThisMany = 3;
        }
        while (removeThisMany > 0) {
            ArrayList<Integer> lots = new ArrayList<>();
            int i = 0;
            int j = knownTiles.size();
            while (j > 0) {
                for (int m = 0; m < j; m++) {
                    lots.add(i);
                }
                i++;
                j--;
            }
            Collections.shuffle(lots);
            Random random = new Random();
            int pickThisPlace = random.nextInt(lots.size());
            int removeThis = lots.get(pickThisPlace);
            knownTiles.remove(removeThis);
            removeThisMany--;
        }
    }

    /**
     * Toiseksi vaikeimman vaikeusasteen laattojen unohdusmetodi
     */
    public void forgetSomeTilesChallenging() {
        if (knownTiles.size() <= 0) {
            return;
        }
        int removeThisMany;
        if (knownTiles.size() < 6) {
            removeThisMany = 1;
        } else if (knownTiles.size() < 10) {
            removeThisMany = 2;
        } else {
            removeThisMany = 3;
        }
        while (removeThisMany > 0) {
            ArrayList<Integer> lots = new ArrayList<>();
            int i = 0;
            int j = knownTiles.size();
            while (j > 0) {
                for (int m = 0; m < j; m++) {
                    lots.add(i);
                }
                i++;
                j--;
            }
            Collections.shuffle(lots);
            Random random = new Random();
            int pickThisPlace = random.nextInt(lots.size());
            int removeThis = lots.get(pickThisPlace);
            knownTiles.remove(removeThis);
            removeThisMany--;
        }
    }

    /**
     * Vaikeimman vaikeusasteen laattojen unohdusmetodi
     */
    public void forgetSomeTilesImpossible() {
    }

    /**
     * Metodi joka paattaa unohtaako vastustaja taman vuoron alussa joitain
     * laattoja
     *
     * @return True jos unohtaa, false jos ei
     */
    public boolean doIForgetJustAverage() {
        Random random = new Random();
        double lessThan4 = 0.2;
        double lessThan6 = 0.4;
        double lessThan8 = 0.8;
        double randomB = random.nextDouble();
        if (this.knownTiles.size() < 4) {
            return randomB < lessThan4;
        } else if (this.knownTiles.size() < 6) {
            return randomB < lessThan6;
        } else if (this.knownTiles.size() < 8) {
            return randomB < lessThan8;
        } else {
            return true;
        }
    }

    /**
     * Metodi joka paattaa unohtaako vastustaja taman vuoron alussa joitain
     * laattoja
     *
     * @return True jos unohtaa, false jos ei
     */
    public boolean doIForgetChallenging() {
        Random random = new Random();
        double lessThan4 = 0.1;
        double lessThan6 = 0.3;
        double lessThan8 = 0.6;
        double lessThan10 = 0.9;
        double randomB = random.nextDouble();
        if (this.knownTiles.size() < 4) {
            return randomB < lessThan4;
        } else if (this.knownTiles.size() < 6) {
            return randomB < lessThan6;
        } else if (this.knownTiles.size() < 8) {
            return randomB < lessThan8;
        } else if (this.knownTiles.size() < 10) {
            return randomB < lessThan10;
        } else {
            return true;
        }
    }

    /**
     * Metodi joka paattaa unohtaako vastustaja taman vuoron alussa joitain
     * laattoja
     *
     * @return True jos unohtaa, false jos ei
     */
    public boolean doIForgetImpossible() {
        return false;
    }

    /**
     * Metodi joka paattaa unohtaako vastustaja taman vuoron alussa joitain
     * laattoja
     *
     * @return True jos unohtaa, false jos ei
     */
    public boolean doIForget2ez() {
        return true;
    }

    /**
     * Listaa kaikki laatat joita ei tiedetä
     *
     * @param game Peli josta haetaan laatat
     * @return Lista laatoista joita ei tiedetä
     */
    public ArrayList<Tile> getUnseenTiles(SinglePlayerGame game) {
        ArrayList<Tile> unturned = game.getTController().getHiddenTiles();
        ArrayList<Tile> unseen = new ArrayList<>();
        for (Tile ut : unturned) {
            boolean notSeen = true;
            for (Tile ft : knownTiles) {
                if (ut.getPlacement() == ft.getPlacement()) {
                    notSeen = false;
                }
            }
            if (notSeen) {
                unseen.add(ut);
            }
        }
        return unseen;
    }

    /**
     * Käy läpi nähdyt laatat ja jos löytyy pari palautetaan se listana
     *
     * @return Lista jossa on kaksi laattaa jotka muodostavat parin
     */
    public ArrayList<Tile> checkForPair() {
        ArrayList<Tile> tp = new ArrayList<>();
        for (Tile tile1 : knownTiles) {
            for (Tile tile2 : knownTiles) {
                if ((tile1.getPlacement() != tile2.getPlacement())
                        && (tile1.getEffect().equals(tile2.getEffect()))
                        && !tile1.getEffect().equals("skull")) {
                    tp.add(tile1);
                    tp.add(tile2);
                    return tp;
                }
            }
        }
        return tp;
    }
}
