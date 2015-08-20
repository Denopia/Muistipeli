package GameCharacter;

import java.awt.Image;

/**
 * Pelihahmorajapinta. Näyttää mitä kaikkea
 * hahmoluokkien tulee tehdä.
 * 
 */
public interface GameCharacter {

    public void setNeutral(String s);

    public void setYes(String s);

    public void setNo(String s);

    public int getAttack();

    public void setAttack(int i);

    public int getArmor();

    public void setArmor(int i);

    public int getHp();

    public void setHp(int i);

    public int getEnergy();

    public void setEnergy(int i);

    public String getBasic();

    public String getYes();

    public String getNo();

    public Image getCurrentImage();

    public void setCurrentImage(String string);

    public Image createImage(String path);

    public void setImages1();

    public void setImages2();
}
