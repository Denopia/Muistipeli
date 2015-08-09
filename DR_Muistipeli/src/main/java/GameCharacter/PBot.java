package GameCharacter;

public class PBot extends GameCharacter {

    public PBot() {
        super("ROBO.png", "ROBOYES.png", "ROBOFUG.png");
        super.setCurrentImage(super.getBasic());
    }

    public PBot(String o) {
        super("ROBOALT.png", "ROBOYESALT.png", "ROBOFUGALT.png");
        super.setCurrentImage(super.getBasic());
    }

}
