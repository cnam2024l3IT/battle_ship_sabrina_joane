package pf.project.cnam.controller;

import pf.project.cnam.model.*;
import pf.project.cnam.model.StrategyAttackShip.AttackStrategy;
import pf.project.cnam.model.StrategyPlacementShip.ShipPlacementStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController extends Observable {

    private static GameController instance;
    private GameState state;
    private List<Player> players;
    private Player currentTurn;
    private ShipPlacementStrategy shipPlacementStrategy;
    private AttackStrategy attackStrategy;

    private GameController() {
        this.state = GameState.INITIAL;
        this.players = new ArrayList<>();
        // Logs
        System.out.println("GameController initialized. State: " + state);

    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void startGame() {
        if (state == GameState.INITIAL && !players.isEmpty()) {
            System.out.println("Starting game. Current State: " + state + ". Players: " + players.size());
            setState(GameState.PLAYING);
            // logs
            System.out.println("Game started. New State: " + state);
        } else {
            // logs
            System.out.println("Cannot start game. State: " + state + ". Players: " + players.size());
        }
    }

    public void endGame() {
        setState(GameState.GAME_OVER);
        notifyObservers("GameEnded", null);
        System.out.println("Game ended. State: " + state);
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState newState) {
        // logs
        System.out.println("Setting state from " + state + " to " + newState);
        this.state = newState;
        notifyObservers("StateChanged", newState);
        // logs
        System.out.println("State set to: " + newState);

    }

    public void addPlayer(Player player) {
        players.add(player);
        notifyObservers("PlayerAdded", player);
        System.out.println("Player added: " + player.getName() + " State: " + state);

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setCurrentTurn(Player player) {
        this.currentTurn = player;
        notifyObservers("TurnChanged", player);
        System.out.println("Turn changed: " + player.getName() + " State: " + state);

    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setShipPlacementStrategy(ShipPlacementStrategy strategy) {
        this.shipPlacementStrategy = strategy;
        System.out.println("Ship placement strategy set. State: " + state);

    }

    /* public void placeShipsForCurrentPlayer() {
        if (currentTurn != null && shipPlacementStrategy != null) {
            shipPlacementStrategy.placeShips(currentTurn.getBoard());
            notifyObservers("ShipsPlaced", currentTurn);
            System.out.println("Ships placed for: " + currentTurn.getName() + " State: " + state);

        }
    }
*/
    public void placeShipsForCurrentPlayer() {
        if (currentTurn != null && shipPlacementStrategy != null) {
            System.out.println("Placing ships for: " + currentTurn.getName() + ". Current State: " + state);
            shipPlacementStrategy.placeShips(currentTurn.getBoard());
            notifyObservers("ShipsPlaced", currentTurn);
            System.out.println("Ships placed for: " + currentTurn.getName() + ". Current State: " + state);
        } else {
            System.out.println("Cannot place ships. Current turn: " + currentTurn + ". Strategy: " + shipPlacementStrategy);
        }
    }

    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
        System.out.println("Attack strategy set. State: " + state);

    }

    public void attackWithCurrentPlayer() {
        if (currentTurn != null && attackStrategy != null) {
            attackStrategy.attack(currentTurn.getBoard());
            notifyObservers("AttackPerformed", currentTurn);
            System.out.println("Attack performed by: " + currentTurn.getName() + " State: " + state);

        }
    }


    // Partie sérailisation avec le pattern memento
    public void saveGame() {
        // Implémentation de la sauvegarde de jeu
    }

    public void loadGame() {
        // Implémentation du chargement de jeu
    }

}
