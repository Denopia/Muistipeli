package GameCharacter;

import Game.GameModes.SinglePlayerGame;

/**
 * Pelihahmorajapinta. Näyttää mitä kaikkea hahmoluokkien tulee tehdä.
 *
 */
public interface GameCharacter {

    public void setNeutral();

    public void setHappy();

    public void setUnhappy();

    public void setDamaged();

    public void setTakeDamage();

    public void setGiveDamage();

    public void setImages1();

    public String getCurrentImage();
    

    public int getHp();

    public void setHp(int i);

    public int getEnergy();

    public void setEnergy(int i);

    public boolean useSkill(SinglePlayerGame game);

}
