package be.nicolasdelp.quoridor.objects;

/**
* La class abstraite GamePieces permettant de structurer les objets jouables
*
* @author Delplanque Nicolas
*/
public abstract class GamePieces {

    public abstract Position getPosition();

    public abstract void setPosition(Position position);
}