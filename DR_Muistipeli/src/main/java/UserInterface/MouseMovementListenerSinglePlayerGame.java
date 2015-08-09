package UserInterface;

import Controller.TileController;
import Tile.Tile;
import Game.SinglePlayerGame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseMovementListenerSinglePlayerGame extends MouseAdapter {

    private SinglePlayerGame game;
    private TileController tileController;

    public MouseMovementListenerSinglePlayerGame(SinglePlayerGame game) {
        this.tileController = game.getController();
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mouseMoved(MouseEvent me) {
        if (game.isPlayersTurn()) {
            boolean hili = false;
            for (Tile tile : tileController.getTiles()) {
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
            if (me.getButton() == 1) {
                for (Tile tile : tileController.getTiles()) {
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
