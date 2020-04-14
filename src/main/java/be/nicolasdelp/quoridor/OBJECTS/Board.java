package be.nicolasdelp.quoridor.OBJECTS;

import java.util.List;
import java.util.LinkedList;

public class Board {

    private final int totalWall = 20; //nombre de murs au total
    private final int boardSize = 9; //nombre de cases pour pions par cote
    private final Position[] startPosition = { new Position(8, 0), new Position(8, 16), new Position(0, 8), new Position(16, 8) }; //les 4 cases de depart possible
    private Player[] players; //la liste des joueurs
    private Box[][] boardBoxes; //stockage dans un tableau des Box
    private List<String> histoP1; //l historique des faits de jeux du joueur 1
    private List<String> histoP2; //l historique des faits de jeux du joueur 2
    private List<String> histoP3; //l historique des faits de jeux du joueur 3
    private List<String> histoP4; //l historique des faits de jeux du joueur 4

    /**
     * Constructeur
     *
     * @param players la liste des joueurs
     */
    public Board(Player[] players) {
        this.players = players;
        if(players.length == 2){
            this.histoP1 = new LinkedList<String>();
            this.histoP2 = new LinkedList<String>();
        }
        if(players.length == 4){
            this.histoP1 = new LinkedList<String>();
            this.histoP2 = new LinkedList<String>();
            this.histoP3 = new LinkedList<String>();
            this.histoP4 = new LinkedList<String>();
        }
        creatBoard(); // creation du plateau
        for (int i = 0; i < players.length; i++) {
            players[i].setWalls(totalWall / players.length); // donne a chaque joueur ses murs de depart (20/nmbr de joueurs)
            players[i].movePawnOnBoard(startPosition[i]); // mets chaque pion a sa position de depart
        }
    }
    
    /**
     * Créeation du plateau de jeu
     *
     */
    private void creatBoard() {
        this.boardBoxes = new Box[(boardSize * 2) - 1][(boardSize * 2) - 1]; // Cree un tableau 17x17 de Box
        for (int i = 0; i < boardBoxes.length; i++) {
            for (int j = 0; j < boardBoxes.length; j++) {
                boardBoxes[i][j].isPawnBox(new Position(i, j)); // Si la case est une case a pion isPawnBox sera egal a True sinon False
                boardBoxes[i][j].isWallBox(new Position(i, j)); // Si la case est une case a mur isWallBox sera egal a True sinon False
            }
        }
    }

    /**
     * Implemente la liste des joueurs
     *
     * @param players la liste des joueurs
     */
    public void setPlayer(Player[] players){
        this.players = players;
    }

    /**
     * Recupere un joueur dans la liste de joueurs
     *
     * @param ID l ID du joueur
     */
    public Player getPlayer(int ID){
        return this.players[ID];
    }
}