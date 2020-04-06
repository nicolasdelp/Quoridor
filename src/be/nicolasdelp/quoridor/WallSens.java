package be.nicolasdelp.quoridor;

public enum WallSens {

    Horizontal(0), Vertical(1);

    private int sens;

    /**
     * Constructeur
     *
     * @param position Soit HORIZONTAL ou VERTICAL
     */
    private WallSens(int sens) {
        this.sens = sens;
    }

    /**
     * Récupère la position du mur
     *
     * @return HORIZONTAL ou VERTICAL
     */
    public int getWallSens() {
        return this.sens;
    }
}