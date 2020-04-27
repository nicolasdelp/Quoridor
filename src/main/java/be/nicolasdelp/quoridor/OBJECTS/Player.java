package be.nicolasdelp.quoridor.objects;

import java.util.ArrayList;
import java.util.List;

/**
* La class Player représente un objet Joueur
*
* @author Delplanque Nicolas
*/
public class Player {

    private final String type;
    private final String username;
    private final int ID;
    private final Color color;
    private Pawn pawnPlayer;
    private Wall[] walls;
    private int wallIndex = 0;
    private Position[] finishPosition = new Position[9];
    private List<String> historique = new ArrayList<String>();

    /**
     * Constructeur de Player
     *
     * @param type le type de joueur (Ordiateur ou Humain)
     * @param ID ID unique du joueur
     * @param pawn un pion
     */
    public Player(String type, String username, int ID, Color color, Pawn pawn) {
        this.type = type;
        this.username = username;
        this.ID = ID;
        this.color = color;
        this.pawnPlayer = pawn;
    }

    /**
     * Accesseur du type de joueur
     *
     * @return le type du joueur
     */
    public String getType() {
        return this.type;
    }

    /**
     * Accesseur dun pseudo du joueur
     *
     * @return le pseudo du joueur
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Accesseur de l'ID du joueur
     *
     * @return l'ID du joueur
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Accesseur de la couleur du joueur
     *
     * @return la couleur du joueur
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Accesseur du pion du joueur
     *
     * @return le pion du joueur
     */
    public Pawn getPawn() {
        return this.pawnPlayer;
    }

    /**
     * Mutateur du pion du joueur
     *
     * @param pawn un pion
     */
    public void setPawn(Pawn pawn) {
        this.pawnPlayer = pawn;
    }

    /**
     * Accesseur des murs du joueur
     *
     * @return la liste de murs
     */
    public Wall[] getWalls() {
        return this.walls;
    }

    /**
     * Mutateur des murs du joueur
     *
     * @param walls un nombre de murs
     */
    public void setWalls(int walls) {
        this.walls = new Wall[walls];
        this.wallIndex = walls;
        for(int i=0; i<walls; i++){
            this.walls[i] = new Wall();
        }
    }

    /**
     * Accesseur de l'index du prochain mur
     *
     * @return l'index
     */
    public int getWallIndex() {
        return this.wallIndex-1;
    }

    /**
     * Mutateur de la valeur x ou y pour qu'un joueur gagne
     *
     */
    public void setFinishPosition(Position startPosition){
        if(startPosition.getX() == 0 && startPosition.getY() == 8){
            for(int i=0; i< this.finishPosition.length; i++){
                this.finishPosition[i] = new Position(16, 0+i);
            }
        }
        if(startPosition.getX() == 16 && startPosition.getY() == 8){
            for(int i=0; i< this.finishPosition.length; i++){
                this.finishPosition[i] = new Position(0, 0+i);
            }
        }
    }

    /**
     * Accesseur des positions pour gagner
     *
     */
    public Position[] getFinishPosition(){
        return this.finishPosition;
    }

    /**
     * Accesseur de l'historique du joueur
     *
     * @return l'historique du joueur sous forme de List<String>
     */
    public List<String> getHistorique(){
        return this.historique;
    }

    /**
     * Rajoute une étape dans l'historique du joueur
     *
     * @param event un evenement
     */
    public void addEvent(String event){
        this.historique.add(event);
    }

    /**
     * Bouge le pion à une position
     *
     * @param Position la position
     */
    public void movePawn(Position position) {
        this.pawnPlayer.setPosition(position);
    }

    /**
     * Change de sens un mur
     *
     * @param Position la position
     */
    public void turnWall(int indexWall, WallDirection direction) {
        this.walls[indexWall].setWallDirection(direction);
    }

    /**
     * Met un mur à une position sur le plateau
     *
     * @param Position la position
     */
    public void moveWall(Position position) {
        this.walls[getWallIndex()].setPosition(position);
        this.wallIndex--;
    }
}