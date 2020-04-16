package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class WallBlocksPawnTest {

    @Test
    public void testVerify(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        b.players[0].movePawn(new Position(2, 2));
        b.setWallOnBoard(b.players[0], b.players[0].getWalls()[0], WallDirection.Horizontal, new Position(1, 2));
        WallRule wallRule = new WallBlocksPawn();
        Assertions.assertThrows(RuleViolated.class, () -> {
            wallRule.verify(b, b.players[0], new Wall(), new Position(0, 2));
          });
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        b.players[0].movePawn(new Position(2, 2));
        b.setWallOnBoard(b.players[0], b.players[0].getWalls()[0], WallDirection.Horizontal, new Position(2, 1));
        WallRule wallRule = new WallBlocksPawn();
        Assertions.assertThrows(RuleViolated.class, () -> {
            wallRule.verify(b, b.players[0], new Wall(), new Position(2, 0));
          });
    }

    @Test
    public void testVerify3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        b.players[0].movePawn(new Position(2, 2));
        b.setWallOnBoard(b.players[0], b.players[0].getWalls()[0], WallDirection.Horizontal, new Position(3, 2));
        WallRule wallRule = new WallBlocksPawn();
        Assertions.assertThrows(RuleViolated.class, () -> {
            wallRule.verify(b, b.players[0], new Wall(), new Position(4, 2));
          });
    }

    @Test
    public void testVerify4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        b.players[0].movePawn(new Position(2, 2));
        b.setWallOnBoard(b.players[0], b.players[0].getWalls()[0], WallDirection.Horizontal, new Position(2, 3));
        WallRule wallRule = new WallBlocksPawn();
        Assertions.assertThrows(RuleViolated.class, () -> {
            wallRule.verify(b, b.players[0], new Wall(), new Position(2, 4));
          });
    }
}