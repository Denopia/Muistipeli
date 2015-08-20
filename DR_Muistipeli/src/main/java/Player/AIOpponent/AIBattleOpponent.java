package Player.AIOpponent;

import Game.GameModes.BattleSinglePlayerGame;
import GameCharacter.GameCharacter;
import Tile.BattleTile;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

/**
 * Yksinpelin vastustaja. Pitää sisällään tietokonevastuksen
 * tiedot ja suorittaa vastuksen vuoron.
 * 
 */
public class AIBattleOpponent {

    private GameCharacter gc;
    private ArrayList<BattleTile> scoredTiles;
    private ArrayList<BattleTile> flippedTiles;
    private BattleSinglePlayerGame game;
    private int difficulty;

    public AIBattleOpponent() {
        this.scoredTiles = new ArrayList<>();
        this.flippedTiles = new ArrayList<>();
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

    public void addScoredPair(BattleTile tile) {
        this.gc.setEnergy(this.gc.getEnergy() + 3);
        this.scoredTiles.add(tile);
    }

    public int getNumberOfPairsScored() {
        return this.scoredTiles.size();
    }

    public void addSeenTile(BattleTile tile) {
        boolean alreadyHere = false;
        for (BattleTile tile2 : flippedTiles) {
            if (tile2.getPlacement() == tile.getPlacement()) {
                alreadyHere = true;
            }
        }
        if (!alreadyHere) {
            flippedTiles.add(tile);
        }
    }

    public void removeSeenTile(BattleTile tile) {
        flippedTiles.remove(tile);
    }

    public Image getPortrait() {
        return this.gc.getCurrentImage();
    }

    public void scorePair() {
        System.out.println("NICE! GOT A PAIR\n");
        setHappy();
    }

    public void failPair() {
        System.out.println("FUG! A MISCLICK!\n");
        setUnhappy();
    }

    public void commentOnPlayersPair() {
        String[] comments = {"HATE THESE LUCKY PLAYERS!", "WHO GETS THIS LUCKY?!", "OF COURSE...", "...", "CAN'T OUTPLAY LUCK"};
        Random r = new Random();
        System.out.println(comments[r.nextInt(4)] + "\n");
    }

    public void setHappy() {
        this.gc.setCurrentImage(this.gc.getYes());
    }

    public void setUnhappy() {
        this.gc.setCurrentImage(this.gc.getNo());
    }

    public void setNeutral() {
        this.gc.setCurrentImage(this.gc.getBasic());
    }

    public void cleanSeenTiles() {
        for (BattleTile til : game.getController().getPairedTiles()) {
            this.flippedTiles.remove(til);
        }
    }

    public void spendTurn() {
        cleanSeenTiles();
        Timer timer;
        final ArrayList<BattleTile> seenPair = checkForPair();
        if (!seenPair.isEmpty()) {
            timer = new Timer(1555, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.out.println("I AM GETTING A PAIR NOW\n");
                    game.getController().getTiles().get(seenPair.get(0).getPlacement()).turn();
                    game.getController().getTiles().get(seenPair.get(1).getPlacement()).turn();
                    game.refresh();
                    game.twoTilesTurned();
                }
            });
        } else {
            timer = new Timer(1555, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.out.println("I AM GUESSING ONE TILE RANDOMLY\n");
                    int random1 = randomNumber(getUnseenTiles().size());
                    BattleTile turnedThisTurn = getUnseenTiles().get(random1);
                    flippedTiles.add(turnedThisTurn);
                    boolean luckyPair = false;
                    turnedThisTurn.turn();
                    for (BattleTile tt : flippedTiles) {
                        if ((tt.getId() == turnedThisTurn.getId()) && (tt.getPlacement() != turnedThisTurn.getPlacement())) {
                            System.out.println("YES! I KNOW A PAIR FOR THIS ONE\n");
                            BattleTile secondTile = tt;
                            luckyPair = true;
                            secondTile.turn();
                        }
                    }
                    if (!luckyPair) {
                        System.out.println("I HAVE TO GUESS ANOTHER TILE RANDOMLY\n");
                        int random2 = random1;
                        while (random1 == random2) {
                            random2 = randomNumber(getUnseenTiles().size());
                        }
                        BattleTile secondTile = getUnseenTiles().get(random2);
                        flippedTiles.add(secondTile);
                        secondTile.turn();

                    }
                    game.refresh();
                    game.twoTilesTurned();
                }
            });
        }
        timer.setRepeats(false);
        timer.start();
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
            for (BattleTile ft : flippedTiles) {
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
        for (BattleTile tile : flippedTiles) {
            for (BattleTile tile2 : flippedTiles) {
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
        this.flippedTiles = new ArrayList<>();
    }

    public void setGame(BattleSinglePlayerGame game) {
        this.game = game;
    }

}
