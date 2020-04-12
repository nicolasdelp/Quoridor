package main.be.nicolasdelp.quoridor;

public enum Direction {

    UP(0), DOWN(1), LEFT(2), RIGHT(3);

    private final int index;

    /**
     * Constructeur
     *
     * @param index l'index de la driection (0 ou 1 ou 2 ou 3)
     */
    private Direction(int index) {
        this.index = index;
    }

    /**
     * Récupère l'index de la direction
     *
     * @return l'index de la direction
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Récupérer la direction opposée
     * 
     * @return la direction opposée
     */
    public Direction oppositeDirection() {
        if (this == Direction.UP) {
            return Direction.DOWN;
        } 
        if (this == Direction.DOWN) {
            return Direction.UP;
        } 
        if (this == Direction.LEFT) {
            return Direction.RIGHT;
        } 
        else {
            return Direction.LEFT;
        }
    }
}