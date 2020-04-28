package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class BlockAnotherPlayerTest {

    @Test
    public void testVerify1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,1));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,5));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,9));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,13));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,15));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,11));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,7));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,3));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(9,1));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        WallRule wallRule = new BlockAnotherPlayer();
        Wall wall = new Wall();
        wall.setWallDirection(WallDirection.Horizontal);
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.getPlayers()[1], wall, new Position(9,3));});
    }
}