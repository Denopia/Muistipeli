package Game;

import GameCharacter.Apollo;
import GameCharacter.Gus;
import Graphics.DrawingBoardPreparation;
import Controller.PreparationHighlightController;
import Player.Computer.Opponent;
import Player.Human.Player;
import UserInterface.MouseListener.MouseListenerPreparation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Luokka pitää yllä pelin valmisteluruutua, eli tietää mikä vaikeustaso ja
 * hahmot on valittuna ja mahdollistaa näiden vaihtamisen.
 *
 * Highlight yllapito tulee tehda viela omasi luokakseen
 */
public class GamePreparation {

    private JFrame frame;
    private GameScreen gs;
    private DrawingBoardPreparation dbp;
    private MouseListenerPreparation mmlp;
    private PreparationHighlightController hController;
    private int gameMode;
    private int difficulty;
    private int playerCharacter;
    private int opponentCharacter;

    /**
     * Konstruktori
     *
     * @param gameMode pelimoodi
     * @param frame pelin frame
     * @param gs pelin GameScreen olio
     * @param refreshRate kuinka usein ruutu paivitetaan
     */
    public GamePreparation(int gameMode, JFrame frame, GameScreen gs, int refreshRate) {
        this.hController = new PreparationHighlightController();
        this.difficulty = 2;
        this.playerCharacter = 1;
        this.opponentCharacter = 1;
        this.frame = frame;
        this.gameMode = gameMode;
        this.gs = gs;
        this.dbp = new DrawingBoardPreparation(this);
        this.mmlp = new MouseListenerPreparation(this);
        this.dbp.addMouseListener(mmlp);
        this.dbp.addMouseMotionListener(mmlp);
        this.frame.add(dbp);
        Timer t = repainter(dbp, refreshRate);
        t.setRepeats(true);
        t.start();
    }

    private final Timer repainter(final DrawingBoardPreparation d, int r) {
        Timer timer = new Timer(r, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                d.repaint();
            }

        });
        return timer;
    }

    /**
     * Palauttaa korostusten kontrollerin
     *
     * @return Korostuskontrolleri
     */
    public PreparationHighlightController getHController() {
        return hController;
    }

    /**
     * Asettaa vaikeusasteen
     *
     * @param i vaikeusaste
     */
    public void setDifficulty(int i) {
        difficulty = i;
    }

    /**
     * Palauttaa vaikeusasteen
     *
     * @return Vaikeusaste
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Asettaa pelaajan hahmon
     *
     * @param i Hahmon numero
     */
    public void setPlayerCharacter(int i) {
        playerCharacter = i;
    }

    /**
     * Palauttaa pelaajan hahmon
     *
     * @return Pelaajan hahmon numeron
     */
    public int getPlayerCharacter() {
        return playerCharacter;
    }

    /**
     * Asettaa vastustajan hahmon
     *
     * @param i Hahmon numero
     */
    public void setOpponentCharacter(int i) {
        opponentCharacter = i;
    }

    /**
     * Palauttaa vastustajan hahmon
     *
     * @return Vastustajan hahmon numeron
     */
    public int getOpponentCharacter() {
        return opponentCharacter;
    }

    /**
     * Rakentaa oikean pelin pelimoodin mukaan.
     */
    public void startGame() {
        if (gameMode == 1) {
            gs.buildBattleSinglePlayerGame(makePlayer(playerCharacter), makeOpponent(opponentCharacter, difficulty));
        }
    }

    /**
     * Tekee pelaajan valitun hahmon mukaan
     *
     * @param character Pelaajan pelihahmo
     * @return Luotu pelaaja
     */
    public Player makePlayer(int character) {
        Player bp = new Player();
        if (character == 1) {
            bp.setCharacter(new Gus());
        } else if (character == 2) {
            bp.setCharacter(new Apollo());
        }

        bp.getCharacter().setImages1();

        return bp;
    }

    /**
     * Tekee vastustajan valitun hahmon ja vaikeusasteen mukaan
     *
     * @param character Vastustajan pelihahmo
     * @param difficulty Vastustajan vaikeusaste
     * @return Luotu vastustaja
     */
    public Opponent makeOpponent(int character, int difficulty) {
        Opponent bo = new Opponent();
        if (character == 1) {
            bo.setCharacter(new Gus());
        } else if (character == 2) {
            bo.setCharacter(new Apollo());
        }
        bo.getCharacter().setImages1();
        bo.setDifficulty(difficulty);
        return bo;
    }

    /**
     * Palauttaa pelimoodin
     *
     * @return Pelimoodi
     */
    public int getMode() {
        return gameMode;
    }

    /**
     * Muuttaa pelaajan hahmoa
     */
    public void previousPlayerCharacter() {
        playerCharacter--;
        if (playerCharacter == 0) {
            playerCharacter = 2;
        }
    }

    /**
     * Muuttaa pelaajan hahmoa
     */
    public void nextPlayerCharacter() {
        playerCharacter++;
        if (playerCharacter == 3) {
            playerCharacter = 1;
        }
    }

    /**
     * Muuttaa vastustajan hahmoa
     */
    public void previousOpponentCharacter() {
        opponentCharacter--;
        if (opponentCharacter == 0) {
            opponentCharacter = 2;
        }
    }

    /**
     * Muuttaa vastustajan hahmoa
     */
    public void nextOpponentCharacter() {
        opponentCharacter++;
        if (opponentCharacter == 3) {
            opponentCharacter = 1;
        }
    }

    /**
     * Siirtyy takaisin alkuvalikkoon
     */
    public void backToMenu() {
        this.gs.buildMainMenu();
    }

}
