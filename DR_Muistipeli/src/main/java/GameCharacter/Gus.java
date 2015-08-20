package GameCharacter;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Pelihahmo. Pitää sisällään juuri tämän
 * hahmon tiedot.
 * 
 */
public class Gus implements GameCharacter {

    private int hp;
    private int energy;
    private int attack;
    private int armor;
    private Image currentImage;
    private String neutralImage;
    private String yesImage;
    private String noImage;
    private String damageImage;
    private int stats;

    public Gus() {
        setDefault();
    }

    private void setDefault() {
        setHp(90);
        setEnergy(30);
        setAttack(15);
        setArmor(10);
    }

    public void setImages1() {
        setNeutral("gus_neutral.png");
        setYes("gus_yes.png");
        setNo("gus_no.png");
        setCurrentImage(neutralImage);
    }

    public void setImages2() {
        setNeutral("ROBOALT.png");
        setYes("ROBOYESALT.png");
        setNo("ROBOFUGALT.png");
        setCurrentImage(neutralImage);
    }

    public void setNeutral(String s) {
        this.neutralImage = s;
    }

    public void setYes(String s) {
        this.yesImage = s;
    }

    public void setNo(String s) {
        this.noImage = s;
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
        return this.neutralImage;
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

    public Image createImage(String path) {
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
