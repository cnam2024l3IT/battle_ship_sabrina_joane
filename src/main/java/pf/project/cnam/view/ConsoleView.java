package pf.project.cnam.view;

import pf.project.cnam.controller.GameController;
import pf.project.cnam.model.*;
import pf.project.cnam.model.StrategyAttackShip.RandomAttackStrategy;
import pf.project.cnam.model.StrategyPlacementShip.ManualPlacementStrategy;
import pf.project.cnam.model.StrategyPlacementShip.RandomPlacementStrategy;
import java.util.Scanner;

public class ConsoleView implements Observer {

    private final GameController controller;
    private final Scanner scanner;

    public ConsoleView(GameController controller) {
        this.controller = controller;
        this.controller.addObserver(this);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Bienvenue dans le jeu de bataille navale!");
        setupGame();
        playGame();
    }

    private void setupGame() {
        System.out.println("Initialisation du jeu...");

        // Création des joueurs
        Player humanPlayer = new Player("Joueur Humain", PlayerType.HUMAN);
        Player aiPlayer = new Player("AI", PlayerType.AI);

        // Initialisation des plateaux de jeu
        Board humanBoard = new Board(10);
        Board aiBoard = new Board(10);
        humanPlayer.setBoard(humanBoard);
        aiPlayer.setBoard(aiBoard);

        // Ajoutez des logs pour vérifier l'initialisation des plateaux
        System.out.println("Plateau du joueur humain initialisé: " + humanPlayer.getBoard());
        System.out.println("Plateau de l'IA initialisé: " + aiPlayer.getBoard());


        // Ajouter les joueurs au contrôleur
        controller.addPlayer(humanPlayer);
        controller.addPlayer(aiPlayer);

        // Définir le joueur courant
        controller.setCurrentTurn(humanPlayer);

        // Placement des navires pour l'IA (stratégie aléatoire)
        controller.setShipPlacementStrategy(new RandomPlacementStrategy());
        controller.setCurrentTurn(aiPlayer);
        controller.placeShipsForCurrentPlayer();

        // Placement des navires pour le joueur humain (manuellement)
        controller.setShipPlacementStrategy(new ManualPlacementStrategy());
        controller.setCurrentTurn(humanPlayer);
        controller.placeShipsForCurrentPlayer();

        // Initialiser les affichages des plateaux
        humanPlayer.setBoardDisplay(new HumanBoardDisplay());
        aiPlayer.setBoardDisplay(new AIBoardDisplay());

        // Démarre le jeu après avoir tout initialisé
        controller.startGame();

    }

    private void playGame() {
        while (controller.getState() != GameState.GAME_OVER) {
            if (controller.getState() == GameState.PLAYING) {
                Player currentPlayer = controller.getCurrentTurn();
                System.out.println(currentPlayer.getName() + ", c'est votre tour!");

                if (currentPlayer.getPlayerType() == PlayerType.HUMAN) {
                    performHumanAttack();
                } else {
                    controller.setAttackStrategy(new RandomAttackStrategy());
                    controller.attackWithCurrentPlayer();
                }

                // Afficher les plateaux après chaque tour
                displayBoards();

                if (controller.getPlayers().stream().anyMatch(p -> p.getBoard().isAllShipsSunk())) {
                    controller.endGame();
                } else {
                    switchTurn();
                }
            }
        }

        System.out.println("Le jeu est terminé!");
    }

    private void performHumanAttack() {
        System.out.println("Entrez les coordonnées de votre attaque (par exemple A5) :");
        String input = scanner.nextLine().toUpperCase();
        char xChar = input.charAt(0);
        int y = Integer.parseInt(input.substring(1)) - 1; // Ajuster pour 0-index
        int x = xChar - 'A'; // Convertir A -> 0, B -> 1, etc.

        Player aiPlayer = controller.getPlayers().stream()
                .filter(p -> p.getPlayerType() == PlayerType.AI)
                .findFirst()
                .orElse(null);

        if (aiPlayer != null) {
            boolean hit = aiPlayer.getBoard().attack(x, y);
            System.out.println(hit ? "Touché!" : "Manqué!");

            // Notification de l'attaque effectuée
            controller.notifyObservers("AttackPerformed", aiPlayer);
        }
    }

    private void displayBoards() {
        Player humanPlayer = controller.getPlayers().stream()
                .filter(p -> p.getPlayerType() == PlayerType.HUMAN)
                .findFirst()
                .orElse(null);

        Player aiPlayer = controller.getPlayers().stream()
                .filter(p -> p.getPlayerType() == PlayerType.AI)
                .findFirst()
                .orElse(null);

        if (humanPlayer != null && aiPlayer != null) {
            System.out.println("Plateau du joueur humain:");
            humanPlayer.getBoardDisplay().displayBoard(humanPlayer.getBoard());

            System.out.println("Plateau de l'IA:");
            aiPlayer.getBoardDisplay().displayBoard(aiPlayer.getBoard());
        }
    }

private void switchTurn() {
    Player currentPlayer = controller.getCurrentTurn();
    int nextIndex = (controller.getPlayers().indexOf(currentPlayer) + 1) % controller.getPlayers().size();
    Player nextPlayer = controller.getPlayers().get(nextIndex);
    // Ajoutez un log ici pour voir quel joueur est le suivant
    System.out.println("Changement de tour. Joueur actuel: " + currentPlayer.getName() + ", Prochain joueur: " + nextPlayer.getName());
    controller.setCurrentTurn(nextPlayer);
    // Ajoutez un log ici pour confirmer le changement de tour
    System.out.println("Tour changé vers: " + nextPlayer.getName());
}

    @Override
    public void update(String eventType, Object data) {
        switch (eventType) {
            case "StateChanged":
                System.out.println("L'état du jeu a changé: " + data);
                break;
            case "PlayerAdded":
                Player player = (Player) data;
                System.out.println("Nouveau joueur ajouté: " + player.getName());
                break;
            case "TurnChanged":
                Player playerTurn = (Player) data;
                System.out.println("C'est au tour de: " + playerTurn.getName());
                // Ajoutez un log ici pour voir si le flux continue
                System.out.println("Flux de jeu après changement de tour: " + controller.getCurrentTurn().getName());
                break;
            case "ShipsPlaced":
                Player playerShips = (Player) data;
                System.out.println("Navires placés pour: " + playerShips.getName());
                break;
            case "AttackPerformed":
                Player playerAttack = (Player) data;
                System.out.println("Attaque effectuée par: " + playerAttack.getName());
                break;
            case "GameLoaded":
                System.out.println("Jeu chargé.");
                break;
            case "GameEnded":
                System.out.println("Jeu terminé.");
                break;
        }
    }

}
