package be.nicolasdelp.quoridor.OBJECTS;

/**
 * La class Box représente un objet Case
 *
 * @author Delplanque Nicolas
 */
public class Box {

    private boolean isPawnBox;
    private boolean isWallBox;
    private boolean isOccuped;
    private GamePieces object;

    /**
     * Constructeur de Box
     *
     */
    public Box() {
        this.isPawnBox = false;
        this.isWallBox = false;
        this.isOccuped = false;
        this.object = null;
    }

    /**
     * Acesseur de la valeur isPawnBox
     * 
     * @return true ou false
     */
    public boolean getisPawnBox() {
        return this.isPawnBox;
    }

    /**
     * Mutateur de la valeur isPawnBox
     * 
     * @param valeur true ou false
     */
    public void setisPawnBox(Boolean valeur) {
        this.isPawnBox = valeur;
    }

    /**
     * Acesseur de la valeur isWallBox
     * 
     * @return true ou false
     */
    public boolean getisWallBox() {
        return this.isWallBox;
    }

    /**
     * Mutateur de la valeur isWallBox
     * 
     * @param valeur true ou false
     */
    public void setisWallBox(Boolean valeur) {
        this.isWallBox = valeur;
    }

    /**
     * Acesseur de la valeur isOccuped
     * 
     * @return true ou false
     */
    public boolean getisOccuped() {
        return this.isOccuped;
    }

    /**
     * Mutateur de la valeur isOccuped
     * 
     * @param valeur true ou false
     */
    public void setisOccuped(Boolean valeur) {
        this.isOccuped = valeur;
    }

    /**
     * Mutateur de la valeur object
     * 
     * @param object true ou false
     */
    public void setObject(GamePieces object) {
        this.object = object;
    }

    /**
     * Verifie si le nombre est impair
     * 
     * @param x un entier
     * @return true ou false
     */
    public static boolean isImpair(int x) {
        if (x % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifie si la case est bien une case à pion
     * 
     */
    public void isPawnBox(Position position) {
        if (isImpair(position.getX()) && isImpair(position.getY())) {
            setisPawnBox(true);
        }
    }

    /**
     * Verifie si la case est bien une case à mur
     *
     */
    public void isWallBox(Position position) {
        if ((isImpair(position.getX()) && !isImpair(position.getY()))
                || (!isImpair(position.getX()) && isImpair(position.getY()))
                || (isImpair(position.getY()) & isImpair(position.getY()))) {
            setisWallBox(true);
        }
    }
}