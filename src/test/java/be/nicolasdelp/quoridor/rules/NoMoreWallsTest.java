package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class NoMoreWallsTest {

    @Test
    public void testVerify1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(7,3));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(7,5));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(7,7));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(7,9));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(7,11));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1,3));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1,5));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1,7));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1,9));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1,11));
        } catch (RuleViolated e) {
            System.out.println(e);;
        }
        WallRule wallRule = new NoMoreWalls();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[0], new Wall(), new Position(1, 1));});
    }
}