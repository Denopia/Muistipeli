package UserInterface.MouseListener;

import Game.GamePreparation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Kuuntelee hiiren liikettä ja klikkauksia. Suorittaa metodeja niiden
 * perusteella.
 *
 */
public class MouseListenerPreparation extends MouseAdapter {

    private GamePreparation gp;

    public MouseListenerPreparation(GamePreparation gp) {
        this.gp = gp;
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        gp.getHController().unHighlightAll();
        if ((me.getX()) >= (119 + 9)
                && (me.getX()) <= (119 + 9 + 26)
                && (me.getY()) >= (287 + 38)
                && (me.getY()) <= (287 + 38 + 50)) {
            gp.getHController().highlightA1();
        } else if ((me.getX()) >= (377 + 9)
                && (me.getX()) <= (377 + 9 + 26)
                && (me.getY()) >= (287 + 38)
                && (me.getY()) <= (287 + 38 + 50)) {
            gp.getHController().highlightA2();
        } else if ((me.getX()) >= (603 + 9)
                && (me.getX()) <= (603 + 9 + 26)
                && (me.getY()) >= (287 + 38)
                && (me.getY()) <= (287 + 38 + 50)) {
            gp.getHController().highlightA3();
        } else if ((me.getX()) >= (861 + 9)
                && (me.getX()) <= (861 + 9 + 26)
                && (me.getY()) >= (287 + 38)
                && (me.getY()) <= (287 + 38 + 50)) {
            gp.getHController().highlightA4();
        } else if ((me.getX()) >= (267 + 9)
                && (me.getX()) <= (267 + 9 + 114)
                && (me.getY()) >= (647 + 38)
                && (me.getY()) <= (647 + 38 + 32)) {
            gp.getHController().highlightD1();
        } else if ((me.getX()) >= (386 + 9)
                && (me.getX()) <= (386 + 9 + 114)
                && (me.getY()) >= (647 + 38)
                && (me.getY()) <= (647 + 38 + 32)) {
            gp.getHController().highlightD2();
        } else if ((me.getX()) >= (505 + 9)
                && (me.getX()) <= (505 + 9 + 114)
                && (me.getY()) >= (647 + 38)
                && (me.getY()) <= (647 + 38 + 32)) {
            gp.getHController().highlightD3();
        } else if ((me.getX()) >= (624 + 9)
                && (me.getX()) <= (624 + 9 + 114)
                && (me.getY()) >= (647 + 38)
                && (me.getY()) <= (647 + 38 + 32)) {
            gp.getHController().highlightD4();
        } else if ((me.getX()) >= (35 + 9)
                && (me.getX()) <= (35 + 9 + 176)
                && (me.getY()) >= (618 + 38)
                && (me.getY()) <= (618 + 38 + 54)) {
            gp.getHController().highlightMenu();
        } else if ((me.getX()) >= (795 + 9)
                && (me.getX()) <= (795 + 9 + 176)
                && (me.getY()) >= (618 + 38)
                && (me.getY()) <= (618 + 38 + 54)) {
            gp.getHController().highlightStart();
        }
        gp.refresh();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == 1) {
            if ((me.getX()) >= (119 + 9)
                    && (me.getX()) <= (119 + 9 + 26)
                    && (me.getY()) >= (287 + 38)
                    && (me.getY()) <= (287 + 38 + 50)) {
                gp.previousPlayerCharacter();
            } else if ((me.getX()) >= (377 + 9)
                    && (me.getX()) <= (377 + 9 + 26)
                    && (me.getY()) >= (287 + 38)
                    && (me.getY()) <= (287 + 38 + 50)) {
                gp.nextPlayerCharacter();
            } else if ((me.getX()) >= (603 + 9)
                    && (me.getX()) <= (603 + 9 + 26)
                    && (me.getY()) >= (287 + 38)
                    && (me.getY()) <= (287 + 38 + 50)) {
                gp.previousOpponentCharacter();
            } else if ((me.getX()) >= (861 + 9)
                    && (me.getX()) <= (861 + 9 + 26)
                    && (me.getY()) >= (287 + 38)
                    && (me.getY()) <= (287 + 38 + 50)) {
                gp.nextOpponentCharacter();
            } else if ((me.getX()) >= (267 + 9)
                    && (me.getX()) <= (267 + 9 + 114)
                    && (me.getY()) >= (647 + 38)
                    && (me.getY()) <= (647 + 38 + 32)) {
                gp.setDifficulty(1);
            } else if ((me.getX()) >= (386 + 9)
                    && (me.getX()) <= (386 + 9 + 114)
                    && (me.getY()) >= (647 + 38)
                    && (me.getY()) <= (647 + 38 + 32)) {
                gp.setDifficulty(2);
            } else if ((me.getX()) >= (505 + 9)
                    && (me.getX()) <= (505 + 9 + 114)
                    && (me.getY()) >= (647 + 38)
                    && (me.getY()) <= (647 + 38 + 32)) {
                gp.setDifficulty(3);
            } else if ((me.getX()) >= (624 + 9)
                    && (me.getX()) <= (624 + 9 + 114)
                    && (me.getY()) >= (647 + 38)
                    && (me.getY()) <= (647 + 38 + 32)) {
                gp.setDifficulty(4);
            } else if ((me.getX()) >= (35 + 9)
                    && (me.getX()) <= (35 + 9 + 176)
                    && (me.getY()) >= (618 + 38)
                    && (me.getY()) <= (618 + 38 + 54)) {
                gp.backToMenu();
            } else if ((me.getX()) >= (795 + 9)
                    && (me.getX()) <= (795 + 9 + 176)
                    && (me.getY()) >= (618 + 38)
                    && (me.getY()) <= (618 + 38 + 54)) {
                gp.startGame();
            }
            gp.refresh();
        }
    }
}
