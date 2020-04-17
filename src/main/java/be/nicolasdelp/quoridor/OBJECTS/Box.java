package be.nicolasdelp.quoridor.objects;

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
    private final Position position;

    /**
     * Constructeur de Box
     *
     */
    public Box(Position position) {
        this.position = position;
        this.isPawnBox = false;
        this.isWallBox = false;
        this.isOccuped = false;
        this.object = null;
    }

    /**
     * Accesseur de la valeur isPawnBox
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
     * Accesseur de la valeur isWallBox
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
     * Accesseur de la valeur isOccuped
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
        this.isOccuped = true;
    }

    /**
     * Supprime l'objet de la case
     * 
     */
    public void removeObject() {
        this.object = null;
        this.isOccuped = false;
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
    public void isPawnBox() {
        if (!isImpair(this.position.getX()) && !isImpair(this.position.getY())) {
            setisPawnBox(true);
        }
    }

    /**
     * Verifie si la case est bien une case à mur
     *
     */
    public void isWallBox() {
        if ((isImpair(this.position.getX()) && !isImpair(this.position.getY()))
                || (!isImpair(this.position.getX()) && isImpair(this.position.getY()))
                || (isImpair(this.position.getY()) & isImpair(this.position.getY()))) {
            setisWallBox(true);
        }
    }
}