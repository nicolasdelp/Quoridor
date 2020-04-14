package be.nicolasdelp.quoridor.OBJECTS;

/**
 * La class Board représente un objet Plateau
 *
 * @author Delplanque Nicolas
 */
public class Board {

    private final int totalWall = 20; //nombre de murs au total
    private final int boardSize = 9; //nombre de cases pour pions par cote
    private final Position[] startPosition = { new Position(0, 8), new Position(16, 8), new Position(8, 0), new Position(8, 16) }; //les 4 cases de depart possible
    public Player[] players; //la liste des joueurs
    private Box[][] boardBoxes; //stockage dans un tableau des Box

    /**
     * Constructeur
     *
     * @param players la liste des joueurs
     */
    public Board() {

    }
    
    /**
     * Création du plateau de jeu
     *
     */
    public void createBoard() {
        if(!((players.length == 2) || (players.length == 4))) 
            throw new IllegalArgumentException("Il ne peux y avoir que 2 ou 4 joueurs !");
        for (int i = 0; i < players.length; i++) {
            this.players[i].setWalls(totalWall / players.length); // donne a chaque joueur ses murs de depart (20/nmbr de joueurs)
            this.players[i].movePawn(startPosition[i]); // mets chaque pion a sa position de depart
        }
        this.boardBoxes = new Box[(this.boardSize * 2) - 1][(this.boardSize * 2) - 1]; // Cree un tableau 17x17 de Box
        for (int i = 0; i < this.boardBoxes.length; i++) {
            for (int j = 0; j < this.boardBoxes.length; j++) {
                this.boardBoxes[i][j] = new Box(new Position(i, j));
                this.boardBoxes[i][j].isPawnBox(); // Si la case est une case a pion isPawnBox sera egal a True sinon False
                this.boardBoxes[i][j].isWallBox(); // Si la case est une case a mur isWallBox sera egal a True sinon False
            }
        }
    }

    /**
     * Accesseur de la box en position position
     *
     * @param position une position
     */
    public Box getBoardBox(Position position){
        return this.boardBoxes[position.getX()][position.getY()];
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

    /**
     * Bouge le pion à une position su le plateau
     *
     * @param newPosition la nouvelle position
     */
    public void movePawnOnBoard(Player player, Position newPosition) {
        if((newPosition.getX() > this.boardBoxes.length) || (newPosition.getX() < 0) || (newPosition.getY() > this.boardBoxes.length) || (newPosition.getY() < 0)) 
            throw new IllegalArgumentException("Vous êtes hors des limites du plateau !");
        player.movePawn(newPosition);
    }
}