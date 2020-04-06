package be.nicolasdelp.quoridor;

public enum WallPosition {

    Horizontal(0), Vertical(1);

    private int sens;

    /**
     * Constructeur
     *
     * @param position Soit HORIZONTAL ou VERTICAL
     */
    private WallPosition(int sens) {
        this.sens = sens;
    }

    /**
     * Récupère la position du mur
     *
     * @return HORIZONTAL ou VERTICAL
     */
    public int getWallPosition() {
        return this.sens;
    }
}