package be.nicolasdelp.quoridor.objects;

import java.io.Serializable;

import be.nicolasdelp.quoridor.rules.*;

/**
 * La class Board represente un objet Plateau
 *
 * @author Delplanque Nicolas
 */
public class Board implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private final int totalWall = 20; // nombre de murs au total
    private final int boardSize = 9; //nombre de cases pour pions par cote
    private final Position[] startPosition = { new Position(0, 8), new Position(16, 8) }; //les 2 cases de depart possible
    private Player[] players; //la liste des joueurs
    private Box[][] boardBoxes; //stockage dans un tableau des Box
    private PlayerRule[] playerRules = {new PlayerIsInBounds(), new IsAWallBox(), new PawnAlreadyHere(), new BlockedByAWall(), new IllegalMovement()};
    private WallRule[] wallRules = {new WallIsInBounds(), new IsAPawnBox(), new WallAlreadyHere(), new NoMoreWalls(), new BlockAnotherPlayer()};
    private int currentIDPlayer = 0;
    private boolean win = false;
    private String winner = null;
    private Player winnerPlayer = null;

    /**
     * Constructeur
     *
     */
    public Board() {

    }

    /**
     * Accesseur du tableau contenant les box
     *
     * @return Box[][] un double tableau de cases
     */
    public Box[][] getBoardBoxes(){
        return this.boardBoxes;
    }

    /**
     * Accesseur de la liste des joueurs
     *
     * @return players[] une liste de joueur
     */
    public Player[] getPlayers(){
        return this.players;
    }

    /**
     * Recupere un joueur grâce a son ID dans la liste Players
     *
     * @param ID du joueur
     * @return un joueur
     */
    public Player getAPlayer(int ID){
        Player res = null;
        for(int i=0; i<this.players.length; i++){
            if(players[i].getID() == ID){
                res = this.players[i];
            }
        }
        return res;
    }

    /**
     * Implemente une liste de joueurs
     *
     * @param players la liste des joueurs
     */
    public void setPlayer(Player[] players){
        this.players = players;
    }

    /**
     * Accesseur la largueur du plateau
     *
     * @return la longeur du tableau
     */
    public int getLength(){
        return boardBoxes.length;
    }

    /**
     * Accesseur la longueur du plateau
     *
     * @return la largeur du tableau
     */
    public int getWidth(){
        return boardBoxes[0].length;
    }

    /**
     * Recupere l'ID du joueur qui joue actuellement
     *
     * @return l'ID du joueur actuel
     */
    public int getcurrentIDPlayer(){
        return this.currentIDPlayer;
    }

    /**
     * Passe au joueur suivant
     *
     */
    public void nextPlayer(){
        this.currentIDPlayer++;
        this.currentIDPlayer = this.currentIDPlayer%2;
    }

    /**
     * Recupere si on a gagne
     * 
     *@return vrai ou faux
     */
    public boolean getWin(){
        return this.win;
    }

    /**
     * Recupere le nom du gagnant
     *
     * @return le nom du joueur gagnant
     */
    public String getWinner(){
        return this.winner;
    }

    /**
     * Recupere le joueur gagnant
     *
     * @return le joueur gagnant
     */
    public Player getWinnerPlayer(){
        return this.winnerPlayer;
    }

    /**
     * Creation du plateau de jeu
     *
     */
    public void createBoard() {
        if(this.players.length != 2){
            throw new IllegalArgumentException("Il ne peux y avoir que 2 ou 4 joueurs !");
        }
        this.boardBoxes = new Box[(2*this.boardSize) - 1][(2*this.boardSize) - 1]; // Cree un tableau 17x17 de Box
        for (int i = 0; i < this.boardBoxes.length; i++) {
            for (int j = 0; j < this.boardBoxes.length; j++) {
                this.boardBoxes[i][j] = new Box(new Position(i, j)); //Donne a chaque box une Position(x,y)
                this.boardBoxes[i][j].isPawnBox(); // Si la case est une case a pion isPawnBox sera egal a True sinon False
                this.boardBoxes[i][j].isWallBox(); // Si la case est une case a mur isWallBox sera egal a True sinon False
            }
        }
        for (int i = 0; i < this.players.length; i++) {
            this.players[i].setWalls(this.totalWall / this.players.length); // donne a chaque joueur ses murs de depart (20/nmbr de joueurs)
            this.players[i].movePawn(this.startPosition[i]); // mets chaque pion a sa position de depart
            this.players[i].setFinishPosition(this.startPosition[i]); //Position d'arrivee
            this.boardBoxes[this.startPosition[i].getX()][this.startPosition[i].getY()].setObject(players[i].getPawn());//Met un objet pion dans leur casde de depart
        }
    }

    /**
     * Bouge le pion a une position sur le plateau
     *
     * @param player un joueur
     * @param newPosition la nouvelle position
     * @throws RuleViolated les regles du jeu
     */
    public void movePawnOnBoard(Player player, Position newPosition) throws RuleViolated{
        for(int i=0; i<this.playerRules.length; i++){
            playerRules[i].verify(this, player, newPosition); //Verifie si il n'y a pas d'exceptions
        }
        Position old = player.getPawn().getPosition(); //On recupere l'ancienne position du pion 
        boardBoxes[old.getX()][old.getY()].removeObject(); //On nettoie l'ancienne case
        player.movePawn(newPosition); //On bouge le pion
        boardBoxes[newPosition.getX()][newPosition.getY()].setObject(player.getPawn()); //On assigne a la box d'arrivee qu'un objet est dedans
        for(int i=0; i<player.getFinishPosition().length; i++){ //Si on a gagne
            if(newPosition.getX() == player.getFinishPosition()[i].getX() && newPosition.getY() == player.getFinishPosition()[i].getY()){
                // System.out.println(player.getUsername() + " a gagne");
                this.win = true;
                this.winner = player.getUsername();
                this.winnerPlayer = player;
            }
        }
    }

    /**
     * Place un mur a une position sur le plateau
     *
     * @param player un joueur
     * @param wall un mur
     * @param direction une direction
     * @param position une position
     * @throws RuleViolated les regles du jeu
     */
    public void setWallOnBoard(Player player, Wall wall, WallDirection direction, Position position) throws RuleViolated{
        player.turnWall(wall, direction);
        for(int i=0; i<this.wallRules.length; i++){
            wallRules[i].verify(this, player, wall, position); //Verifie si il n'y a pas d'exceptions
        }
        player.moveWall(wall, position); //On donne au mur sa position
        if(direction == WallDirection.Horizontal){ //Si il est horizontal on remplie les case a sa droite et a sa gauche
            boardBoxes[position.getX()][position.getY()].setObject(wall);
            boardBoxes[position.getX()+1][position.getY()].setObject(wall);
            boardBoxes[position.getX()-1][position.getY()].setObject(wall);
        }
        if(direction == WallDirection.Vertical){ //Si il est vertical on remplie les case au dessus et en dessous
            boardBoxes[position.getX()][position.getY()].setObject(wall);
            boardBoxes[position.getX()][position.getY()+1].setObject(wall);
            boardBoxes[position.getX()][position.getY()-1].setObject(wall);
        }
    }
}