package pf.project.cnam.model;

import pf.project.cnam.model.Ships.Ship;

import java.util.List;

public class BoardState {
    private List<Ship> ships;
    private List<Coordinate> attacks;

    public BoardState(List<Ship> ships, List<Coordinate> attacks) {
        this.ships = ships;
        this.attacks = attacks;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Coordinate> getAttacks() {
        return attacks;
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

    public boolean isAllShipsSunk() {
        // Logique pour vérifier si tous les navires sont coulés
        return false;
    }

}

