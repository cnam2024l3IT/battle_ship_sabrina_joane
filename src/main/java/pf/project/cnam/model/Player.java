package pf.project.cnam.model;

public class Player {
    private final String name;
    private Board board;
    private final PlayerType playerType;
    private BoardDisplay boardDisplay;

    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setBoardDisplay(BoardDisplay boardDisplay) {
        this.boardDisplay = boardDisplay;
    }

    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }
}
