package be.nicolasdelp.quoridor;

public class Box {
    
    private boolean isPawnBox = false;
    private boolean isWallBox = false;
    private GamePieces object;

    public Box(GamePieces object){
        this.object = object;
    }

    /**
     * Vérifie si le nombre est impair
     * 
     * @param x un entier
     * @return vrai si c'est un nombre impair sinon faux
     */
    public static boolean isImpair(int x) {
        if (x%2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifie si la case est bien une case pour un pion
     * 
     * @return vrai si c'est une case pour un mur sinon faux
     */
    public void isPawnBox() {
        if (isImpair(object.getX()) && isImpair(object.getY())){
            this.isPawnBox = true;
        }
    }

    /**
     * Verifie si la case est bien une case pour un mur
     * 
     * @return vrai si c'est une case pour un mur sinon faux
     */
    public void isWallBox() {
        if ((isImpair(object.getX()) && !isImpair(object.getY())) || (!isImpair(object.getX()) && isImpair(object.getY())) || (isImpair(object.getX()) && isImpair(object.getY()))) {
            this.isWallBox = true;
        }
    }

}