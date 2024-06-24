package pf.project.cnam.model;

import pf.project.cnam.model.Ships.Ship;

import java.util.ArrayList;
import java.util.List;

public class BoardState {
    private final List<Ship> ships;
    private final List<Coordinate> attacks;

    public BoardState() {
        this.ships = new ArrayList<>();
        this.attacks = new ArrayList<>();
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void removeShip(Ship ship) {
        ships.remove(ship);
    }

    public void addAttack(Coordinate coordinate) {
        attacks.add(coordinate);
    }
/*
    public boolean isAllShipsSunk() {
        // Logique pour vérifier si tous les navires sont coulés dans l'état du plateau
        return ships.stream().allMatch(ship -> attacks.containsAll("Logique pour vérifier les coordonnées du navire"));
    }*/

    public List<Ship> getShips() {
        return ships;
    }

    public List<Coordinate> getAttacks() {
        return attacks;
    }
}
