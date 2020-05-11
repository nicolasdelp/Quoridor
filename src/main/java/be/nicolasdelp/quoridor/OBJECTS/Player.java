package be.nicolasdelp.quoridor.objects;

import java.io.Serializable;

/**
 * La class Player represente un objet Joueur
 *
 * @author Delplanque Nicolas
 */
public class Player implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private final String type;
    private final String username;
    private final int ID;
    private final ColorPawn color;
    private Pawn pawnPlayer;
    private int wallIndex;
    private Wall[] stockOfWalls = new Wall[10];
    private boolean outOfWall = false;
    private Position[] finishPosition = new Position[9];
    private String levelIA = null;

    /**
     * Constructeur de Player
     *
     * @param type le type de joueur (Ordiateur ou Humain)
     * @param username un pseudo
     * @param ID ID unique du joueur
     * @param color une couleur
     * @param pawn un pion
     */
    public Player(String type, String username, int ID, ColorPawn color, Pawn pawn) {
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
    public ColorPawn getColor() {
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
     * Mutateur des murs du joueur
     *
     * @param walls un nombre de murs
     */
    public void setWalls(int walls) {
        this.wallIndex = walls-1;
        for(int i =0; i<this.stockOfWalls.length; i++){
            this.stockOfWalls[i] = new Wall();
        }
    }

    /**
     * Accesseur de l'index du prochain mur
     *
     * @return l'index
     */
    public int getWallIndex() {
        return this.wallIndex;
    }

    /**
     * Mutateur de l'index du prochain mur
     *
     */
    public void setWallIndex() {
        this.wallIndex = this.wallIndex-1;
        if(this.wallIndex < 0){
            this.outOfWall = true;
        }
    }

    /**
     * Accesseur du mur actuel
     *
     * @return le mur actuel
     */
    public Wall getCurrentWall() {
        return this.stockOfWalls[this.wallIndex];
    }

    /**
     * Accesseur du stocks de mur
     *
     * @return le stock de mur
     */
    public Wall[] getStockOfWalls() {
        return this.stockOfWalls;
    }

    /**
     * Accesseur de si il reste des murs ou pas
     *
     * @return un boolean
     */
    public boolean getOutOfWalls() {
        return this.outOfWall;
    }

    /**
     * Mutateur de la valeur x ou y pour qu'un joueur gagne
     *
     * @param startPosition la position de depart du joueur
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
     * @return Position[] une liste de position d'arrivee
     */
    public Position[] getFinishPosition(){
        return this.finishPosition;
    }

    /**
     * Mutateur du niveau de l'IA
     *
     * @param level un niveau d'IA
     */
    public void setIALevel(String level){
        this.levelIA = level;
    }

    /**
     * Accesseur du niveau de l'IA
     *
     * @return le niveau de l'IA si le joueur est un ordinateur
     */
    public String getIALevel(){
        return this.levelIA;
    }

    /**
     * Bouge le pion a une position
     *
     * @param position la position
     */
    public void movePawn(Position position) {
        this.pawnPlayer.setPosition(position);
    }

    /**
     * Change de sens un mur
     *
     * @param wall un mur
     * @param direction une direction
     */
    public void turnWall(Wall wall, WallDirection direction) {
        wall.setWallDirection(direction);
    }

    /**
     * Met un mur a une position sur le plateau
     *
     * @param wall un mur
     * @param position la position
     */
    public void moveWall(Wall wall, Position position) {
        wall.setPosition(position);
        setWallIndex();
    }
}