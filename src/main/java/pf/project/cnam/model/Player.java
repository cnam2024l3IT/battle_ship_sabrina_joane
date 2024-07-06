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

    public Board getBoard() {
        return board;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }


    public String getName() {
        return name;
    }

    public BoardDisplay getBoardDisplay() {
        return boardDisplay;
    }

    public void setBoardDisplay(BoardDisplay boardDisplay) {
        this.boardDisplay = boardDisplay;
    }

    public void displayBoard() {
        if (boardDisplay != null) {
            boardDisplay.displayBoard(board);
        }
    }

    public boolean attack(int x, int y) {
        return board.attack(x, y);
    }


}
