package be.nicolasdelp.quoridor;

public class Wall extends GamePieces implements PlayableGamePieces {

    private final String color;
    private Position position;
    private WallSens sens = WallSens.Horizontal; // Le mur est horizontal de base pour etre stocke

    /**
     * Constructeur
     *
     * @param color la couleur des murs (la meme que le pion du joueur)
     * @param startPosition la position de depart
     */
    public Wall(String color, Position startPosition) {
        this.color = color;
        this.position = startPosition;
    }

    /**
     * Recupere la couleur du pion
     *
     * @return la couleur du pion
     */
    @Override
    public String getColor() {
        return this.color;
    }
    
    /**
     * Recupere la position du mur
     *
     * @return la position actuelle
     */
    @Override
    public Position getPosition() {
        return position;
    }
    
    /**
     * Implemente une nouvelle position
     *
     * @param newPosition la nouvelle position
     */
    @Override
    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }

    /**
     * Recupere le sens du mur
     *
     */
    public WallSens getWallSens() {
        return sens;
    }

    /**
     * Change la direction du mur
     *
     * @param position la position du mur (HORIZONTAL ou VERTICAL)
     */
    public void setNewWallSens(WallSens sens) {
        this.sens = sens;
    }
}