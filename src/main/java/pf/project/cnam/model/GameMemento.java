package pf.project.cnam.model;
import java.util.List;
import java.util.Map;

public class GameMemento {
    private GameState state;
    private List<Player> players;
    private Player currentTurn;
    private Map<Player, BoardState> boardStates;

    public GameMemento(GameState state, List<Player> players, Player currentTurn, Map<Player, BoardState> boardStates) {
        this.state = state;
        this.players = players;
        this.currentTurn = currentTurn;
        this.boardStates = boardStates;
    }

    public GameState getState() {
        return state;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public Map<Player, BoardState> getBoardStates() {
        return boardStates;
    }
}
