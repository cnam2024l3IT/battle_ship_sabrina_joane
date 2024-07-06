package pf.project.cnam.model;

import pf.project.cnam.model.Ships.Orientation;
import pf.project.cnam.model.Ships.Ship;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private int size;
    private Cell[][] cells;
    private List<Ship> ships;
    private List<Coordinate> attacks;

    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
        this.ships = new ArrayList<>();
        this.attacks = new ArrayList<>();
        // Initialisation des cellules du plateau avec des objets "Cell" vides
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                cells[x][y] = new Cell(new Coordinate(x, y));
            }
        }

    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Coordinate> getAttacks() {
        return attacks;
    }

    public boolean placeShip(Ship ship, int startX, int startY, Orientation orientation) {
        int shipSize = ship.getSize();
        if (orientation == Orientation.HORIZONTAL) {
            if (startX + shipSize > size) return false;
            for (int i = 0; i < shipSize; i++) {
                if (cells[startX + i][startY].hasShip()) return false;
            }
            for (int i = 0; i < shipSize; i++) {
                cells[startX + i][startY].setShip(ship);
            }
        } else if (orientation == Orientation.VERTICAL) {
            if (startY + shipSize > size) return false;
            for (int i = 0; i < shipSize; i++) {
                if (cells[startX][startY + i].hasShip()) return false;
            }
            for (int i = 0; i < shipSize; i++) {
                cells[startX][startY + i].setShip(ship);
            }
        }
        ships.add(ship);
        return true;
    }


    public void removeShip(Ship ship) {
        ships.remove(ship);
    }

    public boolean attack(int x, int y) {
        Cell cell = cells[x][y];
        if (cell.isHit()) {
            return false; // La case a déjà été attaquée
        }
        cell.hit(); // Marquer la case comme attaquée

        if (cell.hasShip()) {
            cell.getShip().hit(); // Marquer le navire comme touché
            return true; // Attaque réussie
        } else {
            return false; // Aucun navire sur cette case
        }
    }


    public boolean isAllShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false; // Il reste au moins un navire non coulé
            }
        }
        return true; // Tous les navires sont coulés
    }
    public BoardState createMemento() {
        return new BoardState(new ArrayList<>(ships), new ArrayList<>(attacks));
    }

    public void restoreMemento(BoardState memento) {
        this.ships = new ArrayList<>(memento.getShips());
        this.attacks = new ArrayList<>(memento.getAttacks());
    }


}

