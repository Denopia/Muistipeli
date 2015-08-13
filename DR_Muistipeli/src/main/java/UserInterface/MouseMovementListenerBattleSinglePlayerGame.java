package UserInterface;

import Controller.BattleTileController;
import Game.GameModes.BattleSinglePlayerGame;
import Tile.BattleTile;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseMovementListenerBattleSinglePlayerGame extends MouseAdapter {

    private BattleSinglePlayerGame game;
    private BattleTileController tileController;

    public MouseMovementListenerBattleSinglePlayerGame(BattleSinglePlayerGame game) {
        this.tileController = game.getController();
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mouseMoved(MouseEvent me) {
        if (game.isPlayersTurn()) {
            if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 550 && me.getY() <= 591) {
                game.highlightHit();
            } else {
                game.unHighlightHit();
            }

            boolean hili = false;
            for (BattleTile tile : tileController.getTiles()) {
                if ((me.getX() - 9) >= (tile.getX() + 4)
                        && (me.getX() - 9) <= (tile.getX() + 80 - 4)
                        && (me.getY() - 38) >= (tile.getY() + 6)
                        && (me.getY() - 38) <= (tile.getY() + 80 - 6)) {
                    tileController.unHighlightAll();
                    tile.highlight();
                    hili = true;
                    break;
                }
            }
            if (!hili) {
                tileController.unHighlightAll();
            }
            game.refresh();
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (game.isPlayersTurn()) {
            if (tileController.getTilesTurned() == 2) {
                return;
            }
            if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 550 && me.getY() <= 591) {
                game.hitOpponent();
            }
            if (me.getButton() == 1) {
                for (BattleTile tile : tileController.getTiles()) {
                    if ((me.getX() - 9) >= (tile.getX() + 4)
                            && (me.getX() - 9) <= (tile.getX() + 80 - 4)
                            && (me.getY() - 38) >= (tile.getY() + 6)
                            && (me.getY() - 38) <= (tile.getY() + 80 - 6)) {
                        tile.turn();
                        break;
                    }
                }
                if (tileController.getTilesTurned() == 2) {
                    game.twoTilesTurned();
                }
            }
            game.refresh();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
