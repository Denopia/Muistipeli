package Helpers;

public class InstructionsHighlightController {

    private boolean mouseOnMenu;

    public InstructionsHighlightController() {
        mouseOnMenu = false;
    }

    public void highlightMenu() {
        mouseOnMenu = true;
    }

    public void unHighlightMenu() {
        mouseOnMenu = false;
    }

    public boolean getMenuH() {
        return mouseOnMenu;
    }

}
