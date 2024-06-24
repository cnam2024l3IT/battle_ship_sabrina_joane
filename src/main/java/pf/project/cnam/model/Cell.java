package pf.project.cnam.model;

public class Cell {
    private final Coordinate coordinate;
    private boolean isHit;

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.isHit = false;
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
}

