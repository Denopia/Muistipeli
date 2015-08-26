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
        game.unHighlightHit();
        game.unHighlightSkill1();
        game.getController().unHighlightAll();

        //Jos hiiri toimintanapin päällä, korostetaan se
        if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 550 && me.getY() <= 591) {
            game.highlightHit();
            game.refresh();
            return;
        } else if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 610 && me.getY() <= 651) {
            game.highlightSkill1();
            game.refresh();
            return;
        }

        //Laitetaan muistiin kaikki rivit jotka hiiri korostaa jos taito valittuna ja hiiri laattojen päällä
        if (game.getPlayer().getSkill1Selected()) {
            if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 185 && me.getY() <= 266) {
                game.setHorRowTrue(1);
            } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 270 && me.getY() <= 351) {
                game.setHorRowTrue(2);
            } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 355 && me.getY() <= 436) {
                game.setHorRowTrue(3);
            } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 440 && me.getY() <= 521) {
                game.setHorRowTrue(4);
            } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 525 && me.getY() <= 606) {
                game.setHorRowTrue(5);
            } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 610 && me.getY() <= 691) {
                game.setHorRowTrue(6);
            } else {
                game.setHorRowsFalse();
            }
            game.refresh();
            return;
        }

        //Jos hiiri laatan paalla ja taito ei aktiivicena, korostetaan se 
        for (Tile tile : game.getController().getTiles()) {
            if ((me.getX() - 9) >= (tile.getX() + 4)
                    && (me.getX() - 9) <= (tile.getX() + 80 - 4)
                    && (me.getY() - 38) >= (tile.getY() + 6)
                    && (me.getY() - 38) <= (tile.getY() + 80 - 6)) {
                tile.highlight();
                game.refresh();
                return;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //Jos ei pelaajan vuoro, ei tehdä mitään
        if (!game.isPlayersTurn()) {
            return;
        }
        //Jos laattoja on käännetty 2 tai ennemmän ei käännetä ylimääräisiä ennen kuin tilanne on selvitetty
        if (game.getController().getTilesTurned() > 1) {
            return;
        }
        //Jos pelaajan taito on valittuna ja painetaan pelilaudalta jotain riviä, pelaaja käyttää taidon
        if (game.getPlayer().getSkill1Selected()) {
            if (me.getButton() == 1) {
                if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 185 && me.getY() <= 266) {
                    game.playerUseSkill1(0);
                } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 270 && me.getY() <= 351) {
                    game.playerUseSkill1(1);
                } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 355 && me.getY() <= 436) {
                    game.playerUseSkill1(2);
                } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 440 && me.getY() <= 521) {
                    game.playerUseSkill1(3);
                } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 525 && me.getY() <= 606) {
                    game.playerUseSkill1(4);
                } else if (me.getX() >= 259 && me.getX() <= 765 && me.getY() >= 610 && me.getY() <= 691) {
                    game.playerUseSkill1(5);
                } else if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 610 && me.getY() <= 651) {
                    game.getPlayer().deselectSkil1();
                }
                if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 610 && me.getY() <= 651) {
                    game.getPlayer().deselectSkil1();
                }
                //Jos right klikataan mistä vaan, otetaan taito pois aktiivisesta tilasta
            } else if (me.getButton() == 3) {
                game.unHighlightAll();
                game.getPlayer().deselectSkil1();
            }
            game.refresh();
            return;
        }
        if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 550 && me.getY() <= 591 && me.getButton() == 1) {
            game.hitOpponent();
            game.refresh();
            return;
        }
        if (me.getX() >= 76 && me.getX() <= 177 && me.getY() >= 610 && me.getY() <= 651 && me.getButton() == 1) {
            game.getPlayer().selectSkil1();
            game.refresh();
            return;
        }

        if (me.getButton() == 1) {
            for (Tile tile : game.getController().getTiles()) {
                if ((me.getX() - 9) >= (tile.getX() + 4)
                        && (me.getX() - 9) <= (tile.getX() + 80 - 4)
                        && (me.getY() - 38) >= (tile.getY() + 6)
                        && (me.getY() - 38) <= (tile.getY() + 80 - 6)) {
                    tile.turn();
                    game.getOpponent().addSeenTile(tile);
                    break;
                }
            }
            if (game.getController().getTilesTurned() == 2) {
                game.pairTiles();

            }
            game.refresh();
        }
    }
}
