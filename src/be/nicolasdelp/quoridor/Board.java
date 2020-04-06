package be.nicolasdelp.quoridor;

import java.util.List;
import java.util.LinkedList;

public class Board {

    private final int totalWall = 20;
    private final int boardSize = 9;
    private final Position[] startPosition = { new Position(8, 0), new Position(8, 16), new Position(0, 8), new Position(16, 8) };
    private Player[] players;
    private Box[][] boardBoxes;
    private List<String> historique;

    private void creatBoard() {
        this.boardBoxes = new Box[(boardSize * 2) - 1][(boardSize * 2) - 1]; // Crée un tableau 17x17 de Box
        for (int i = 0; i < boardBoxes.length; i++) {
            for (int j = 0; j < boardBoxes.length; j++) {
                boardBoxes[i][j].isPawnBox(new Position(i, j)); // Si la case est une case à pion isPawnBox sera égal à True
                boardBoxes[i][j].isWallBox(new Position(i, j)); // Si la case est une case à mur isWallBox sera égal à True
            }
        }
    }

    /**
     * Constructeur
     *
     * @param players la liste des joueurs
     */
    public Board(Player[] players) {
        this.historique = new LinkedList<String>();
        this.players = players;
        creatBoard(); // création du plateau
        for (int i = 0; i < players.length; i++) {
            players[i].setWalls(totalWall / players.length); // donne à chaque joueur ses murs de départ (20/nmbr de joueurs)
            players[i].movePawnOnBoard(startPosition[i]); // mets chaque pion à sa position de départ
        }
    }

    public void isOverLimit(){
        
    }
}