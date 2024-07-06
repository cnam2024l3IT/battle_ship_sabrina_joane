package pf.project.cnam.model;

public abstract class AbstractBoardDisplay implements BoardDisplay {

    protected abstract boolean shouldDisplayShip(Cell cell);

    @Override
    public void displayBoard(Board board) {
        int size = board.getSize();

        // Affichage des coordonnées en haut
        System.out.print("  ");
        for (int x = 0; x < size; x++) {
            System.out.print(x + " ");
        }
        System.out.println();

        for (int y = 0; y < size; y++) {
            // Affichage des coordonnées sur le côté
            System.out.print((char) ('A' + y) + " ");
            for (int x = 0; x < size; x++) {
                Cell cell = board.getCell(x, y);
                if (cell.isHit()) {
                    if (cell.hasShip()) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                } else {
                    if (shouldDisplayShip(cell)) {
                        System.out.print("S ");
                    } else {
                        System.out.print("~ ");
                    }
                }
            }
            System.out.println();
        }
    }
}
