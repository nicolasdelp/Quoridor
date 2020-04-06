package be.nicolasdelp.quoridor;

public class Player {

    private int Walls;
    private Wall[] wallInventory;
    private Pawn pawnPlayer;

    /**
     * Constructeur
     *
     * @param pawn une pion
     */
    public Player(Pawn pawn){
        this.pawnPlayer = pawn;
    }

    /**
     * Récupère le nombre de murs restant du joueur
     *
     * @return nombre de murs
     */
    public int getWalls() {
		return Walls;
    }
    
    /**
     * Implémente un nombre de mur au joueur
     *
     */
    public void setWalls(int x) {
		this.Walls = x;
	}

}