package Game;

import Graphics.DrawingBoardMenu;
import Helpers.MainMenuHighlightController;
import UserInterface.MouseListener.MouseListenerMainMenu;
import javax.swing.JFrame;

/**
 * Pelin päävalikko. Tietää missä hiiri sijaitsee ja käynnistää pelin
 * valmistelun kun haluttua pelimoodia klikataan. Antaa myös mahdollisuuden
 * katsoa ohjeet. Rakentaa näkymät GameScreenin kautta.
 *
 */
public class MainMenu {

    private JFrame frame;
    private DrawingBoardMenu dbm;
    private GameScreen gameScreen;
    private MouseListenerMainMenu mouseListener;
    private MainMenuHighlightController hController;

    public MainMenu(JFrame frame, GameScreen gs) {
        this.frame = frame;
        this.dbm = new DrawingBoardMenu(this);
        this.gameScreen = gs;
        this.mouseListener = new MouseListenerMainMenu(this);
        this.hController = new MainMenuHighlightController(this);

        this.frame.addMouseListener(this.mouseListener);
        this.frame.addMouseMotionListener(this.mouseListener);
        this.frame.add(dbm);
    }
    
    public MainMenuHighlightController getHController(){
        return hController;
    }

    public void unHighlightAllAndDraw() {
        hController.unHighlightAll();
        refresh();
    }

    /**
     * Kaskee peli-ikkunaa luomaan pelin valmisteluruudun
     *
     * @param i Pelimoodi
     */
    public void startPreparationScreen(int i) {
        gameScreen.buildPreparation(i);
    }

    /**
     * Kaskee peli-ikkunaa luomaan ohjeruudun
     */
    public void showInstructions() {
        System.out.println("Näytä ohjeet!");
    }

    /**
     * Kaskee peli-ikkunaa sammuttamaan pelin
     */
    public void closeGame() {
        gameScreen.closeScreen();
    }

    /**
     * Kaskee piirtoalustaa paivittamaan itsensa
     */
    public void refresh() {
        dbm.repaint();
    }

}
