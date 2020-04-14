package be.nicolasdelp.quoridor.OBJECTS;

/**
* L'enum WallSens représente les sens possible pour les murs
*
* @author Delplanque Nicolas
*/
public enum WallSens {

    Horizontal(0), Vertical(1);

    private final int index;

    /**
     * Constructeur de WallSens
     *
     * @param index 0 ou 1
     */
    private WallSens(int index) {
        this.index = index;
    }

    /**
     * Accesseur du sens du mur
     *
     * @return 0 ou 1
     */
    public int getWallSens() {
        return this.index;
    }
}