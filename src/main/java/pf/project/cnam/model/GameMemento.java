package pf.project.cnam.model;

import java.util.List;
import java.util.Map;

public class GameMemento {
    private GameState state;
    private List<Player> players;
    private Player currentTurn;
    private Map<Player, BoardState> boardStates;

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }

    public Map<Player, BoardState> getBoardStates() {
        return boardStates;
    }

    public void setBoardStates(Map<Player, BoardState> boardStates) {
        this.boardStates = boardStates;
    }
}
