package pf.project.cnam;

import pf.project.cnam.controller.GameController;
import pf.project.cnam.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        GameController controller = GameController.getInstance();
        ConsoleView view = new ConsoleView(controller);
        view.start();
    }
}
