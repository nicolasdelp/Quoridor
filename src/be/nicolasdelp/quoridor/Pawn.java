package be.nicolasdelp.quoridor;

public class Pawn extends GamePieces implements PlayableGamePieces {

    private int x, y;

    /**
     * Constructeur
     *
     * @param color une couleur de pion
     * @param position une positon (x, y)
     */
    public Pawn(String color, Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    /**
     * Récupère l'abcisse du pion
     *
     * @return X
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Récupère l'ordonnée du pion
     *
     * @return Y
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Implémente des nouvelles coordonnées au pion
     *
     * @param x l'abscisse
     * @param y l'ordonnée
     */
    @Override
    public void setCoordinates(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }
}