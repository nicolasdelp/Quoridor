package be.nicolasdelp.quoridor;

import java.util.List;
import java.util.LinkedList;

public class Board {

    private final int totalWall = 20; //nombre de murs au total
    private final int boardSize = 9; //nombre de cases pour pions par côté
    private final Position[] startPosition = { new Position(8, 0), new Position(8, 16), new Position(0, 8), new Position(16, 8) }; //les 4 cases de départ possible
    private Player[] players; //la liste des joueurs
    private Box[][] boardBoxes; //stockage dans un tableau des Box
    private List<String> histoP1; //l'historique des faits de jeux du joueur 1
    private List<String> histoP2; //l'historique des faits de jeux du joueur 2
    private List<String> histoP3; //l'historique des faits de jeux du joueur 3
    private List<String> histoP4; //l'historique des faits de jeux du joueur 4

    private void creatBoard() {
        this.boardBoxes = new Box[(boardSize * 2) - 1][(boardSize * 2) - 1]; // Crée un tableau 17x17 de Box
        for (int i = 0; i < boardBoxes.length; i++) {
            for (int j = 0; j < boardBoxes.length; j++) {
                boardBoxes[i][j].isPawnBox(new Position(i, j)); // Si la case est une case à pion isPawnBox sera égal à True sinon False
                boardBoxes[i][j].isWallBox(new Position(i, j)); // Si la case est une case à mur isWallBox sera égal à True sinon False
            }
        }
    }

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
        creatBoard(); // création du plateau
        for (int i = 0; i < players.length; i++) {
            players[i].setWalls(totalWall / players.length); // donne à chaque joueur ses murs de départ (20/nmbr de joueurs)
            players[i].movePawnOnBoard(startPosition[i]); // mets chaque pion à sa position de départ
        }
    }

    /**
     * Implémente la liste des joueurs
     *
     * @param players la liste des joueurs
     */
    public void setPlayer(Player[] players){
        this.players = players;
    }

    /**
     * Récupère un joueur dans la liste de joueurs
     *
     * @param ID l'ID du joueur
     */
    public Player getPlayer(int ID){
        return this.players[ID];
    }

    /**
     * Implémente un événement dans l'historique de coups
     *
     * @param ID l'ID du joueur
     * @param event un string contenant l'événement ("Le joueur 1 a mis un Mur en (4,5)"" par exemple)
     */
    public void setHistoStep(int ID, String event){
        if(ID == 1){
            this.histoP1.add(event);
        }
        if(ID == 2){
            this.histoP2.add(event);
        }
        if(ID == 3){
            this.histoP3.add(event);
        }
        if(ID == 4){
            this.histoP4.add(event);
        }
    }

    /**
     * Récupère les événements dans l'historique
     *
     * @param ID l'ID du joueur
     */
    public void getHistoStep(int ID){
        if(ID == 1){
            for(int i=0; i<histoP1.size(); i++){
                System.out.println(this.histoP1.get(i));
             }
        }
        if(ID == 2){
            for(int i=0; i<histoP2.size(); i++){
                System.out.println(this.histoP2.get(i));
             }
        }
        if(ID == 3){
            for(int i=0; i<histoP3.size(); i++){
                System.out.println(this.histoP3.get(i));
             }
        }
        if(ID == 4){
            for(int i=0; i<histoP4.size(); i++){
                System.out.println(this.histoP4.get(i));
            }
        }
    }
}