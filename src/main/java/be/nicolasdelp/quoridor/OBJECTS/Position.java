package be.nicolasdelp.quoridor.OBJECTS;

/**
* La class Position représente un objet Position
*
* @author Delplanque Nicolas
*/
public class Position {

    private int x;
    private int y;
    
    /**
     * Constucteur de Position
     * 
     * @param x la colonne
     * @param y la ligne
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Accesseur de x
     * 
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Accesseur de y
     * 
     * @return y
     */
    public int getY() {
        return this.y;
    }
}