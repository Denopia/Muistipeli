package GameCharacter;

import Game.GameModes.SinglePlayerGame;
import Tile.Tile;
import java.awt.Image;
import java.util.ArrayList;

/**
 * Pelihahmo. Pitää sisällään juuri tämän hahmon tiedot.
 *
 */
public class Gus implements GameCharacter {

    private int hp;
    private int energy;
    private String currentImage;
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
    public void setNeutral() {
        if (getHp() > 15) {
            currentImage = neutral;
        } else {
            currentImage = damaged;
        }
    }

    @Override
    public void setHappy() {
        currentImage = happy;
    }

    @Override
    public void setUnhappy() {
        currentImage = unhappy;
    }

    @Override
    public void setTakeDamage() {
        currentImage = takeDamage;
    }

    @Override
    public void setGiveDamage() {
        currentImage = giveDamage;
    }

    @Override
    public void setDamaged() {
        currentImage = damaged;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int i) {
        hp = i;
        if (hp > 30) {
            hp = 30;
        }
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void setEnergy(int i) {
        energy = i;
    }

    @Override
    public String getCurrentImage() {
        return currentImage;
    }

    @Override
    public boolean useSkill(SinglePlayerGame game) {
        if (energy >= 5 && game.getHController().getHorRow() != -1) {
            energy -= 5;
            ArrayList<Tile> tilesToBeTurned = new ArrayList<>();
            int r = (game.getHController().getHorRow() - 1) * 6;
            for (int i = 0; i < 6; i++) {
                tilesToBeTurned.add(game.getTController().getTiles().get(r + i));
            }
            for (Tile tile : tilesToBeTurned) {
                tile.turn();
            }
            game.getPlayer().deselectSkill();
            return true;
        }
        return false;
    }
}
