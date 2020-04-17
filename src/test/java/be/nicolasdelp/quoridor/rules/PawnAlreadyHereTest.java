package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class PawnAlreadyHereTest {

    @Test
    public void testVerify1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 8));
            b.movePawnOnBoard(b.players[0], new Position(8, 8));
            b.movePawnOnBoard(b.players[1], new Position(14, 8));
            b.movePawnOnBoard(b.players[1], new Position(12, 8));
            b.movePawnOnBoard(b.players[1], new Position(10, 8));
            b.movePawnOnBoard(b.players[1], new Position(10, 6));
            b.movePawnOnBoard(b.players[1], new Position(8, 6));
            b.movePawnOnBoard(b.players[1], new Position(6, 6));
            b.movePawnOnBoard(b.players[1], new Position(6, 8));
        } catch (RuleViolated e) {
            System.out.println(e);
        }
        PlayerRule playerRule = new PawnAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, b.players[0], new Position(6, 8));
          });
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 8));
            b.movePawnOnBoard(b.players[0], new Position(8, 8));
            b.movePawnOnBoard(b.players[1], new Position(14, 8));
            b.movePawnOnBoard(b.players[1], new Position(12, 8));
            b.movePawnOnBoard(b.players[1], new Position(10, 8));
            b.movePawnOnBoard(b.players[1], new Position(10, 6));
            b.movePawnOnBoard(b.players[1], new Position(8, 6));
        } catch (RuleViolated e) {
            Assertions.fail("rule violated");
        }
        PlayerRule playerRule = new PawnAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, b.players[0], new Position(8, 6));
          });
    }

    @Test
    public void testVerify3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 8));
            b.movePawnOnBoard(b.players[0], new Position(8, 8));
            b.movePawnOnBoard(b.players[1], new Position(14, 8));
            b.movePawnOnBoard(b.players[1], new Position(12, 8));
            b.movePawnOnBoard(b.players[1], new Position(10, 8));
        } catch (RuleViolated e) {
            Assertions.fail("rule violated");
        }
        PlayerRule playerRule = new PawnAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, b.players[0], new Position(10, 8));
          });
    }

    @Test
    public void testVerify4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 8));
            b.movePawnOnBoard(b.players[0], new Position(8, 8));
            b.movePawnOnBoard(b.players[1], new Position(14, 8));
            b.movePawnOnBoard(b.players[1], new Position(12, 8));
            b.movePawnOnBoard(b.players[1], new Position(10, 10));
            b.movePawnOnBoard(b.players[1], new Position(8, 10));
        } catch (RuleViolated e) {
            Assertions.fail("rule violated");
        }
        PlayerRule playerRule = new PawnAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, b.players[0], new Position(8, 10));
          });
    }
}