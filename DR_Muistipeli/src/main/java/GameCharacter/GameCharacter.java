package GameCharacter;

import Game.GameModes.SinglePlayerGame;

/**
 * Pelihahmorajapinta. Näyttää mitä kaikkea hahmoluokkien tulee tehdä.
 */
public interface GameCharacter {

    /**
     * Asettaa hahmolle sen ominais elamapisteet ja energian
     */
    public void setDefault();

    /**
     * Aseta hahmon nykyinen kuva neutraaliksi
     */
    public void setNeutral();

    /**
     * Aseta hahmon nykyinen kuva iloiseksi
     */
    public void setHappy();

    /**
     * Aseta hahmon nykyinen kuva surulliseksi
     */
    public void setUnhappy();

    /**
     * Aseta hahmon nykyinen kuva vahingoittuneeksi
     */
    public void setDamaged();

    /**
     * Aseta hahmon nykyinen kuva vahingoittuvaksi
     */
    public void setTakeDamage();

    /**
     * Aseta hahmon nykyinen kuva lyovaksi
     */
    public void setGiveDamage();

    /**
     * Aseta hahmolle talteen kaikki sen kuvien polut
     */
    public void setImages1();

    /**
     * Palauttaa hahmon nykyisen kuvan polun
     *
     * @return Polku nykyiseen kuvaan
     */
    public String getCurrentImage();

    /**
     * Palauta hahmon elamapisteet
     *
     * @return Elamapisteet
     */
    public int getHp();

    /**
     * Aseta hahmolle elamapisteet
     *
     * @param i elamapisteet
     */
    public void setHp(int i);

    /**
     * Palauta hahmon energia
     *
     * @return energia
     */
    public int getEnergy();

    /**
     * Aseta hahmon energia
     *
     * @param i energia
     */
    public void setEnergy(int i);

    /**
     * Kayta hahmon taito
     *
     * @param game Peli jota manipuloidaan
     * @return palauttaa true jos taito kaytettiin, false jos ei
     */
    public boolean useSkill(SinglePlayerGame game);

}
