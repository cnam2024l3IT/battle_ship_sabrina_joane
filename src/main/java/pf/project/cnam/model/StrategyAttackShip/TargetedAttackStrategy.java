package pf.project.cnam.model.StrategyAttackShip;

import pf.project.cnam.model.Board;

import java.util.Scanner;

public class TargetedAttackStrategy implements AttackStrategy {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void attack(Board board) {
        // base logique pour l'attaque ciblée
        System.out.print("Entrez la coordonnée x pour l'attaque : ");
        int x = scanner.nextInt();
        System.out.print("Entrez la coordonnée y pour l'attaque : ");
        int y = scanner.nextInt();

        board.attack(x, y);
    }
}
