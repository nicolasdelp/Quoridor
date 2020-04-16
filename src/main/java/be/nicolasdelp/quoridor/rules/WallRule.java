package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public interface WallRule {

    public void verify(Board board, Wall wall, Position position) throws RuleViolated;
}