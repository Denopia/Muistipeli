package UserInterface.MouseListener;

import Game.GamePreparation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Kuuntelee Preparation olion piirtoalustalla osoittimen liiketta
 */
public class MouseListenerPreparation extends MouseAdapter {

    private GamePreparation gp;

    /**
     * Konstruktori
     *
     * @param gp Valmistelu olio jota manipuloidaan
     */
    public MouseListenerPreparation(GamePreparation gp) {
        this.gp = gp;
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        gp.getHController().unHighlightAll();
        if ((me.getX()) >= (119)
                && (me.getX()) <= (119 + 26)
                && (me.getY()) >= (287)
                && (me.getY()) <= (287 + 50)) {
            gp.getHController().highlightA1();
        } else if ((me.getX()) >= (377)
                && (me.getX()) <= (377 + 26)
                && (me.getY()) >= (287)
                && (me.getY()) <= (287 + 50)) {
            gp.getHController().highlightA2();
        } else if ((me.getX()) >= (603)
                && (me.getX()) <= (603 + 26)
                && (me.getY()) >= (287)
                && (me.getY()) <= (287 + 50)) {
            gp.getHController().highlightA3();
        } else if ((me.getX()) >= (861)
                && (me.getX()) <= (861 + 26)
                && (me.getY()) >= (287)
                && (me.getY()) <= (287 + 50)) {
            gp.getHController().highlightA4();
        } else if ((me.getX()) >= (267)
                && (me.getX()) <= (267 + 114)
                && (me.getY()) >= (647)
                && (me.getY()) <= (647 + 32)) {
            gp.getHController().highlightD1();
        } else if ((me.getX()) >= (386)
                && (me.getX()) <= (386 + 114)
                && (me.getY()) >= (647)
                && (me.getY()) <= (647 + 32)) {
            gp.getHController().highlightD2();
        } else if ((me.getX()) >= (505)
                && (me.getX()) <= (505 + 114)
                && (me.getY()) >= (647)
                && (me.getY()) <= (647 + 32)) {
            gp.getHController().highlightD3();
        } else if ((me.getX()) >= (624)
                && (me.getX()) <= (624 + 114)
                && (me.getY()) >= (647)
                && (me.getY()) <= (647 + 32)) {
            gp.getHController().highlightD4();
        } else if ((me.getX()) >= (35)
                && (me.getX()) <= (35 + 176)
                && (me.getY()) >= (618)
                && (me.getY()) <= (618 + 54)) {
            gp.getHController().highlightMenu();
        } else if ((me.getX()) >= (795)
                && (me.getX()) <= (795 + 176)
                && (me.getY()) >= (618)
                && (me.getY()) <= (618 + 54)) {
            gp.getHController().highlightStart();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == 1) {
            if ((me.getX()) >= (119)
                    && (me.getX()) <= (119 + 26)
                    && (me.getY()) >= (287)
                    && (me.getY()) <= (287 + 50)) {
                gp.previousPlayerCharacter();
            } else if ((me.getX()) >= (377)
                    && (me.getX()) <= (377 + 26)
                    && (me.getY()) >= (287)
                    && (me.getY()) <= (287 + 50)) {
                gp.nextPlayerCharacter();
            } else if ((me.getX()) >= (603)
                    && (me.getX()) <= (603 + 26)
                    && (me.getY()) >= (287)
                    && (me.getY()) <= (287 + 50)) {
                gp.previousOpponentCharacter();
            } else if ((me.getX()) >= (861)
                    && (me.getX()) <= (861 + 26)
                    && (me.getY()) >= (287)
                    && (me.getY()) <= (287 + 50)) {
                gp.nextOpponentCharacter();
            } else if ((me.getX()) >= (267)
                    && (me.getX()) <= (267 + 114)
                    && (me.getY()) >= (647)
                    && (me.getY()) <= (647 + 32)) {
                gp.setDifficulty(1);
            } else if ((me.getX()) >= (386)
                    && (me.getX()) <= (386 + 114)
                    && (me.getY()) >= (647)
                    && (me.getY()) <= (647 + 32)) {
                gp.setDifficulty(2);
            } else if ((me.getX()) >= (505)
                    && (me.getX()) <= (505 + 114)
                    && (me.getY()) >= (647)
                    && (me.getY()) <= (647 + 32)) {
                gp.setDifficulty(3);
            } else if ((me.getX()) >= (624)
                    && (me.getX()) <= (624 + 114)
                    && (me.getY()) >= (647)
                    && (me.getY()) <= (647 + 32)) {
                gp.setDifficulty(4);
            } else if ((me.getX()) >= (35)
                    && (me.getX()) <= (35 + 176)
                    && (me.getY()) >= (618)
                    && (me.getY()) <= (618 + 54)) {
                gp.backToMenu();
            } else if ((me.getX()) >= (795)
                    && (me.getX()) <= (795 + 176)
                    && (me.getY()) >= (618)
                    && (me.getY()) <= (618 + 54)) {
                gp.startGame();
            }
        }
    }
}
