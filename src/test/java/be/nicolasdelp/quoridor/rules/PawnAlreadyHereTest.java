package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class PawnAlreadyHereTest {

    @Test
    public void testVerify1(){ //A gauche
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
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
    public void testVerify2(){ //Au dessus
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
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
    public void testVerify3(){ //A droite
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
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
    public void testVerify4(){ //En dessous
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
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

    @Test
    public void testVerify5(){ //En haut à droite
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
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
        } catch (RuleViolated e) {
            Assertions.fail("rule violated");
        }
        PlayerRule playerRule = new PawnAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, b.players[0], new Position(10, 6));
          });
    }

    @Test
    public void testVerify6(){ //En bas à droite
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
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
            b.movePawnOnBoard(b.players[1], new Position(10, 10));
        } catch (RuleViolated e) {
            Assertions.fail("rule violated");
        }
        PlayerRule playerRule = new PawnAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, b.players[0], new Position(10, 10));
          });
    }

    @Test
    public void testVerify7(){ //En haut à gauche
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 6));
            b.movePawnOnBoard(b.players[1], new Position(14, 8));
            b.movePawnOnBoard(b.players[1], new Position(12, 8));
            b.movePawnOnBoard(b.players[1], new Position(10, 8));
            b.movePawnOnBoard(b.players[1], new Position(8, 8));
        } catch (RuleViolated e) {
            Assertions.fail("rule violated");
        }
        PlayerRule playerRule = new PawnAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, b.players[1], new Position(6, 6));
          });
    }

    @Test
    public void testVerify8(){ //En bas à gauche
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 10));
            b.movePawnOnBoard(b.players[1], new Position(14, 8));
            b.movePawnOnBoard(b.players[1], new Position(12, 8));
            b.movePawnOnBoard(b.players[1], new Position(10, 8));
            b.movePawnOnBoard(b.players[1], new Position(8, 8));
        } catch (RuleViolated e) {
            Assertions.fail("rule violated");
        }
        PlayerRule playerRule = new PawnAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, b.players[1], new Position(6, 10));
          });
    }
}