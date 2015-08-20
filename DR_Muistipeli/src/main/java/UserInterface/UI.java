package UserInterface;

import Game.GameScreen;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Tekee pelin framen
 * 
 */
public class UI implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Muistipeli :]");
        frame.setPreferredSize(new Dimension(1024, 768));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        GameScreen gs = new GameScreen(frame);
        gs.buildMainMenu();
    }
}
