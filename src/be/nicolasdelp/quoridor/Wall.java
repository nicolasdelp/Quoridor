package be.nicolasdelp.quoridor;

public class Wall extends GamePieces implements PlayableGamePieces {

    private int x, y;
    private WallPosition sens = WallPosition.Horizontal; // Le mur est horizontal de base pour être stocké

    /**
     * Constructeur
     *
     * @param position une positon (x, y)
     */
    public Wall(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    /**
     * Récupère l'abcisse du mur
     *
     * @return X
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Récupère l'ordonnée du mur
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
    public void setCoordinates(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    /**
     * Récupère la direction du mur
     *
     */
    public WallPosition getWallPosition() {
        return sens;
    }

    /**
     * Change la direction du mur
     *
     * @param position la position du mur (HORIZONTAL ou VERTICAL)
     */
    public void setWallPosition(WallPosition sens) {
        this.sens = sens;
    }
}