package GameCharacter;

import Game.GameModes.SinglePlayerGame;
import Tile.Tile;
import java.awt.Image;
import java.util.ArrayList;

/**
 * Pelihahmorajapinta. Näyttää mitä kaikkea hahmoluokkien tulee tehdä.
 *
 */
public interface GameCharacter {

    public void setNeutral();

    public void setHappy();

    public void setUnhappy();

    public int getHp();

    public void setHp(int i);

    public int getEnergy();

    public void setEnergy(int i);

    public void setDamaged();

    public Image getCurrentImage();

    public void setCurrentImage(String string);

    public Image createImage(String string);

    public void setImages1();

    public void setImages2();

    public void setTakeDamage();

    public void setGiveDamage();

    public boolean useSkill(SinglePlayerGame game);

}
