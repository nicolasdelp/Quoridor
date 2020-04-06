package be.nicolasdelp.quoridor;

public enum WallPosition {

    Horizontal(0), Vertical(1);

    private int position;

    /**
     * Constructeur
     *
     * @param index Soit HORIZONTAL ou VERTICAL
     */
    private WallPosition(int index){
        this.position = index;
    }

    /**
     * Récupère la position du mur
     *
     * @return HORIZONTAL ou VERTICAL
     */
    public int getWallPosition(){
        return this.position;
    }

    public static void main(String[] args) {
        WallPosition x = WallPosition.Horizontal;
        System.out.println(x.getWallPosition());
    }

}