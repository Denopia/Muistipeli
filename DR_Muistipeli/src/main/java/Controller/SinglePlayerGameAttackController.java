package Controller;

import Game.GameModes.SinglePlayerGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Suorittaa yksinpelin hyokkaykset
 */
public class SinglePlayerGameAttackController {

    private SinglePlayerGame game;

    public SinglePlayerGameAttackController(SinglePlayerGame game) {
        this.game = game;
    }

    /**
     * Lyo vastustajaa jos pelaajalla on tarpeeksi resursseja eika talla
     * vuorolla ole viela lyoty
     */
    public void hitOpponent() {
        if (!game.getPlayer().getHitThisTurn()) {
            if (game.getPlayer().getCharacter().getEnergy() > 0) {
                game.getPlayer().getCharacter().setEnergy(game.getPlayer().getCharacter().getEnergy() - 1);
                game.getOpponent().getCharacter().setHp(game.getOpponent().getCharacter().getHp() - 1);
                game.getOpponent().setTakeDamage();
                game.getPlayer().setGiveDamage();
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        game.getPlayer().setNeutral();
                        game.getOpponent().setNeutral();
                        game.endTurnCheck();
                        game.refresh();
                    }
                });
                timer.setRepeats(false);
                timer.start();
                game.getPlayer().setHitThisTurnTrue();
            }
        }
    }

    /**
     * Lyo pelaajaa jos vastustajalla on tarpeeksi resursseja eika talla
     * vuorolla ole viela lyoty
     */
    public void hitPlayer() {
        if (!game.getOpponent().getHitThisTurn()) {
            if (game.getOpponent().getCharacter().getEnergy() > 0) {
                game.getOpponent().getCharacter().setEnergy(game.getOpponent().getCharacter().getEnergy() - 1);
                game.getPlayer().getCharacter().setHp(game.getPlayer().getCharacter().getHp() - 1);
                game.getPlayer().setTakeDamage();
                game.getOpponent().setGiveDamage();
                game.refresh();
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        game.getOpponent().setNeutral();
                        game.getPlayer().setNeutral();
                        game.endTurnCheck();
                        game.refresh();
                    }
                });
                timer.setRepeats(false);
                timer.start();
                game.getOpponent().setHitThisTurnTrue();
            }
        }
    }

}
