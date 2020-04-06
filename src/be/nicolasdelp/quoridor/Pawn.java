package be.nicolasdelp.quoridor;

public class Pawn extends GamePieces implements PlayableGamePieces{

    private int x, y;
    private Board board;

    /**
     * Constructeur
     *
     * @param Board un plateau (Plateau de jeu)
     * @param x une abscisse
     * @param y une ordonnée
     */
    public Pawn(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
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
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}