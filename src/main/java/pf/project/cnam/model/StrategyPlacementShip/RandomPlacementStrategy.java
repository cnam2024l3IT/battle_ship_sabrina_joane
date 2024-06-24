package pf.project.cnam.model.StrategyPlacementShip;

import pf.project.cnam.model.Board;
import pf.project.cnam.model.Ships.Orientation;
import pf.project.cnam.model.Ships.Ship;

import java.util.Random;

public class RandomPlacementStrategy implements ShipPlacementStrategy {

    private Random random = new Random();

    @Override
    public void placeShips(Board board) {
        // Exemple de logique pour placer aléatoirement les navires
        for (Ship ship : board.getShips()) {
            int x = random.nextInt(board.getSize());
            int y = random.nextInt(board.getSize());
            Orientation orientation = random.nextBoolean() ? Orientation.HORIZONTAL : Orientation.VERTICAL;
            board.placeShip(ship, x, y, orientation);
        }
    }
}
