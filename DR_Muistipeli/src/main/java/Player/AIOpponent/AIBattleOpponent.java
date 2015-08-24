package Player.AIOpponent;

import Game.GameModes.BattleSinglePlayerGame;
import GameCharacter.GameCharacter;
import Tile.BattleTile;
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
 */
public class AIBattleOpponent {

    private GameCharacter gc;
    private ArrayList<BattleTile> scoredTiles;
    private ArrayList<BattleTile> knownTiles;
    private BattleSinglePlayerGame game;
    private int difficulty;
    private boolean hitThisTurn;

    public AIBattleOpponent() {
        this.scoredTiles = new ArrayList<>();
        this.knownTiles = new ArrayList<>();
        hitThisTurn = false;
    }

    public void setDifficulty(int i) {
        this.difficulty = i;
    }

    public void setCharacter(GameCharacter gc) {
        this.gc = gc;
    }

    public GameCharacter getCharacter() {
        return this.gc;
    }

    public void setHitThisTurnTrue() {
        this.hitThisTurn = true;
    }

    public void setHitThisTurnFalse() {
        this.hitThisTurn = false;
    }

    public boolean getHitThisTurn() {
        return this.hitThisTurn;
    }

    public void addScoredPair(BattleTile tile) {
        this.gc.setEnergy(this.gc.getEnergy() + 1);
        this.scoredTiles.add(tile);
    }

    public int getNumberOfPairsScored() {
        return this.scoredTiles.size();
    }

    public void addSeenTile(BattleTile tile) {
        boolean alreadyHere = false;
        for (BattleTile tile2 : knownTiles) {
            if (tile2.getPlacement() == tile.getPlacement()) {
                alreadyHere = true;
            }
        }
        if (!alreadyHere) {
            knownTiles.add(tile);
        }
    }

    public void removeSeenTile(BattleTile tile) {
        knownTiles.remove(tile);
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
        this.gc.setHappy();
    }

    public void setUnhappy() {
        this.gc.setUnhappy();
    }

    public void setNeutral() {
        this.gc.setNeutral();
    }

    public void setTakeDamage() {
        this.gc.setTakeDamage();
    }

    public void setGiveDamage() {
        this.gc.setGiveDamage();
    }

    public void cleanSeenTiles() {
        for (BattleTile til : game.getController().getPairedTiles()) {
            this.knownTiles.remove(til);
        }
    }

    public void forgetSomeTiles2ez() {
        System.out.println("FORGOT ALL");
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
            System.out.println("REMOVED ONE");
        }
        System.out.println("----------------");
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
            System.out.println("REMOVED ONE");
        }
        System.out.println("----------------");
    }

    public void forgetSomeTilesImpossible() {
        System.out.println("NEVER FORGET");
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

    public void turnTwoTiles(int slowDown) {
        Timer timer;
        Timer timerMini;
        Timer timer2;
        Timer timer2Mini;

        final ArrayList<BattleTile> seenPair = checkForPair();
        if (!seenPair.isEmpty()) {
            timer = new Timer(2000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    game.getController().getTiles().get(seenPair.get(0).getPlacement()).turn();
                    game.refresh();
                }
            });
            timer2 = new Timer(4000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    game.getController().getTiles().get(seenPair.get(1).getPlacement()).turn();
                    game.refresh();
                    game.pairTiles();
                }
            });
            timerMini = new Timer(1000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    game.getController().getTiles().get(seenPair.get(0).getPlacement()).highlight();
                    game.refresh();
                }
            });
            timer2Mini = new Timer(3000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    game.getController().getTiles().get(seenPair.get(1).getPlacement()).highlight();
                    game.refresh();
                }
            });
        } else {
            final BattleTile firstTile;
            final BattleTile secondTile;
            final BattleTile thirdTile;
            BattleTile ttt;
            int random1 = randomNumber(getUnseenTiles().size());
            firstTile = getUnseenTiles().get(random1);
            knownTiles.add(firstTile);
            boolean luckyPair = false;
            int random2 = random1;
            while (random1 == random2) {
                random2 = randomNumber(getUnseenTiles().size());
            }
            secondTile = getUnseenTiles().get(random2);
            timer = new Timer(2000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    firstTile.turn();
                    game.refresh();
                }
            });
            timerMini = new Timer(1000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    firstTile.highlight();
                    game.refresh();
                }
            });
            if (luckyPair) {
                timer2 = new Timer(4000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for (BattleTile tt : knownTiles) {
                            if ((tt.getId() == firstTile.getId())
                                    && (tt.getPlacement() != firstTile.getPlacement())) {
                                tt.turn();
                            }
                        }
                        game.refresh();
                        game.pairTiles();
                    }
                });
                timer2Mini = new Timer(3000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for (BattleTile tt : knownTiles) {
                            if ((tt.getId() == firstTile.getId())
                                    && (tt.getPlacement() != firstTile.getPlacement())) {
                                tt.highlight();
                            }
                        }
                        game.refresh();
                    }
                });
            } else {
                timer2 = new Timer(4000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        secondTile.turn();
                        game.refresh();
                        game.pairTiles();
                    }
                });
                timer2Mini = new Timer(3000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        secondTile.highlight();
                        game.refresh();
                    }
                });
            }
        }
        timer.setRepeats(false);
        timer2.setRepeats(false);
        timerMini.setRepeats(false);
        timer2Mini.setRepeats(false);
        timer.start();
        timer2.start();
        timerMini.start();
        timer2Mini.start();
    }

    public int randomNumber(int i) {
        Random r = new Random();
        return r.nextInt(i);
    }

    public ArrayList<BattleTile> getUnseenTiles() {
        ArrayList<BattleTile> unturned = game.getController().getHiddenTiles();
        ArrayList<BattleTile> unseen = new ArrayList<>();
        for (BattleTile ut : unturned) {
            boolean notSeen = true;
            for (BattleTile ft : knownTiles) {
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

    public ArrayList<BattleTile> checkForPair() {
        ArrayList<BattleTile> tp = new ArrayList<>();
        for (BattleTile tile : knownTiles) {
            for (BattleTile tile2 : knownTiles) {
                if ((tile.getPlacement() != tile2.getPlacement()) && (tile.getId() == tile2.getId())) {
                    tp.add(tile);
                    tp.add(tile2);
                    return tp;
                }
            }
        }
        return tp;
    }

    public void forgetAll() {
        this.knownTiles = new ArrayList<>();
    }

    public void setGame(BattleSinglePlayerGame game) {
        this.game = game;
    }

}
