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
    }

    @Override
    public void setImages1() {
        neutral = "character/gus/gus_neutral.png";
        happy = "character/gus/gus_yes.png";
        unhappy = "character/gus/gus_no.png";
        damaged = "character/gus/gus_damaged.png";
        takeDamage = "character/gus/gus_take_damage.png";
        giveDamage = "character/gus/gus_give_damage.png";
        setNeutral();
    }

    @Override
    public void setImages2() {
        neutral = "character/gus/gus_neutral.png";
        happy = "character/gus/gus_yes.png";
        unhappy = "character/gus/gus_no.png";
        damaged = "character/gus/gus_damaged.png";
        takeDamage = "character/gus/gus_take_damage.png";
        giveDamage = "character/gus/gus_give_damage.png";
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
