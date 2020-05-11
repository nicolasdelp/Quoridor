package be.nicolasdelp.quoridor.objects;

/**
* L'enum ColorPawn represente les couleurs possible pour les murs/pions
*
* @author Delplanque Nicolas
*/
public enum ColorPawn {

    Rouge(0), Bleu(1), Vert(2), Jaune(3);

    private final int index;

    /**
     * Constructeur de Color
     *
     * @param index 0 ou 1 ou 2 ou 3
     */
    private ColorPawn(int index) {
        this.index = index;
    }

    /**
     * Accesseur de l'index de la couleur
     *
     * @return 0 ou 1 ou 2 ou 3
     */
    public int getColor() {
        return this.index;
    }
}