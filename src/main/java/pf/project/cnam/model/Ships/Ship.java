package pf.project.cnam.model.Ships;

public class Ship {
    private final String type;
    private final int size;

    public Ship(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}