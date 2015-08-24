package GameCharacter;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Pelihahmo. Pitää sisällään juuri tämän hahmon tiedot.
 *
 */
public class Gus implements GameCharacter {

    private int hp;
    private int energy;
    private int attack;
    private int armor;
    private Image currentImage;
    private String neutral;
    private String happy;
    private String unhappy;
    private String damaged;
    private String giveDamage;
    private String takeDamage;
    private int stats;

    public Gus() {
        setDefault();
    }

    private void setDefault() {
        setHp(30);
        setEnergy(15);
        setAttack(1);
        setArmor(1);
    }

    @Override
    public void setImages1() {
        neutral = "gus_neutral.png";
        happy = "gus_yes.png";
        unhappy = "gus_no.png";
        damaged = "gus_damaged.png";
        takeDamage = "gus_take_damage.png";
        giveDamage = "gus_give_damage.png";
        setNeutral();
    }

    @Override
    public void setImages2() {
        neutral = "gus_neutral.png";
        happy = "gus_yes.png";
        unhappy = "gus_no.png";
        damaged = "gus_damaged.png";
        takeDamage = "gus_take_damage.png";
        giveDamage = "gus_give_damage.png";
        setNeutral();
    }

    public void setNeutral() {
        if (getHp() > 15) {
            setCurrentImage(neutral);
        } else {
            setCurrentImage(damaged);
        }
    }

    public void setHappy() {
        setCurrentImage(happy);
    }

    public void setUnhappy() {
        setCurrentImage(unhappy);
    }

    public void setTakeDamage() {
        setCurrentImage(takeDamage);
    }

    public void setGiveDamage() {
        setCurrentImage(giveDamage);
    }

    public void setDamaged() {
        setCurrentImage(damaged);
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
        return this.neutral;
    }

    public Image getCurrentImage() {
        return this.currentImage;
    }

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
