package Game;

import GameCharacter.Apollo;
import GameCharacter.Gus;
import GameCharacter.PBot;
import Graphics.DrawingBoardPreparation;
import Player.Computer.Opponent;
import Player.Human.Player;
import UserInterface.MouseListener.MouseListenerPreparation;
import javax.swing.JFrame;

/**
 * Luokka pitää yllä pelin valmisteluruutua, eli tietää mikä vaikeustaso ja
 * hahmot on valittuna ja mahdollistaa näiden vaihtamisen.
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
    private boolean mouseOnArrow1;
    private boolean mouseOnArrow2;
    private boolean mouseOnArrow3;
    private boolean mouseOnArrow4;
    private boolean mouseOnDifficulty1;
    private boolean mouseOnDifficulty2;
    private boolean mouseOnDifficulty3;
    private boolean mouseOnDifficulty4;
    private boolean mouseOnStart;
    private boolean mouseOnMenu;

    public GamePreparation(int gameMode, JFrame frame, GameScreen gs) {
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
        unHighlightAll();
    }

    public void setDifficulty(int i) {
        this.difficulty = i;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public void setPlayerCharacter(int i) {
        this.playerCharacter = i;
    }

    public int getPlayerCharacter() {
        return this.playerCharacter;
    }

    public void setOpponentCharacter(int i) {
        this.opponentCharacter = i;
    }

    public int getOpponentCharacter() {
        return this.opponentCharacter;
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

    public int getMode() {
        return this.gameMode;
    }

    /**
     * Laittaa kaikkien nappuloiden korostusarvoksi false
     */
    public final void unHighlightAll() {
        mouseOnArrow1 = false;
        mouseOnArrow2 = false;
        mouseOnArrow3 = false;
        mouseOnArrow4 = false;
        mouseOnDifficulty1 = false;
        mouseOnDifficulty2 = false;
        mouseOnDifficulty3 = false;
        mouseOnDifficulty4 = false;
        mouseOnStart = false;
        mouseOnMenu = false;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightA1() {
        mouseOnArrow1 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightA2() {
        mouseOnArrow2 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightA3() {
        mouseOnArrow3 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightA4() {
        mouseOnArrow4 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightD1() {
        mouseOnDifficulty1 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightD2() {
        mouseOnDifficulty2 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightD3() {
        mouseOnDifficulty3 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightD4() {
        mouseOnDifficulty4 = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightMenu() {
        mouseOnMenu = true;
    }

    /**
     * Laittaa tämän nappulan korostetuksi
     */
    public void highlightStart() {
        mouseOnStart = true;
    }

    public boolean getA1() {
        return mouseOnArrow1;
    }

    public boolean getA2() {
        return mouseOnArrow2;
    }

    public boolean getA3() {
        return mouseOnArrow3;
    }

    public boolean getA4() {
        return mouseOnArrow4;
    }

    public boolean getD1() {
        return mouseOnDifficulty1;
    }

    public boolean getD2() {
        return mouseOnDifficulty2;
    }

    public boolean getD3() {
        return mouseOnDifficulty3;
    }

    public boolean getD4() {
        return mouseOnDifficulty4;
    }

    public boolean getMenu() {
        return mouseOnMenu;
    }

    public boolean getStart() {
        return mouseOnStart;
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
