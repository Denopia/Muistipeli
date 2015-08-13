package GameCharacter;

public class PBot extends GameCharacter {
    

    public PBot() {
        super("ROBO.png", "ROBOYES.png", "ROBOFUG.png");
        super.setCurrentImage(super.getBasic());
        setDefault();
    }

    public PBot(String o) {
        super("ROBOALT.png", "ROBOYESALT.png", "ROBOFUGALT.png");
        super.setCurrentImage(super.getBasic());
        setDefault();
    }
    
    private void setDefault(){
        super.setHp(90);
        super.setEnergy(30);
        super.setAttack(15);
        super.setArmor(10);
    }

}
