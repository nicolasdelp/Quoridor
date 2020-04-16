package be.nicolasdelp.quoridor.objects;

/**
* La class Pawn représente un objet Pion
*
* @author Delplanque Nicolas
*/
public class Pawn extends GamePieces {

    private Position position;

    /**
     * Constructeur de Pawn
     *
     * @param color une couleur de pion
     * @param Position une positon
     */
    public Pawn() {
        this.position = null;
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