package pf.project.cnam.model.Ships;

public class Ship {
    private final ShipType type;
    private boolean isHit;

    public Ship(ShipType type) {
        this.type = type;
    }

    public ShipType getType() {
        return type;
    }

    public int getSize() {
        return type.getSize();
    }

    public void hit() {
        this.isHit = true;
    }

    public boolean isSunk() {
        return false;
    }
}
