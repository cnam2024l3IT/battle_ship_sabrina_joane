package pf.project.cnam.model;

import pf.project.cnam.model.Cell;

public class HumanBoardDisplay extends AbstractBoardDisplay {

    @Override
    protected boolean shouldDisplayShip(Cell cell) {
        return cell.hasShip();
    }
}