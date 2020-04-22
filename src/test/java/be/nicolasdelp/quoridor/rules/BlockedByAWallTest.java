package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class BlockedByAWallTest {

    @Test
    public void testVerify1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(1, 7));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(3, 7));
        } catch (RuleViolated e) {
            System.out.println(e);
        }
        PlayerRule playerRule = new BlockedByAWall();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 8));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 8));});
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1, 7));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1, 9));
        } catch (RuleViolated e) {
            System.out.println(e);
        }
        PlayerRule playerRule = new BlockedByAWall();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 6));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 10));});
    }
}