package MainClass;

import UserInterface.UI;
import javax.swing.SwingUtilities;

/**
 * Paaluokka, kaynnistaa pelin
 * 
 */
public class MuistipeliMain {

    public static void main(String[] args) {
        
        UI ui = new UI();
        SwingUtilities.invokeLater(ui);
    }
}
