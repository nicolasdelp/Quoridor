package be.nicolasdelp.quoridor;

public class Position {

    private int x;
    private int y;
    
    /**
     * Constucteur
     * 
     * @param x la colonne
     * @param y la ligne
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Récupérer X
     * 
     * @return X
     */
    public int getX() {
        return x;
    }

    /**
     * Récupérer Y
     * 
     * @return Y
     */
    public int getY() {
        return y;
    }

}