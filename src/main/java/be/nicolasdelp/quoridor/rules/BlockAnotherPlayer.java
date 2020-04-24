package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class BlockAnotherPlayer implements WallRule {

    private Board boardCopy = new Board();

    @Override
    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated{
        for (int i= 0; i < board.getLength(); i++){ //Copie du board
            System.arraycopy(board.getBoardBoxes()[i], 0, this.boardCopy.getBoardBoxes()[i], 0, board.getBoardBoxes()[i].length);
        }
        this.boardCopy.getBoardBoxes()[position.getX()][position.getY()].setObject(wall);
    }
}