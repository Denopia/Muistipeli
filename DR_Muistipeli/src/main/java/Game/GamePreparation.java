package Game;

import GameCharacter.Apollo;
import GameCharacter.Gus;
import GameCharacter.PBot;
import Graphics.DrawingBoardPreparation;
import Helpers.PreparationHighlightController;
import Player.Computer.Opponent;
import Player.Human.Player;
import UserInterface.MouseListener.MouseListenerPreparation;
import javax.swing.JFrame;

/**
 * Luokka pitää yllä pelin valmisteluruutua, eli tietää mikä vaikeustaso ja
 * hahmot on valittuna ja mahdollistaa näiden vaihtamisen.
 *
 * Highlight yllapito tulee tehda viela omasi luokakseen
 */
public class GamePreparation {

    private JFrame frame;
    private int gameMode;
    private GameScreen gs;
    private DrawingBoardPreparation dbp;
    private MouseListenerPreparation mmlp;
    private int difficulty;
    private int playerCharacter;
    private int opponentCharacter;
    private int playerColor;
    private int opponentColor;
    private PreparationHighlightController hController;

    public GamePreparation(int gameMode, JFrame frame, GameScreen gs) {
        this.hController = new PreparationHighlightController();
        this.difficulty = 2;
        this.playerCharacter = 1;
        this.opponentCharacter = 1;
        this.playerColor = 1;
        this.opponentColor = 1;
        this.frame = frame;
        this.gameMode = gameMode;
        this.gs = gs;
        this.dbp = new DrawingBoardPreparation(this);
        this.mmlp = new MouseListenerPreparation(this);
        this.frame.addMouseListener(mmlp);
        this.frame.addMouseMotionListener(mmlp);
        this.frame.add(dbp);
    }

    public PreparationHighlightController getHController() {
        return hController;
    }

    public void setDifficulty(int i) {
        difficulty = i;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setPlayerCharacter(int i) {
        playerCharacter = i;
    }

    public int getPlayerCharacter() {
        return playerCharacter;
    }

    public void setOpponentCharacter(int i) {
        opponentCharacter = i;
    }

    public int getOpponentCharacter() {
        return opponentCharacter;
    }

    /**
     * Rakentaa oikean pelin pelimoodin mukaan.
     *
     */
    public void startGame() {
        if (gameMode == 1) {
            gs.buildBattleSinglePlayerGame(makePlayer(playerCharacter, playerColor), makeOpponent(opponentCharacter, opponentColor, difficulty));
        }
    }

    /**
     * Tekee pelaajan valitun hahmon ja värin mukaan
     *
     * @param character Pelaajan pelihahmo
     * @param color Pelihahmon väri
     * @return Luotu pelaaja
     */
    public Player makePlayer(int character, int color) {
        Player bp = new Player();
        if (character == 1) {
            bp.setCharacter(new Gus());
        } else if (character == 2) {
            bp.setCharacter(new Apollo());
        } else if (character == 3) {
            bp.setCharacter(new PBot());
        }
        if (color == 1) {
            bp.getCharacter().setImages1();
        } else if (color == 2) {
            bp.getCharacter().setImages2();
        }
        return bp;
    }

    /**
     * Tekee vastustajan valitun hahmon ja värin mukaan
     *
     * @param character Vastustajan pelihahmo
     * @param color Vastustajan väri
     * @param difficulty Vastustajan vaikeusaste
     * @return Luotu vastustaja
     */
    public Opponent makeOpponent(int character, int color, int difficulty) {
        Opponent bo = new Opponent();
        if (character == 1) {
            bo.setCharacter(new Gus());
        } else if (character == 2) {
            bo.setCharacter(new Apollo());
        } else if (character == 3) {
            bo.setCharacter(new PBot());
        }
        if (color == 1) {
            bo.getCharacter().setImages1();
        } else if (color == 2) {
            bo.getCharacter().setImages2();
        }
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
     * Maalaa peliruudun uudestaan
     */
    public void refresh() {
        this.frame.repaint();
    }

    /**
     * Muuttaa pelaajan hahmoa
     */
    public void previousPlayerCharacter() {
        playerCharacter--;
        if (playerCharacter == 0) {
            playerCharacter = 3;
        }
    }

    /**
     * Muuttaa pelaajan hahmoa
     */
    public void nextPlayerCharacter() {
        playerCharacter++;
        if (playerCharacter == 4) {
            playerCharacter = 1;
        }
    }

    /**
     * Muuttaa vastustajan hahmoa
     */
    public void previousOpponentCharacter() {
        opponentCharacter--;
        if (opponentCharacter == 0) {
            opponentCharacter = 3;
        }
    }

    /**
     * Muuttaa vastustajan hahmoa
     */
    public void nextOpponentCharacter() {
        opponentCharacter++;
        if (opponentCharacter == 4) {
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
