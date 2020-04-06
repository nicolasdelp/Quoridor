package be.nicolasdelp.quoridor;

public class Board {

    private final int totalWall = 20;
    private final int boardSize = 9;
    private final Position[] startPosition = { new Position(8, 0), new Position(8, 16), new Position(0, 8), new Position(16, 8) };
    private Player[] players;
    private Box[][] boardBoxes;

    private void creatBoard() {
        this.boardBoxes = new Box[(boardSize * 2) - 1][(boardSize * 2) - 1];
        for (int i = 0; i < boardBoxes.length; i++) {
            for (int j = 0; j < boardBoxes.length; j++) {
                if (boardBoxes[i][j].isPawnBox(i, j)) {
                    boardBoxes[i][j].setPawnBox();
                }
                if (boardBoxes[i][j].isWallBox(i, j)) {
                    boardBoxes[i][j].setWallBox();
                }
            }
        }
    }

    /**
     * Constructeur
     *
     * @param players une liste de joueurs
     */
    public Board(Player[] players){
        this.players = players;
        creatBoard();                                       //création du plateau
        for(int i=0; i<players.length; i++){
            players[i].setWalls(totalWall/players.length);  //donne à chaque joueur ses murs de départ
            players[i].setPawn(startPosition[i]);           //donne à chaque joueur sa position de départ
        }
    }

    public static void main(String[] args) {

    }
}