package be.nicolasdelp.quoridor.OBJECTS;

public class Pawn extends GamePieces implements PlayableGamePieces {

    private final String color;
    private Position position;

    /**
     * Constructeur
     *
     * @param color une couleur de pion
     * @param startPosition une positon (x, y)
     */
    public Pawn(String color, Position startPosition) {
        this.color = color;
        this.position = startPosition;
    }

    /**
     * Recupere la couleur du pion
     *
     * @return la couleur du pion
     */
    @Override
    public String getColor() {
        return this.color;
    }

    /**
     * Recupere la position du pion
     *
     * @return la position actuelle
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Implemente la nouvelle position du pion
     *
     * @param newPosition la nouvelle position
     */
    @Override
    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }
}