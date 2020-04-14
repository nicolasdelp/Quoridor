package be.nicolasdelp.quoridor.OBJECTS;

/**
* La class Wall représente un objet Mur
*
* @author Delplanque Nicolas
*/
public class Wall extends GamePieces {

    private final Color color;
    private Position position;
    private WallSens sens = WallSens.Horizontal;

    /**
     * Constructeur de Wall
     *
     * @param color la couleur du mur
     * @param position une position
     */
    public Wall(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    /**
     * Accesseur de la couleur du pion
     *
     * @return la couleur du pion
     */
    @Override
    public Color getColor() {
        return this.color;
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
    public WallSens getWallSens() {
        return this.sens;
    }

    /**
     * Mutateur du sens du mur
     *
     * @param sens le sens du mur (Horizontal ou Vertical)
     */
    public void setWallSens(WallSens sens) {
        this.sens = sens;
    }
}