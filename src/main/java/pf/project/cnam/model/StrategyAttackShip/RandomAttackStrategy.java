package pf.project.cnam.model.StrategyAttackShip;

import pf.project.cnam.model.Board;

import java.util.Random;

public class RandomAttackStrategy implements AttackStrategy {

    private final Random random = new Random();

    @Override
    public void attack(Board board) {
        int size = board.getSize();
        int x, y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (board.getCell(x, y).isHit());

        board.attack(x, y);
    }
}
