package Player.Computer;

import Game.GameModes.SinglePlayerGame;
import GameCharacter.GameCharacter;
import Tile.Tile;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.Timer;

/**
 * Yksinpelin vastustaja. PitÃ¤Ã¤ sisÃ¤llÃ¤Ã¤n tietokonevastuksen tiedot ja
 * suorittaa vastuksen vuoron.
 *
 * Vastustajalle olisi hyvä lisätä oma luokka laattojen käsittelyyn
 */
public class Opponent {

    private int turn;
    private SinglePlayerGame game;
    private ArrayList<Tile> scoredTiles;
    private ArrayList<Tile> knownTiles;
    private GameCharacter gc;
    private int difficulty;
    private boolean hitThisTurn;

    public Opponent() {
        turn = 0;
        scoredTiles = new ArrayList<>();
        knownTiles = new ArrayList<>();
        hitThisTurn = false;
    }

    public void setGame(SinglePlayerGame game) {
        this.game = game;
    }

    public void setDifficulty(int i) {
        difficulty = i;
    }

    public void setCharacter(GameCharacter gc) {
        this.gc = gc;
    }

    public GameCharacter getCharacter() {
        return gc;
    }

    public void setHitThisTurnTrue() {
        hitThisTurn = true;
    }

    public void setHitThisTurnFalse() {
        hitThisTurn = false;
    }

    public boolean getHitThisTurn() {
        return hitThisTurn;
    }

    public void addScoredPair(Tile tile) {
        gc.setEnergy(gc.getEnergy() + 1);
        scoredTiles.add(tile);
    }

    public int getNumberOfPairsScored() {
        return scoredTiles.size();
    }

    public void addSeenTile(Tile tile) {
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

    public void removeSeenTile(Tile tile) {
        knownTiles.remove(tile);
    }

    public Image getPortrait() {
        return gc.getCurrentImage();
    }

    public void setHappy() {
        gc.setHappy();
    }

    public void setUnhappy() {
        gc.setUnhappy();
    }

    public void setNeutral() {
        gc.setNeutral();
    }

    public void setTakeDamage() {
        gc.setTakeDamage();
    }

    public void setGiveDamage() {
        gc.setGiveDamage();
    }

    public void cleanSeenTiles() {
        for (Tile til : game.getController().getPairedTiles()) {
            this.knownTiles.remove(til);
        }
    }

    public void forgetSomeTiles2ez() {
        forgetAll();
    }

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

    public void forgetSomeTilesImpossible() {
        turn++;
        System.out.println("ON VUORO : " + turn);
        System.out.println("TIEDÄN MITÄ ON NÄIDEN LAATTOJEN TAKANA:");
        for (Tile t : knownTiles) {
            System.out.println("LAATAN NUMERO " + t.getPlacement() + " TAKANA ON LUKU " + t.getId());
        }
//        System.out.println("NEVER FORGET");
    }

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

    public boolean doIForgetImpossible() {
        return true;
    }

    public boolean doIForget2ez() {
        return true;
    }

    public void actionsBeforeTurningTiles() {
        cleanSeenTiles();
        if (difficulty == 1) {
            if (doIForget2ez()) {
                forgetSomeTiles2ez();
            }
        } else if (difficulty == 2) {
            if (doIForgetJustAverage()) {
                forgetSomeTilesJustAverage();
            }
        } else if (difficulty == 3) {
            if (doIForgetChallenging()) {
                forgetSomeTilesChallenging();
            }
        } else if (difficulty == 4) {
            if (doIForgetImpossible()) {
                forgetSomeTilesImpossible();
            }
        }
    }

    public void spendTurn() {
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int slowDown = 0;
                actionsBeforeTurningTiles();
                if (doIHit()) {
                    game.hitPlayer();
                    slowDown = +1000;
                }
                if (doIUseAbility()) {
                    slowDown = +1000;
                }
                turnTwoTiles(slowDown);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public boolean doIHit() {
        return true;
    }

    public boolean doIUseAbility() {
        return false;
    }

    /**
     * Vastustaja kääntää kaksi laattaa
     *
     * @param slowDown Kuinka paljon timerit odottaa lisää
     */
    public void turnTwoTiles(int slowDown) {
        Timer timer;
        Timer timerMini;
        Timer timer2;
        Timer timer2Mini;

        //Katsotaan onko tiedossa paria joka voitaisiin kääntää
        final ArrayList<Tile> seenPair = checkForPair();
        //Jos tiedetään pari, käännetään se
        if (!seenPair.isEmpty()) {
            //Kääntää ensimmäisen laatan
            timer = new Timer(2000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    game.getController().getTiles().get(seenPair.get(0).getPlacement()).turn();
                    game.refresh();
                }
            });
            //Kääntää toisen laatan
            timer2 = new Timer(4000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    game.getController().getTiles().get(seenPair.get(1).getPlacement()).turn();
                    game.refresh();
                    game.pairTiles();
                }
            });
            //Korostaa ensimmäisen laatan
            timerMini = new Timer(1000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    game.getController().getTiles().get(seenPair.get(0).getPlacement()).highlight();
                    game.refresh();
                }
            });
            //Korostaa toisen laatan
            timer2Mini = new Timer(3000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    game.getController().getTiles().get(seenPair.get(1).getPlacement()).highlight();
                    game.refresh();
                }
            });
        } else {
            //Jos ei tiedetä paria niin joudutaan arvamaan aluksi yksi laatta sattumalta
            final Tile firstTile;
            final Tile secondTile;

            int random1 = randomNumber(getUnseenTiles().size());
            firstTile = getUnseenTiles().get(random1);
            addSeenTile(firstTile);
            boolean luckyPair = false;
            for (Tile nt : knownTiles) {
                if (nt.getId() == firstTile.getId()
                        && nt.getPlacement() != firstTile.getPlacement()) {
                    luckyPair = true;
                }
            }
            //Luodaan varalle toinen random laatta, jos ensimmäiselle ei tiedetä paria
            int random2 = random1;
            while (random1 == random2) {
                random2 = randomNumber(getUnseenTiles().size());
            }
            secondTile = getUnseenTiles().get(random2);
            //Kääntää ensimmäisen laatan
            timer = new Timer(2000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    firstTile.turn();
                    game.refresh();
                }
            });
            //Korostaa ensimmäisen laatan
            timerMini = new Timer(1000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    firstTile.highlight();
                    game.refresh();
                }
            });
            //Jos löytyi ensimmäiselle laatalle pari
            if (luckyPair) {
                //Kääntää toisen laatan
                timer2 = new Timer(4000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for (Tile tt : knownTiles) {
                            if ((tt.getId() == firstTile.getId())
                                    && (tt.getPlacement() != firstTile.getPlacement())) {
                                tt.turn();
                            }
                        }
                        game.refresh();
                        game.pairTiles();
                    }
                });
                //Korostaa toisen laatan
                timer2Mini = new Timer(3000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for (Tile tt : knownTiles) {
                            if ((tt.getId() == firstTile.getId())
                                    && (tt.getPlacement() != firstTile.getPlacement())) {
                                tt.highlight();
                            }
                        }
                        game.refresh();
                    }
                });
                //Jos ei tidetä ensimmäiselle laatalle paria, käännetään toinen random
            } else {
                //Kääntää toisen laatan
                timer2 = new Timer(4000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        secondTile.turn();
                        addSeenTile(secondTile);
                        game.refresh();
                        game.pairTiles();
                    }
                });
                //Korostaa toisen laatan
                timer2Mini = new Timer(3000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        secondTile.highlight();
                        game.refresh();
                    }
                });
            }
        }
        //Lopuksi käynnistetään timerit
        timer.setRepeats(false);
        timer2.setRepeats(false);
        timerMini.setRepeats(false);
        timer2Mini.setRepeats(false);
        timer.start();
        timer2.start();
        timerMini.start();
        timer2Mini.start();
    }

    private Double randomDouble() {
        Random r = new Random();
        return r.nextDouble();
    }

    private int randomNumber(int i) {
        Random r = new Random();
        return r.nextInt(i);
    }

    /**
     * Listaa kaikki laatat joita ei tiedetä
     *
     * @return Lista laatoista joita ei tiedetä
     */
    private ArrayList<Tile> getUnseenTiles() {
        ArrayList<Tile> unturned = game.getController().getHiddenTiles();
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
        for (Tile tile : knownTiles) {
            for (Tile tile2 : knownTiles) {
                if ((tile.getPlacement() != tile2.getPlacement()) && (tile.getId() == tile2.getId())) {
                    tp.add(tile);
                    tp.add(tile2);
                    return tp;
                }
            }
        }
        return tp;
    }

    /**
     * Unohtaa kaikki laatat
     */
    public void forgetAll() {
        this.knownTiles = new ArrayList<>();
    }

}
