package be.nicolasdelp.quoridor.OBJECTS;

/**
* La class Pawn représente un objet Pion
*
* @author Delplanque Nicolas
*/
public class Pawn extends GamePieces {

    private final Color color;
    private Position position;

    /**
     * Constructeur de Pawn
     *
     * @param color une couleur de pion
     * @param Position une positon
     */
    public Pawn(Color color, Position Position) {
        this.color = color;
        this.position = Position;
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
     * Accesseur de la position du pion
     *
     * @return la position actuelle du pion
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Mutateur de la position du pion
     *
     * @param newPosition la nouvelle position
     */
    @Override
    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }
}