package GameCharacter;

import Tile.Tile;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Pelihahmo. Pitää sisällään juuri tämän hahmon tiedot.
 *
 */
public class Apollo implements GameCharacter {

    private int hp;
    private int energy;
    private Image currentImage;
    private String neutral;
    private String happy;
    private String unhappy;
    private String damaged;
    private String giveDamage;
    private String takeDamage;

    public Apollo() {
        setDefault();
    }

    private void setDefault() {
        setHp(30);
        setEnergy(15);
    }

    @Override
    public void setImages1() {
        neutral = "character/apollo/apollo_neutral.png";
        happy = "character//apollo_yes.png";
        unhappy = "character/apollo/apollo_no.png";
        damaged = "character/apollo/apollo_damaged.png";
        takeDamage = "character/apollo/apollo_take_damage.png";
        giveDamage = "character/apollo/apollo_give_damage.png";
        setCurrentImage(neutral);
    }

    @Override
    public void setImages2() {
        neutral = "character/apollo/apollo_neutral.png";
        happy = "character//apollo_yes.png";
        unhappy = "character/apollo/apollo_no.png";
        damaged = "character/apollo/apollo_damaged.png";
        takeDamage = "character/apollo/apollo_take_damage.png";
        giveDamage = "character/apollo/apollo_give_damage.png";
        setCurrentImage(neutral);
    }

    public void setNeutral() {
        setCurrentImage(neutral);
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

    @Override
    public ArrayList<Tile> useSkill(ArrayList<Tile> tiles, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
