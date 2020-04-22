package be.nicolasdelp.quoridor.objects;

/**
* La class Wall représente un objet Mur
*
* @author Delplanque Nicolas
*/
public class Wall extends GamePieces {

    private Position position;
    private WallDirection direction;

    /**
     * Constructeur de Wall
     *
     * @param color la couleur du mur
     * @param position une position
     */
    public Wall() {
        this.position = null;
        this.direction = null;
    }
    
    /**
     * Accesseur de la position du mur
     *
     * @return la position actuelle du mur
     */
    @Override
    public Position getPosition() {
        return this.position;
    }
    
    /**
     * Mutateur de la position du mur
     *
     * @param newPosition la nouvelle position
     */
    @Override
    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }

    /**
     * Accesseur du sens du mur
     *
     * @return le sens du mur (Horizontal ou Vertical)
     */
    public WallDirection getWallDirection() {
        return this.direction;
    }

    /**
     * Mutateur du sens du mur
     *
     * @param direction le sens du mur (Horizontal ou Vertical)
     */
    public void setWallDirection(WallDirection direction) {
        this.direction = direction;
    }
}