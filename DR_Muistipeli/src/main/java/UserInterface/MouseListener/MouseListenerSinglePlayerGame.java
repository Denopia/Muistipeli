package UserInterface.MouseListener;

import Game.GameModes.SinglePlayerGame;
import Tile.Tile;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Kuuntelee Yksinpeli olion piirtoalustalla osoittimen liiketta
 */
public class MouseListenerSinglePlayerGame extends MouseAdapter {

    private SinglePlayerGame game;

    /**
     * Konstruktori
     *
     * @param game Peli jota manipuloidaan
     */
    public MouseListenerSinglePlayerGame(SinglePlayerGame game) {
        this.game = game;
    }

    @Override
    public void mouseMoved(MouseEvent me) {

        //Jos ei pelaajan vuoro, ei tehda mitaan
        if (!game.isPlayersTurn()) {
            return;
        }
        //Poistaa kaikki korostukset
        game.getHController().unHighlightAll();
        game.getTController().unHighlightAll();
        //Jos hiiri luovutusnapin paalla korostetaan se
        if (me.getX() >= 462 - 9 && me.getX() <= 561 - 9 && me.getY() >= 714 - 38 && me.getY() <= 749 - 38) {
            game.getHController().highlightExit();
            return;
        }
        //Jos hiiri toimintanapin päällä, korostetaan se
        if (me.getX() >= 76 - 9 && me.getX() <= 177 - 9 && me.getY() >= 550 - 38 && me.getY() <= 591 - 38) {
            game.getHController().highlightHit();
            return;
        } else if (me.getX() >= 76 - 9 && me.getX() <= 177 - 9 && me.getY() >= 610 - 38 && me.getY() <= 651 - 38) {
            game.getHController().highlightSkill();
            return;
        }

        //Laitetaan muistiin kaikki rivit jotka hiiri korostaa jos taito valittuna ja hiiri laattojen päällä
        if (game.getPlayer().getSkillSelected()) {
            if (me.getX() >= 259 - 9 && me.getX() <= 765 - 9 && me.getY() >= 185 - 38 && me.getY() <= 266 - 38) {
                game.getHController().setHorRowTrue(1);
            } else if (me.getX() >= 259 - 9 && me.getX() <= 765 - 9 && me.getY() >= 270 - 38 && me.getY() <= 351 - 38) {
                game.getHController().setHorRowTrue(2);
            } else if (me.getX() >= 259 - 9 && me.getX() <= 765 - 9 && me.getY() >= 355 - 38 && me.getY() <= 436 - 38) {
                game.getHController().setHorRowTrue(3);
            } else if (me.getX() >= 259 - 9 && me.getX() <= 765 - 9 && me.getY() >= 440 - 38 && me.getY() <= 521 - 38) {
                game.getHController().setHorRowTrue(4);
            } else if (me.getX() >= 259 - 9 && me.getX() <= 765 - 9 && me.getY() >= 525 - 38 && me.getY() <= 606 - 38) {
                game.getHController().setHorRowTrue(5);
            } else if (me.getX() >= 259 - 9 && me.getX() <= 765 - 9 && me.getY() >= 610 - 38 && me.getY() <= 691 - 38) {
                game.getHController().setHorRowTrue(6);
            } else {
                game.getHController().setHorRowsFalse();
            }
            if (me.getX() >= 259 - 9 && me.getX() <= 259 + 83 - 9 && me.getY() >= 185 - 38 && me.getY() <= 691 - 38) {
                game.getHController().setVerRowTrue(1);
            } else if (me.getX() >= 259 - 9 + 85 && me.getX() <= 259 - 9 + 83 + 85 && me.getY() >= 185 - 38 && me.getY() <= 691 - 38) {
                game.getHController().setVerRowTrue(2);
            } else if (me.getX() >= 259 - 9 + 85 + 85 && me.getX() <= 259 - 9 + 83 + 85 + 85 && me.getY() >= 185 - 38 && me.getY() <= 691 - 38) {
                game.getHController().setVerRowTrue(3);
            } else if (me.getX() >= 259 - 9 + 85 + 85 + 85 && me.getX() <= 259 - 9 + 83 + 85 + 85 + 85 && me.getY() >= 185 - 38 && me.getY() <= 691 - 38) {
                game.getHController().setVerRowTrue(4);
            } else if (me.getX() >= 259 - 9 + 85 + 85 + 85 + 85 && me.getX() <= 259 - 9 + 83 + 85 + 85 + 85 + 85 && me.getY() >= 185 - 38 && me.getY() <= 691 - 38) {
                game.getHController().setVerRowTrue(5);
            } else if (me.getX() >= 259 - 9 + 85 + 85 + 85 + 85 + 85 && me.getX() <= 259 - 9 + 83 + 85 + 85 + 85 + 85 + 85 && me.getY() >= 185 - 38 && me.getY() <= 691 - 38) {
                game.getHController().setVerRowTrue(6);
            } else {
                game.getHController().setVerRowsFalse();
            }
            return;
        }

        //Jos hiiri laatan paalla ja taito ei aktiivicena, korostetaan se 
        for (Tile tile : game.getTController().getTiles()) {
            if ((me.getX()) >= (tile.getX() + 4)
                    && (me.getX()) <= (tile.getX() + 80 - 4)
                    && (me.getY()) >= (tile.getY() + 6)
                    && (me.getY()) <= (tile.getY() + 80 - 6)) {
                tile.highlight();
                return;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

        //Jos ei pelaajan vuoro, ei tehdä mitään
        if (!game.isPlayersTurn() || !game.getPlayer().getNeutralState() || !game.getOpponent().getNeutralState()) {
            return;
        }
        //Jos painetaan luovutusnappia, lopetetaan peli
        if (me.getButton() == 1 && me.getX() >= 462 - 9 && me.getX() <= 561 - 9 && me.getY() >= 714 - 38 && me.getY() <= 749 - 38) {
            game.backToMenu();
        }
        //Jos laattoja on käännetty 2 tai ennemmän ei käännetä ylimääräisiä ennen kuin tilanne on selvitetty
        if (game.getTController().getTilesTurned() > 1) {
            return;
        }
        //Jos pelaajan taito on valittuna ja painetaan pelilaudalta jotain riviä, pelaaja käyttää taidon
        if (game.getPlayer().getSkillSelected()) {
            if (me.getButton() == 1) {
                if (me.getX() >= 76 - 9 && me.getX() <= 177 - 9 && me.getY() >= 610 - 38 && me.getY() <= 651 - 38) {
                    game.getPlayer().deselectSkill();
                } else {
                    game.playerUseSkill();
                }
                //Jos right klikataan mistä vaan, otetaan taito pois aktiivisesta tilasta
            } else if (me.getButton() == 3) {
                game.getHController().unHighlightAll();
                game.getPlayer().deselectSkill();
            }
            return;
        }
        if (me.getX() >= 76 - 9 && me.getX() <= 177 - 9 && me.getY() >= 550 - 38 && me.getY() <= 591 - 38 && me.getButton() == 1 && !game.getTController().tileIsTurned()) {
            game.getAController().hitOpponent();
            return;
        }
        if (me.getX() >= 76 - 9 && me.getX() <= 177 - 9 && me.getY() >= 610 - 38 && me.getY() <= 651 - 38 && me.getButton() == 1 && !game.getTController().tileIsTurned()) {
            game.getPlayer().selectSkill();
            return;
        }

        if (me.getButton() == 1) {
            for (Tile tile : game.getTController().getTiles()) {
                if ((me.getX()) >= (tile.getX() + 4)
                        && (me.getX()) <= (tile.getX() + 80 - 4)
                        && (me.getY()) >= (tile.getY() + 6)
                        && (me.getY()) <= (tile.getY() + 80 - 6)) {
                    tile.turn();
                    game.getOpponent().getTileController().addKnownTile(tile);
                    break;
                }
            }
            if (game.getTController().getTilesTurned() > 1) {
                game.pairTiles();
            }
        }
    }
}
