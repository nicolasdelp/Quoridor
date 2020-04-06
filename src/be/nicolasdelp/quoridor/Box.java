package be.nicolasdelp.quoridor;

public class Box {

    private boolean isPawnBox = false;
    private boolean isWallBox = false;
    private boolean isOccuped = false;
    private GamePieces object;

    /**
     * Constructeur
     *
     * @param position une positon (x, y)
     */
    public Box() {
    }

    /**
     * Vérifie si le nombre est impair
     * 
     * @param x un entier
     * @return vrai si c'est un nombre impair sinon faux
     */
    public static boolean isImpair(int x) {
        if (x % 2 == 1) {
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
    public boolean isPawnBox(int x, int y) {
        if (isImpair(x) && isImpair(y)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Implémente la case comme une case à pion
     * 
     */
    public void setPawnBox() {
        this.isPawnBox = true;
    }

    /**
     * Verifie si la case est bien une case pour un mur
     * 
     * @return vrai si c'est une case pour un mur sinon faux
     */
    public boolean isWallBox(int x, int y) {
        if ((isImpair(x) && !isImpair(y)) || (!isImpair(x) && isImpair(y)) || (isImpair(x) && isImpair(y))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Implémente la case comme une case à mur
     * 
     */
    public void setWallBox() {
        this.isWallBox = true;
    }

    public String getStatut() {
        if (this.isPawnBox == true) {
            return "isPawnBox";
        }
        if (this.isWallBox == true) {
            return "isWallBox";
        } else {
            return "Erreur";
        }
    }
}