package GameCharacter;

import java.awt.Image;
import javax.swing.ImageIcon;

public class GameCharacter {

    private int hp;
    private int energy;
    private int attack;
    private int armor;
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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int i) {
        this.attack = i;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int i) {
        this.armor = i;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int i) {
        this.hp = i;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int i) {
        this.energy = i;
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
