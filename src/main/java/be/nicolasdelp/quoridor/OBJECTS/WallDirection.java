package be.nicolasdelp.quoridor.objects;

/**
* L'enum WallDirection represente les sens possible pour les murs
*
* @author Delplanque Nicolas
*/
public enum WallDirection {

    Horizontal(0), Vertical(1);

    private final int index;

    /**
     * Constructeur de WallDirection
     *
     * @param index 0 ou 1
     */
    private WallDirection(int index) {
        this.index = index;
    }

    /**
     * Accesseur du sens du mur
     *
     * @return 0 ou 1
     */
    public int getWallDirection() {
        return this.index;
    }
}