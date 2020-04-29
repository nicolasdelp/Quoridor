package be.nicolasdelp.quoridor.objects;

import java.io.Serializable;

/**
 * La class abstraite GamePieces permettant de structurer les objets jouables
 *
 * @author Delplanque Nicolas
 */
public abstract class GamePieces  implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public abstract Position getPosition();

    public abstract void setPosition(Position position);
}