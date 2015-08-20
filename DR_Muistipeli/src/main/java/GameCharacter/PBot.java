package GameCharacter;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Pelihahmo. Pitää sisällään juuri tämän
 * hahmon tiedot.
 * 
 */
public class PBot implements GameCharacter {

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

    public PBot() {
        setDefault();
    }

    private void setDefault() {
        setHp(90);
        setEnergy(30);
        setAttack(15);
        setArmor(10);
    }

    @Override
    public void setImages1() {
        setNeutral("ROBO.png");
        setYes("ROBOYES.png");
        setNo("ROBOFUG.png");
        setCurrentImage(neutralImage);
    }

    @Override
    public void setImages2() {
        setNeutral("ROBOALT.png");
        setYes("ROBOYESALT.png");
        setNo("ROBOFUGALT.png");
        setCurrentImage(neutralImage);
    }

    @Override
    public void setNeutral(String s) {
        this.neutralImage = s;
    }

    @Override
    public void setYes(String s) {
        this.yesImage = s;
    }

    @Override
    public void setNo(String s) {
        this.noImage = s;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void setAttack(int i) {
        this.attack = i;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public void setArmor(int i) {
        this.armor = i;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int i) {
        this.hp = i;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void setEnergy(int i) {
        this.energy = i;
    }

    @Override
    public String getBasic() {
        return this.neutralImage;
    }

    @Override
    public String getYes() {
        return this.yesImage;
    }

    @Override
    public String getNo() {
        return this.noImage;
    }

    @Override
    public Image getCurrentImage() {
        return this.currentImage;
    }

    @Override
    public void setCurrentImage(String string) {
        this.currentImage = createImage(string);
    }

    @Override
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
