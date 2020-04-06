package be.nicolasdelp.quoridor;

public class Player {

    private int Walls;
    private Wall[] wallInventory;
    private Pawn pawnPlayer;
    private int ID;

    /**
     * Constructeur
     *
     * @param pawn une pion
     */
    public Player(Pawn pawn, int ID) {
        this.pawnPlayer = pawn;
        this.ID = ID;
    }

    /**
     * Récupère l'ID du joueur
     *
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Implémente un ID au joueur
     *
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Récupère le nombre de murs restant du joueur
     *
     * @return nombre de murs
     */
    public int getWalls() {
        return this.Walls;
    }

    /**
     * Implémente un nombre de mur au joueur
     *
     */
    public void setWalls(int x) {
        this.Walls = x;
    }

    /**
     * Implémente une position au pion
     *
     */
    public void setPawn(Position position) {
        this.pawnPlayer.setCoordinates(position);
    }

}