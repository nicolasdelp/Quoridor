package main.be.nicolasdelp.quoridor;

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
     * Récupère la couleur du pion
     *
     * @return la couleur du pion
     */
    @Override
    public String getColor() {
        return this.color;
    }

    /**
     * Récupère la position du pion
     *
     * @return la position actuelle
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Implémente la nouvelle position du pion
     *
     * @param newPosition la nouvelle position
     */
    @Override
    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }
}