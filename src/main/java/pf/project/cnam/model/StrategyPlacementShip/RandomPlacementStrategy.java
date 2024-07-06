package pf.project.cnam.model.StrategyPlacementShip;

import pf.project.cnam.model.Board;
import pf.project.cnam.model.Ships.Orientation;
import pf.project.cnam.model.Ships.Ship;
import pf.project.cnam.model.Ships.ShipType;

import java.util.Random;
import java.util.Scanner;

public class RandomPlacementStrategy implements ShipPlacementStrategy {
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);


    @Override
    public void placeShips(Board board) {
        for (ShipType shipType : ShipType.values()) {
            String input = scanner.nextLine().toUpperCase();

            Orientation orientation = input.charAt(2) == 'H' ? Orientation.HORIZONTAL : Orientation.VERTICAL;
            boolean placed;
            do {
                int size = board.getSize();
                int x = random.nextInt(size);
                int y = random.nextInt(size);
                boolean horizontal = random.nextBoolean();

                Ship ship = new Ship(shipType);
                placed = board.placeShip(ship, x, y, orientation);
            } while (!placed);
        }
    }
}
