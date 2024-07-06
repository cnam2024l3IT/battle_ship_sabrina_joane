package pf.project.cnam.model.StrategyPlacementShip;

import pf.project.cnam.model.Board;
import pf.project.cnam.model.Coordinate;
import pf.project.cnam.model.Ships.Orientation;
import pf.project.cnam.model.Ships.Ship;
import pf.project.cnam.model.Ships.ShipType;

import java.util.Scanner;

public class ManualPlacementStrategy implements ShipPlacementStrategy {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void placeShips(Board board) {
        System.out.println("Veuillez placer vos navires.");
        for (ShipType shipType : ShipType.values()) {
            System.out.println("Placement du navire " + shipType.getName() + " (taille " + shipType.getSize() + "):");
            System.out.println("Entrez les coordonnées de départ (par exemple A5) et l'orientation (h pour horizontal, v pour vertical):");
            String input = scanner.nextLine().toUpperCase();
            char xChar = input.charAt(0);
            int y = Integer.parseInt(input.substring(1)) - 1; // Ajuster pour 0-index
            int x = xChar - 'A'; // Convertir A -> 0, B -> 1, etc.

            Orientation orientation = input.charAt(2) == 'H' ? Orientation.HORIZONTAL : Orientation.VERTICAL;

            Ship ship = new Ship(shipType);
            boolean placed = board.placeShip(ship, x, y, orientation);

            while (!placed) {
                System.out.println("Emplacement invalide. Veuillez réessayer.");
                input = scanner.nextLine().toUpperCase();
                xChar = input.charAt(0);
                y = Integer.parseInt(input.substring(1)) - 1;
                x = xChar - 'A';
                placed = board.placeShip(ship, x, y, orientation);
            }
        }
    }
}
