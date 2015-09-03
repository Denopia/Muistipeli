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

    /**
     * Konstruktori asettaa kontrollerille pelin jota se kasittelee
     *
     * @param game Peli jota halutaan kasitella
     */
    public SinglePlayerGameAttackController(SinglePlayerGame game) {
        this.game = game;
    }

    /**
     * Lyo vastustajaa jos pelaajalla on tarpeeksi resursseja ja
     * lyontivuoro jaljella
     */
    public void hitOpponent() {
        if (game.getPlayer().getHitsLeft() > 0) {
            if (game.getPlayer().getCharacter().getEnergy() > 0) {
                game.getPlayer().getCharacter().setEnergy(game.getPlayer().getCharacter().getEnergy() - 1);
                game.getOpponent().getCharacter().setHp(game.getOpponent().getCharacter().getHp() - 1);
                game.getOpponent().getCharacter().setTakeDamage();
                game.getPlayer().getCharacter().setGiveDamage();
                game.getPlayer().setNeutralStateFalse();
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        game.getPlayer().getCharacter().setNeutral();
                        game.getPlayer().setNeutralStateTrue();
                        game.getOpponent().getCharacter().setNeutral();
                        game.getOpponent().setNeutralStateTrue();
                        game.endTurnCheck();
                    }
                });
                game.getPlayer().removeHit();
                timer.setRepeats(false);
                timer.start();

            }
        }
    }

    /**
     * Lyo pelaajaa jos vastustajalla on tarpeeksi resursseja ja
     * lyontivuoro jaljella
     */
    public void hitPlayer() {
        if (game.getOpponent().getHitsLeft() > 0) {
            if (game.getOpponent().getCharacter().getEnergy() > 0) {
                game.getOpponent().getCharacter().setEnergy(game.getOpponent().getCharacter().getEnergy() - 1);
                game.getPlayer().getCharacter().setHp(game.getPlayer().getCharacter().getHp() - 1);
                game.getPlayer().getCharacter().setTakeDamage();
                game.getPlayer().setNeutralStateFalse();
                game.getOpponent().getCharacter().setGiveDamage();
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        game.getOpponent().getCharacter().setNeutral();
                        game.getOpponent().setNeutralStateTrue();
                        game.getPlayer().getCharacter().setNeutral();
                        game.getPlayer().setNeutralStateTrue();
                        game.endTurnCheck();
                    }
                });
                game.getOpponent().removeHit();
                timer.setRepeats(false);
                timer.start();

            }
        }
    }
}
