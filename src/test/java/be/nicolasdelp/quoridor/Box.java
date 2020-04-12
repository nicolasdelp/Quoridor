package be.nicolasdelp.quoridor;

public class Box {

    private boolean isPawnBox;
    private boolean isWallBox;
    private boolean isOccuped;
    private GamePieces object;

    /**
     * Constructeur
     *
     */
    public Box() {
        this.isPawnBox = false;
        this.isWallBox = false;
        this.isOccuped = false;
    }

    /**
     * Verifie si la case est occupe par un objet
     * 
     */
    public boolean isOccuped() {
        return this.isOccuped;
    }

    /**
     * Retourne l objet qui occupe la case
     * 
     */
    public GamePieces isOccupedBy() {
        if (this.isOccuped){
            return this.object;
        }
        else{
            return null;
        }
    }

    /**
     * Implemente un objet dans la case
     * 
     */
    public void setObjectInBox(GamePieces object) {
        this.object = object;
    }

    /**
     * Recupere la valeur de isPawnBox
     * 
     * @return la valeur de isPawnBox (true ou false)
     */
    public boolean getPawnBox() {
        return this.isPawnBox;
    }

    /**
     * Verifie si la case est bien une case pour un pion
     * 
     */
    public void isPawnBox(Position position) {
        if (isImpair(position.getX()) && isImpair(position.getY())) {
            this.isPawnBox = true;
        }
    }

    /**
     * Recupere la valeur de isWallBox
     * 
     * @return la valeur de isWallBox (true ou false)
     */
    public boolean getWallBox() {
        return this.isWallBox;
    }

    /**
     * Verifie si la case est bien une case pour un mur
     *
     */
    public void isWallBox(Position position) {
        if ((isImpair(position.getX()) && !isImpair(position.getY()))
                || (!isImpair(position.getX()) && isImpair(position.getY()))
                || (isImpair(position.getY()) & isImpair(position.getY()))) {
            this.isWallBox = true;
        }
    }

    /**
     * Verifie si le nombre est impair
     * 
     * @param x un entier
     * @return vrai si c est un nombre impair sinon faux
     */
    public static boolean isImpair(int x) {
        if (x % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}