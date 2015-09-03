package Player.Human;

import GameCharacter.GameCharacter;

/**
 * Pitaa sisallaan ihmispelaajan tiedot.
 */
public class Player {

    private GameCharacter gc;
    private boolean skillSelected;
    private boolean neutralState;
    private int movesLeft;
    private int hitsLeft;

    /**
     * Konstruktori
     */
    public Player() {
        movesLeft = 0;
        hitsLeft = 0;
        this.neutralState = true;
        this.skillSelected = false;
    }

    /**
     * Lisaa vuoron
     */
    public void addMove() {
        movesLeft++;
    }

    /**
     * Poistaa vuoron
     */
    public void removeMove() {
        movesLeft--;
    }

    /**
     * Palauttaa vuorot
     *
     * @return vuorot
     */
    public int getMoves() {
        return movesLeft;
    }

    /**
     * Asettaa pelaajan neutraliin tilaan
     */
    public void setNeutralStateTrue() {
        neutralState = true;
    }

    /**
     * Poistaa pelaajan neutraalista tilasta
     */
    public void setNeutralStateFalse() {
        neutralState = false;
    }

    /**
     * Palauttaa neutraalin tilan totuusarvon
     *
     * @return true jos on neutraali, false jos ei
     */
    public boolean getNeutralState() {
        return neutralState;
    }

    /**
     * Asettaa hahmon
     *
     * @param gc hahmo
     */
    public void setCharacter(GameCharacter gc) {
        this.gc = gc;
    }

    /**
     * Poistaa lyonnin
     */
    public void removeHit() {
        hitsLeft--;
    }

    /**
     * Lisaa lyonnin
     */
    public void addHit() {
        hitsLeft++;
    }

    /**
     * Palauttaa jaljella olevat lyonnit
     *
     * @return lyonnit
     */
    public int getHitsLeft() {
        return hitsLeft;
    }

    /**
     * Asettaa lyonnit yhteen
     */
    public void setHitsToOne() {
        hitsLeft = 1;
    }

    /**
     * Palauttaa hahmon
     *
     * @return hahmo
     */
    public GameCharacter getCharacter() {
        return gc;
    }

    /**
     * Asettaa taidon valituksi
     */
    public void selectSkill() {
        skillSelected = true;
    }

    /**
     * Asettaa taidon ei-valituksi
     */
    public void deselectSkill() {
        skillSelected = false;
    }

    /**
     * Kertoo onko taito valittu
     *
     * @return True jos on valittu, false jos ei
     */
    public boolean getSkillSelected() {
        return skillSelected;
    }

    /**
     * Asettaa vuorot yhteen
     */
    public void setMovesToOne() {
        movesLeft = 1;
    }
}
