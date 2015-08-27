package GameCharacter;

import Tile.Tile;
import java.awt.Image;
import java.util.ArrayList;
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

    @Override
    public void setNeutral() {
        if (getHp() > 15) {
            setCurrentImage(neutral);
        } else {
            setCurrentImage(damaged);
        }
    }

    @Override
    public void setHappy() {
        setCurrentImage(happy);
    }

    @Override
    public void setUnhappy() {
        setCurrentImage(unhappy);
    }

    @Override
    public void setTakeDamage() {
        setCurrentImage(takeDamage);
    }

    @Override
    public void setGiveDamage() {
        setCurrentImage(giveDamage);
    }

    @Override
    public void setDamaged() {
        setCurrentImage(damaged);
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

    @Override
    public ArrayList<Tile> useSkill(ArrayList<Tile> tiles, int row) {
        ArrayList<Tile> tilesToBeTurned = new ArrayList<>();
        int r = row * 6;
        for (int i = 0; i < 6; i++) {
            tilesToBeTurned.add(tiles.get(r + i));
        }
        return tilesToBeTurned;
    }

}
