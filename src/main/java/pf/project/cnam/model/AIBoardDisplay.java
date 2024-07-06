package pf.project.cnam.model;

public class AIBoardDisplay extends AbstractBoardDisplay {
    @Override
    protected boolean shouldDisplayShip(Cell cell) {
        // Logique pour l'IA, par exemple, afficher un navire coulé
        return cell.isHit() && cell.hasShip();
    }


}
