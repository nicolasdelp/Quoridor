package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class RuleViolated extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private Player player;
    private Position position;
    private Board board;

    public RuleViolated(Player player, Position position, Board board, String message){
        super(message);
        this.player = player;
        this.position = position;
        this.board = board;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Position getPosition() {
        return this.position;
    }

    public Board getBoard() {
        return this.board;
    }
}