package be.nicolasdelp.quoridor;

public class Wall extends GamePieces implements PlayableGamePieces{

    private int x, y;
    private Board board;
    private WallPosition pos = WallPosition.Horizontal; //Le mur est horizontal de base

    public Wall(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Permet de récupérer l'abcisse du mur
     *
     * @return X
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Permet de récupérer l'ordonnée du mur
     *
     * @return Y
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Implémente des nouvelles coordonnées au mur
     *
     * @param x l'abscisse
     * @param y l'ordonnée
     */
    @Override
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Récupère la direction du mur
     *
     */
    public WallPosition getWallPosition(){
        return pos;
    }

    /**
     * Change la direction du mur
     *
     * @param position la position du mur (HORIZONTAL ou VERTICAL)
     */
    public void setWallPosition(WallPosition position){
        this.pos = position;
    }
}