package Controller;

/**
 * Pitaa muistissa mitka elementit yksinpeliruudulla ovat korostettuna
 */
public class SinglePlayerGameHighlightController {

    private boolean verRow1;
    private boolean verRow2;
    private boolean verRow3;
    private boolean verRow4;
    private boolean verRow5;
    private boolean verRow6;
    private boolean horRow1;
    private boolean horRow2;
    private boolean horRow3;
    private boolean horRow4;
    private boolean horRow5;
    private boolean horRow6;
    private boolean mouseOnHit;
    private boolean mouseOnSkill1;
    private boolean mouseOnExit;

    /**
     * Konstruktori, asettaa kaikki arvot epatodeksi
     */
    public SinglePlayerGameHighlightController() {
        unHighlightAll();
    }

    /**
     * Kaikki vaakarivit asetetaan korostamattomiksi
     */
    public final void setHorRowsFalse() {
        horRow1 = false;
        horRow2 = false;
        horRow3 = false;
        horRow4 = false;
        horRow5 = false;
        horRow6 = false;
    }

    /**
     * Laittaa tietyn vaakarivin korostetuksi
     *
     * @param i Mika rivi korostetaan
     */
    public void setHorRowTrue(int i) {
        if (i == 1) {
            horRow1 = true;
        } else if (i == 2) {
            horRow2 = true;
        } else if (i == 3) {
            horRow3 = true;
        } else if (i == 4) {
            horRow4 = true;
        } else if (i == 5) {
            horRow5 = true;
        } else if (i == 6) {
            horRow6 = true;
        }
    }

    /**
     * Kaikki pystyrivit asetetaan korostamattomiksi
     */
    public final void setVerRowsFalse() {
        verRow1 = false;
        verRow2 = false;
        verRow3 = false;
        verRow4 = false;
        verRow5 = false;
        verRow6 = false;
    }

    /**
     * Laittaa tietyn pystyrivin korostetuksi
     *
     * @param i Mika rivi korostetaan
     */
    public void setVerRowTrue(int i) {
        if (i == 1) {
            verRow1 = true;
        } else if (i == 2) {
            verRow2 = true;
        } else if (i == 3) {
            verRow3 = true;
        } else if (i == 4) {
            verRow4 = true;
        } else if (i == 5) {
            verRow5 = true;
        } else if (i == 6) {
            verRow6 = true;
        }
    }

    /**
     * Palauttaa pystyrivin joka on korostettu, jos ei yhtaan korostettuna
     * palauttaa -1
     *
     * @return Korostetun rivin numero
     */
    public int getVerRow() {
        if (verRow1 == true) {
            return 1;
        } else if (verRow2 == true) {
            return 2;
        } else if (verRow3 == true) {
            return 3;
        } else if (verRow4 == true) {
            return 4;
        } else if (verRow5 == true) {
            return 5;
        } else if (verRow6 == true) {
            return 6;
        } else {
            return -1;
        }
    }

    /**
     * Palauttaa vaakarivin joka on korostettu, jos ei yhtaan korostettuna
     * palauttaa -1
     *
     * @return Korostetun rivin numero
     */
    public int getHorRow() {
        if (horRow1 == true) {
            return 1;
        } else if (horRow2 == true) {
            return 2;
        } else if (horRow3 == true) {
            return 3;
        } else if (horRow4 == true) {
            return 4;
        } else if (horRow5 == true) {
            return 5;
        } else if (horRow6 == true) {
            return 6;
        } else {
            return -1;
        }
    }

    /**
     * Poistetaan kaikki korostukset
     */
    public final void unHighlightAll() {
        unHighlightExit();
        unHighlightSkill();
        unHighlightHit();
        setHorRowsFalse();
        setVerRowsFalse();
    }

    /**
     * Korostaa lyonti-nappulan
     */
    public void highlightHit() {
        mouseOnHit = true;
    }

    /**
     * Poistaa lyonti-nappulan korostuksen
     */
    public void unHighlightHit() {
        mouseOnHit = false;
    }

    /**
     * Korostaa luovutus-nappulan
     */
    public void highlightExit() {
        mouseOnExit = true;
    }

    /**
     * Poistaa luovutus-nappulan korostuksen
     */
    public void unHighlightExit() {
        mouseOnExit = false;
    }

    /**
     * Korostaa taito-nappulan
     */
    public void highlightSkill() {
        mouseOnSkill1 = true;
    }

    /**
     * Poistaa taito-nappulan korostuksen
     */
    public void unHighlightSkill() {
        mouseOnSkill1 = false;
    }

    /**
     * Palauttaa lyonti-nappulan korostuksen
     *
     * @return True jos on korostettu, false jos ei
     */
    public boolean getHitH() {
        return mouseOnHit;
    }

    /**
     * Palauttaa taito-nappulan korostuksen
     *
     * @return True jos on korostettu, false jos ei
     */
    public boolean getSkillH() {
        return mouseOnSkill1;
    }

    /**
     * Palauttaa luovutus-nappulan korostuksen
     *
     * @return True jos on korostettu, false jos ei
     */
    public boolean getExitH() {
        return mouseOnExit;
    }

}
