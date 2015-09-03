package Player.Computer;

import Tile.Tile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

/**
 * Vastusatajan vuoron suorittaja
 */
public class OpponentTurnController {

    private Opponent opponent;

    /**
     * Konstruktori
     *
     * @param op Vastus jonka vuorot suoritetaan
     */
    public OpponentTurnController(Opponent op) {
        opponent = op;
    }

    /**
     * Unohtaa laattoja, ehka
     */
    private void forgetSomeKnownTilesMaybe() {
        opponent.getTileController().cleanKnownTiles(opponent.getGame());
        if (opponent.getDifficulty() == 1) {
            if (opponent.getTileController().doIForget2ez()) {
                opponent.getTileController().forgetSomeTiles2ez();
            }
        } else if (opponent.getDifficulty() == 2) {
            if (opponent.getTileController().doIForgetJustAverage()) {
                opponent.getTileController().forgetSomeTilesJustAverage();
            }
        } else if (opponent.getDifficulty() == 3) {
            if (opponent.getTileController().doIForgetChallenging()) {
                opponent.getTileController().forgetSomeTilesChallenging();
            }
        } else if (opponent.getDifficulty() == 4) {
            if (opponent.getTileController().doIForgetImpossible()) {
                opponent.getTileController().forgetSomeTilesImpossible();
            }
        }
    }

    /**
     * Kuinka vastustaja kayttaa vuoronsa
     */
    public void spendTurn() {
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int slowDown = 0;
                forgetSomeKnownTilesMaybe();
                if (doIHit()) {
                    opponent.getGame().getAController().hitPlayer();
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

    /**
     * Paattaa lyoko vastustaja pelaajaa vuoron alussa
     *
     * @return True jos lyo, false jos ei
     */
    private boolean doIHit() {
        return true;
    }

    /**
     * Paattaa kayttaako vastustaja taitoa vuoron alussa
     *
     * @return True jos kayttaa, false jos ei
     */
    private boolean doIUseAbility() {
        return false;
    }

    /**
     * Vastustaja kääntää kaksi laattaa
     *
     * @param slowDown Kuinka paljon timerit odottaa lisää
     */
    private void turnTwoTiles(int slowDown) {
        Timer timer;
        Timer timerMini;
        Timer timer2;
        Timer timer2Mini;

        //Katsotaan onko tiedossa paria joka voitaisiin kääntää
        final ArrayList<Tile> seenPair = opponent.getTileController().checkForPair();
        //Jos tiedetään pari, käännetään se
        if (!seenPair.isEmpty()) {
            //Kääntää ensimmäisen laatan
            timer = new Timer(2000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    opponent.getGame().getTController().getTiles().get(seenPair.get(0).getPlacement()).turn();
                }
            });
            //Kääntää toisen laatan
            timer2 = new Timer(4000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    opponent.getGame().getTController().getTiles().get(seenPair.get(1).getPlacement()).turn();
                    opponent.getGame().pairTiles();
                }
            });
            //Korostaa ensimmäisen laatan
            timerMini = new Timer(1000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    opponent.getGame().getTController().getTiles().get(seenPair.get(0).getPlacement()).highlight();
                }
            });
            //Korostaa toisen laatan
            timer2Mini = new Timer(3000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    opponent.getGame().getTController().getTiles().get(seenPair.get(1).getPlacement()).highlight();
                }
            });
        } else {
            //Jos ei tiedetä paria niin joudutaan arvamaan aluksi yksi laatta sattumalta
            final Tile firstTile;
            final Tile secondTile;

            int random1 = randomNumber(opponent.getTileController().getUnseenTiles(opponent.getGame()).size());
            firstTile = opponent.getTileController().getUnseenTiles(opponent.getGame()).get(random1);
            opponent.getTileController().addKnownTile(firstTile);
            boolean luckyPair = false;
            for (Tile nt : opponent.getTileController().getKnownTiles()) {
                if (nt.getEffect().equals(firstTile.getEffect())
                        && nt.getPlacement() != firstTile.getPlacement()) {
                    luckyPair = true;
                }
            }
            //Luodaan varalle toinen random laatta, jos ensimmäiselle ei tiedetä paria
            int random2 = random1;
            while (random1 == random2) {
                random2 = randomNumber(opponent.getTileController().getUnseenTiles(opponent.getGame()).size());
            }
            secondTile = opponent.getTileController().getUnseenTiles(opponent.getGame()).get(random2);
            //Kääntää ensimmäisen laatan
            timer = new Timer(2000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    firstTile.turn();
                }
            });
            //Korostaa ensimmäisen laatan
            timerMini = new Timer(1000 + slowDown, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    firstTile.highlight();
                }
            });
            //Jos löytyi ensimmäiselle laatalle pari
            if (luckyPair) {
                //Kääntää toisen laatan joka on jo nähtyjen laattojen listalla
                timer2 = new Timer(4000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for (Tile tt : opponent.getTileController().getKnownTiles()) {
                            if ((tt.getEffect().equals(firstTile.getEffect()))
                                    && (tt.getPlacement() != firstTile.getPlacement())) {
                                tt.turn();
                            }
                        }
                        opponent.getGame().pairTiles();
                    }
                });
                //Korostaa toisen laatan
                timer2Mini = new Timer(3000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for (Tile tt : opponent.getTileController().getKnownTiles()) {
                            if ((tt.getEffect().equals(firstTile.getEffect()))
                                    && (tt.getPlacement() != firstTile.getPlacement())) {
                                tt.highlight();
                            }
                        }
                    }
                }
                );
                //Jos ei tidetä ensimmäiselle laatalle paria, käännetään toinen random laatta
            } else {
                //Kääntää toisen random dlaatan
                timer2 = new Timer(4000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        secondTile.turn();
                        opponent.getTileController().addKnownTile(secondTile);
                        opponent.getGame().pairTiles();
                    }
                });
                //Korostaa toisen laatan
                timer2Mini = new Timer(3000 + slowDown, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        secondTile.highlight();
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

    /**
     * Palauttaa random luvun valilta 0-i
     *
     * @param i Luku joka kertoo valin rajan
     * @return Random luku
     */
    private int randomNumber(int i) {
        Random r = new Random();
        return r.nextInt(i);
    }
}
