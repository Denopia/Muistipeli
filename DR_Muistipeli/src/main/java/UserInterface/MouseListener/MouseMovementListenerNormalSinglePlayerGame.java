package UserInterface.MouseListener;

import TileController.NormalTileController;
import Tile.NormalTile;
import Game.GameModes.NormalSinglePlayerGame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Kuuntelee hiiren liikettä ja klikkauksia.
 * Suorittaa metodeja niiden perusteella.
 * 
 */
public class MouseMovementListenerNormalSinglePlayerGame extends MouseAdapter {

    private NormalSinglePlayerGame game;
    private NormalTileController tileController;

    public MouseMovementListenerNormalSinglePlayerGame(NormalSinglePlayerGame game) {
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
            for (NormalTile tile : tileController.getTiles()) {
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
                for (NormalTile tile : tileController.getTiles()) {
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
