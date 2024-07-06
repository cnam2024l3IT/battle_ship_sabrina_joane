package pf.project.cnam.model;

import pf.project.cnam.model.Ships.Ship;

public class Cell {
    private final Coordinate coordinate;
    private boolean isHit;
    private Ship ship;

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.isHit = false;
        this.ship = null;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean isHit() {
        return isHit;
    }

    public void hit() {
        this.isHit = true;
    }

    public boolean hasShip() {
        return ship != null;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

}

