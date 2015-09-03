package GameCharacter;

import Game.GameModes.SinglePlayerGame;
import Tile.Tile;
import java.util.ArrayList;

/**
 * Pelihahmo. Pitää sisällään juuri tämän hahmon tiedot.
 */
public class Apollo implements GameCharacter {

    private int hp;
    private int energy;
    private String currentImage;
    private String neutral;
    private String happy;
    private String unhappy;
    private String damaged;
    private String giveDamage;
    private String takeDamage;

    /**
     * Konstruktori
     */
    public Apollo() {
        setDefault();
    }

    @Override
    public void setDefault() {
        setHp(30);
        setEnergy(15);
    }

    @Override
    public void setImages1() {
        neutral = "character/apollo/apollo_neutral.png";
        happy = "character/apollo/apollo_yes.png";
        unhappy = "character/apollo/apollo_no.png";
        damaged = "character/apollo/apollo_damaged.png";
        takeDamage = "character/apollo/apollo_take_damage.png";
        giveDamage = "character/apollo/apollo_give_damage.png";
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
        if (energy >= 4 && game.getHController().getVerRow() != -1) {
            energy -= 4;
            ArrayList<Tile> tilesToBeTurned = new ArrayList<>();
            int r = (game.getHController().getVerRow() - 1);
            for (int i = 0; i < 6; i++) {
                tilesToBeTurned.add(game.getTController().getTiles().get(r + (6 * i)));
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
