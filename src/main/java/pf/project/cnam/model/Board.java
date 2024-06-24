package pf.project.cnam.model;

import pf.project.cnam.model.Ships.Ship;
import pf.project.cnam.model.Ships.Orientation;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<Ship> ships;
    private List<Coordinate> attacks;

    public Board(int size) {
        this.size = size;
        this.ships = new ArrayList<>();
        this.attacks = new ArrayList<>();
    }

    public void placeShip(Ship ship, int x, int y, Orientation orientation) {
        // Logique pour placer un navire sur le plateau
    }

    public void removeShip(Ship ship) {
        // Logique pour retirer un navire du plateau
    }

    public boolean attack(int x, int y) {
        // Logique pour exécuter une attaque sur le plateau
        return false;
    }

    public boolean isAllShipsSunk() {
        // Logique pour vérifier si tous les navires sont coulés
        return false;
    }
}
