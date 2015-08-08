package GameCharacter;

import java.awt.Image;
import javax.swing.ImageIcon;

public class GameCharacter {

    private Image currentImage;
    private String basicImage;
    private String yesImage;
    private String noImage;
    private String buffedImage;
    private String damageImage;
    private int stats;

    public GameCharacter(String basicImage, String yesImage, String noImage) {
        this.basicImage = basicImage;
        this.yesImage = yesImage;
        this.noImage = noImage;
    }

    public String getBasic() {
        return this.basicImage;
    }

    public String getYes() {
        return this.yesImage;
    }
    public String getNo() {
        return this.noImage;
    }
    

    public Image getCurrentImage() {
        return this.currentImage;
    }

    public void setCurrentImage(String string) {
        this.currentImage = createImage(string);
    }

    private Image createImage(String path) {
        ImageIcon icon = null;
        java.net.URL imgURL = getClass().getClassLoader().getResource(path);
        if (imgURL != null) {
            icon = new ImageIcon(imgURL);
        } else {
            System.err.println("Picture " + path + " not found");
        }
        Image kuva = icon.getImage();
        return kuva;
    }
}
