package be.nicolasdelp.quoridor.objects;

import java.io.Serializable;

/**
 * La class Box represente un objet Case
 *
 * @author Delplanque Nicolas
 */
public class Box implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private boolean isPawnBox;
    private boolean isWallBox;
    private boolean isOccuped;
    private GamePieces object;
    private final Position position;

    /**
     * Constructeur de Box
     *
     * @param position une position de case
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
     * Accesseur de la valeur object
     * 
     * @return un objet
     */
    public GamePieces getObject() {
        return this.object;
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
     * Verifie si la case est bien une case a pion
     * 
     */
    public void isPawnBox() {
        if (!isImpair(this.position.getX()) && !isImpair(this.position.getY())) {
            setisPawnBox(true);
        }
    }

    /**
     * Verifie si la case est bien une case a mur
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