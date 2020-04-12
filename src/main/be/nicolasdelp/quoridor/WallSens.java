package main.be.nicolasdelp.quoridor;

public enum WallSens {

    Horizontal(0), Vertical(1);

    private final int index;

    /**
     * Constructeur
     *
     * @param position Soit HORIZONTAL ou VERTICAL
     */
    private WallSens(int index) {
        this.index = index;
    }

    /**
     * Récupère la position du mur
     *
     * @return HORIZONTAL ou VERTICAL
     */
    public int getWallSens() {
        return this.index;
    }
}