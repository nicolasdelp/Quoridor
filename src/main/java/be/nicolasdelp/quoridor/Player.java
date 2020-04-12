package main.java.be.nicolasdelp.quoridor;

public class Player {

    private final int ID;
    private Pawn pawnPlayer;
    private int Walls;

    /**
     * Constructeur
     *
     * @param ID l ID unique du joueur
     * @param pawn une pion
     */
    public Player(int ID, Pawn pawn) {
        this.ID = ID;
        this.pawnPlayer = pawn;
    }

    /**
     * Recupere l ID unique du joueur
     *
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Recupere le nombre de murs restant du joueur
     *
     * @return nombre de murs
     */
    public int getWalls() {
        return this.Walls;
    }

    /**
     * Implemente un nombre de mur au joueur
     *
     */
    public void setWalls(int x) {
        this.Walls = x;
    }

    /**
     * Implemente une position au pion
     *
     */
    public void movePawnOnBoard(Position position) {
        this.pawnPlayer.setPosition(position);
    }

}