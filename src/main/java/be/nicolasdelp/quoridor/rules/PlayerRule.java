package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public interface PlayerRule {

    public void verify(Board board, Player player, Position position) throws RuleViolated;
}