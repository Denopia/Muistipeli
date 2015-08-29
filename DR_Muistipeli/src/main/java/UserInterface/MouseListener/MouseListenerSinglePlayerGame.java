package UserInterface.MouseListener;

import Game.GameModes.SinglePlayerGame;
import Tile.Tile;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Kuuntelee hiiren liikettä ja klikkauksia. Suorittaa metodeja niiden
 * perusteella.
 *
 */
public class MouseListenerSinglePlayerGame extends MouseAdapter {

    private SinglePlayerGame game;

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
        game.getHController().unHighlightHit();
        game.getHController().unHighlightSkill();
        game.getTController().unHighlightAll();

        //Jos hiiri toimintanapin päällä, korostetaan se
        if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 550 && me.getY() <= 591) {
            game.getHController().highlightHit();
            game.refresh();
            return;
        } else if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 610 && me.getY() <= 651) {
            game.getHController().highlightSkill();
            game.refresh();
            return;
        }

        //Laitetaan muistiin kaikki rivit jotka hiiri korostaa jos taito valittuna ja hiiri laattojen päällä
        if (game.getPlayer().getSkillSelected()) {
            if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 185 && me.getY() <= 266) {
                game.getHController().setHorRowTrue(1);
            } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 270 && me.getY() <= 351) {
                game.getHController().setHorRowTrue(2);
            } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 355 && me.getY() <= 436) {
                game.getHController().setHorRowTrue(3);
            } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 440 && me.getY() <= 521) {
                game.getHController().setHorRowTrue(4);
            } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 525 && me.getY() <= 606) {
                game.getHController().setHorRowTrue(5);
            } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 610 && me.getY() <= 691) {
                game.getHController().setHorRowTrue(6);
            } else {
                game.getHController().setHorRowsFalse();
            }
            if (me.getX() >= 259 && me.getX() <= 259 + 83 && me.getY() >= 185 && me.getY() <= 691) {
                game.getHController().setVerRowTrue(1);
            } else if (me.getX() >= 259 + 85 && me.getX() <= 259 + 83 + 85 && me.getY() >= 185 && me.getY() <= 691) {
                game.getHController().setVerRowTrue(2);
            } else if (me.getX() >= 259 + 85 + 85 && me.getX() <= 259 + 83 + 85 + 85 && me.getY() >= 185 && me.getY() <= 691) {
                game.getHController().setVerRowTrue(3);
            } else if (me.getX() >= 259 + 85 + 85 + 85 && me.getX() <= 259 + 83 + 85 + 85 + 85 && me.getY() >= 185 && me.getY() <= 691) {
                game.getHController().setVerRowTrue(4);
            } else if (me.getX() >= 259 + 85 + 85 + 85 + 85 && me.getX() <= 259 + 83 + 85 + 85 + 85 + 85 && me.getY() >= 185 && me.getY() <= 691) {
                game.getHController().setVerRowTrue(5);
            } else if (me.getX() >= 259 + 85 + 85 + 85 + 85 + 85 && me.getX() <= 259 + 83 + 85 + 85 + 85 + 85 + 85 && me.getY() >= 185 && me.getY() <= 691) {
                game.getHController().setVerRowTrue(6);
            } else {
                game.getHController().setVerRowsFalse();
            }
            game.refresh();
            return;
        }

        //Jos hiiri laatan paalla ja taito ei aktiivicena, korostetaan se 
        for (Tile tile : game.getTController().getTiles()) {
            if ((me.getX() - 9) >= (tile.getX() + 4)
                    && (me.getX() - 9) <= (tile.getX() + 80 - 4)
                    && (me.getY() - 38) >= (tile.getY() + 6)
                    && (me.getY() - 38) <= (tile.getY() + 80 - 6)) {
                tile.highlight();
                game.refresh();
                return;
            }
        }
        game.refresh();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //Jos ei pelaajan vuoro, ei tehdä mitään
        if (!game.isPlayersTurn() || !game.getPlayer().getNeutralState()) {
            return;
        }
        //Jos laattoja on käännetty 2 tai ennemmän ei käännetä ylimääräisiä ennen kuin tilanne on selvitetty
        if (game.getTController().getTilesTurned() > 1) {
            return;
        }
        //Jos pelaajan taito on valittuna ja painetaan pelilaudalta jotain riviä, pelaaja käyttää taidon
        if (game.getPlayer().getSkillSelected()) {
            if (me.getButton() == 1) {
                if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 610 && me.getY() <= 651) {
                    game.getPlayer().deselectSkil();
                } else {
                    game.playerUseSkill();
                }
                //Jos right klikataan mistä vaan, otetaan taito pois aktiivisesta tilasta
            } else if (me.getButton() == 3) {
                game.getHController().unHighlightAll();
                game.getPlayer().deselectSkil();
            }
            game.refresh();
            return;
        }
        if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 550 && me.getY() <= 591 && me.getButton() == 1) {
            game.getAController().hitOpponent();
            game.refresh();
            return;
        }
        if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 610 && me.getY() <= 651 && me.getButton() == 1) {
            game.getPlayer().selectSkil1();
            game.refresh();
            return;
        }

        if (me.getButton() == 1) {
            for (Tile tile : game.getTController().getTiles()) {
                if ((me.getX() - 9) >= (tile.getX() + 4)
                        && (me.getX() - 9) <= (tile.getX() + 80 - 4)
                        && (me.getY() - 38) >= (tile.getY() + 6)
                        && (me.getY() - 38) <= (tile.getY() + 80 - 6)) {
                    tile.turn();
                    game.getOpponent().addSeenTile(tile);
                    break;
                }
            }
            if (game.getTController().getTilesTurned() == 2) {
                game.pairTiles();

            }
            game.refresh();
        }
    }
}
