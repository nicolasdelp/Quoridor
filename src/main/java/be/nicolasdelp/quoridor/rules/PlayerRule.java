package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

/**
 * L'interface PlayerRule structure les regles pour les pions
 *
 * @author Delplanque Nicolas
 */
public interface PlayerRule {

    public void verify(Board board, Player player, Position position) throws RuleViolated;
}