package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

/**
 * L'interface WallRule structure les regles pour les murs
 *
 * @author Delplanque Nicolas
 */
public interface WallRule {

    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated;
}