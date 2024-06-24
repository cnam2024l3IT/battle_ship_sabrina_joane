package pf.project.cnam.model.StrategyAttackShip;

import pf.project.cnam.model.Board;
import java.util.Random;

public class RandomAttackStrategy implements AttackStrategy {

    private final Random random = new Random();

    @Override
    public void attack(Board board) {
        // base logique pour l'attaque aléatoire
        int x = random.nextInt(board.getSize());
        int y = random.nextInt(board.getSize());
        board.attack(x, y);
    }
}
