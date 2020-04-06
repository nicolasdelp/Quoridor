package be.nicolasdelp.quoridor;

public class Pawn extends GamePieces implements PlayableGamePieces{

    private int x, y, dir;
    private Board board;

    public Pawn(Board board, int x, int y, int dir) {
        this.board = board;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    
    /**
     * Permet de récupérer l'abcisse du pion
     *
     * @return X
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Permet de récupérer l'ordonnée du pion
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