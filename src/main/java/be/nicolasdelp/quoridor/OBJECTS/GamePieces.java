package be.nicolasdelp.quoridor.OBJECTS;

public abstract class GamePieces {

    public abstract Position getPosition();

    public abstract void setPosition(Position position);
    
    public abstract String getColor();
}