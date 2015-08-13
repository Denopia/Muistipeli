package Player;

import Game.NormalSinglePlayerGame;
import GameCharacter.GameCharacter;
import GameCharacter.PBot;
import Tile.NormalTile;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class NormalOpponentAI {

    private GameCharacter gc;
    private ArrayList<NormalTile> scoredTiles;
    private ArrayList<NormalTile> flippedTiles;
    private NormalSinglePlayerGame game;

    public NormalOpponentAI(NormalSinglePlayerGame game) {
        this.gc = new PBot("");
        this.game = game;
        this.scoredTiles = new ArrayList<NormalTile>();
        this.flippedTiles = new ArrayList<NormalTile>();
    }

    public void addScoredPair(NormalTile tile) {
        this.scoredTiles.add(tile);
    }
    
    public int getNumberOfPairsScored() {
        return this.scoredTiles.size();
    }

    public void addSeenTile(NormalTile tile) {
        boolean alreadyHere = false;
        for (NormalTile tile2 : flippedTiles) {
            if (tile2.getPlacement() == tile.getPlacement()) {
                alreadyHere = true;
            }
        }
        if (!alreadyHere) {
            flippedTiles.add(tile);
        }
    }

    public void removeSeenTile(NormalTile tile) {
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
        for (NormalTile til : game.getController().getPairedTiles()) {
            this.flippedTiles.remove(til);
        }
    }

    public void spendTurn() {
        cleanSeenTiles();
//        System.out.println("I KNOW WHAT IS BEHIND TILES: ");
//        for (Tile t : flippedTiles) {
//            System.out.println(t.getPlacement());
//        }
        Timer timer;
        final ArrayList<NormalTile> seenPair = checkForPair();
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
                    NormalTile turnedThisTurn = getUnseenTiles().get(random1);
                    flippedTiles.add(turnedThisTurn);
                    boolean luckyPair = false;
                    turnedThisTurn.turn();
                    for (NormalTile tt : flippedTiles) {
                        if ((tt.getId() == turnedThisTurn.getId()) && (tt.getPlacement() != turnedThisTurn.getPlacement())) {
                            System.out.println("YES! I KNOW A PAIR FOR THIS ONE\n");
                            NormalTile secondTile = tt;
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
                        NormalTile secondTile = getUnseenTiles().get(random2);
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

    public ArrayList<NormalTile> getUnseenTiles() {
        ArrayList<NormalTile> unturned = game.getController().getHiddenTiles();
        ArrayList<NormalTile> unseen = new ArrayList<>();
        for (NormalTile ut : unturned) {
            boolean notSeen = true;
            for (NormalTile ft : flippedTiles) {
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

    public ArrayList<NormalTile> checkForPair() {
        ArrayList<NormalTile> tp = new ArrayList<>();
        for (NormalTile tile : flippedTiles) {
            for (NormalTile tile2 : flippedTiles) {
                if ((tile.getPlacement() != tile2.getPlacement()) && (tile.getId() == tile2.getId())) {
                    tp.add(tile);
                    tp.add(tile2);
                    return tp;
                }
            }
        }
        return tp;
    }

}
