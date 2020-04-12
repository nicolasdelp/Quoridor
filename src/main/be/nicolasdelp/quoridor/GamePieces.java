package main.be.nicolasdelp.quoridor;

public abstract class GamePieces {

    public abstract Position getPosition();

    public abstract void setPosition(Position position);
    
    public abstract String getColor();
}