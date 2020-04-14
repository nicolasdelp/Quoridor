package be.nicolasdelp.quoridor.OBJECTS;

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
    private int Walls;
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
     * @return le nombre de murs restants du joueur
     */
    public int getWalls() {
        return this.Walls;
    }

    /**
     * Mutateur des murs du joueur
     *
     * @param walls un nombre de murs
     */
    public void setWalls(int walls) {
        this.Walls = walls;
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
     * @param newPosition la nouvelle position
     */
    public void movePawnOnBoard(Position newPosition) {
        this.pawnPlayer.setPosition(newPosition);
    }
}