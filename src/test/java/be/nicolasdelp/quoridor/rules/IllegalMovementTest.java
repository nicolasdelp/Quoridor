package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class IllegalMovementTest {

    @Test
    public void testVerify1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 8));
            b.movePawnOnBoard(b.players[0], new Position(8, 8));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        PlayerRule playerRule = new IllegalMovement();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 8));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(12, 8));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(8, 4));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(8, 12));});
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 8));
            b.movePawnOnBoard(b.players[0], new Position(8, 8));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        PlayerRule playerRule = new IllegalMovement();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(10, 6));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(10, 10));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(6, 6));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(6, 10));});
    }

    @Test
    public void testVerify3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        PlayerRule playerRule = new IllegalMovement();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 6));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 10));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 6));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 10));});
    }

    @Test
    public void testVerify4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 8));
            b.movePawnOnBoard(b.players[0], new Position(8, 8));
            b.movePawnOnBoard(b.players[0], new Position(10, 8));
            b.movePawnOnBoard(b.players[0], new Position(12, 8));
            b.movePawnOnBoard(b.players[0], new Position(14, 8));
            b.movePawnOnBoard(b.players[0], new Position(14, 10));
            b.movePawnOnBoard(b.players[0], new Position(14, 12));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        PlayerRule playerRule = new IllegalMovement();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(16, 10));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(16, 14));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(12, 10));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(12, 14));});
    }

    @Test
    public void testVerify5(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 8));
            b.movePawnOnBoard(b.players[0], new Position(8, 8));
            b.movePawnOnBoard(b.players[0], new Position(10, 8));
            b.movePawnOnBoard(b.players[0], new Position(12, 8));
            b.movePawnOnBoard(b.players[0], new Position(12, 6));
            b.movePawnOnBoard(b.players[0], new Position(12, 4));
            b.movePawnOnBoard(b.players[0], new Position(12, 2));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        PlayerRule playerRule = new IllegalMovement();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(10, 0));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(10, 4));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(14, 0));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(14, 4));});
    }

    @Test
    public void testVerify6(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.movePawnOnBoard(b.players[0], new Position(6, 8));
            b.movePawnOnBoard(b.players[0], new Position(8, 8));
            b.movePawnOnBoard(b.players[0], new Position(10, 8));
            b.movePawnOnBoard(b.players[0], new Position(12, 8));
            b.movePawnOnBoard(b.players[0], new Position(12, 10));
            b.movePawnOnBoard(b.players[0], new Position(12, 12));
            b.movePawnOnBoard(b.players[0], new Position(12, 14));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        PlayerRule playerRule = new IllegalMovement();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(10, 16));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(10, 12));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(14, 16));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(14, 12));});
    }

    @Test
    public void testVerify7(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(0, 10));
            b.movePawnOnBoard(b.players[0], new Position(0, 12));
            b.movePawnOnBoard(b.players[0], new Position(0, 14));
            b.movePawnOnBoard(b.players[0], new Position(2, 14));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        PlayerRule playerRule = new IllegalMovement();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 12));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 16));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 12));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 16));});
    }

    @Test
    public void testVerify8(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(0, 6));
            b.movePawnOnBoard(b.players[0], new Position(0, 4));
            b.movePawnOnBoard(b.players[0], new Position(0, 2));
            b.movePawnOnBoard(b.players[0], new Position(2, 2));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        PlayerRule playerRule = new IllegalMovement();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 0));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 0));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 4));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 4));});
    }

    @Test
    public void testVerify9(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(0, 10));
            b.movePawnOnBoard(b.players[0], new Position(0, 12));
            b.movePawnOnBoard(b.players[0], new Position(0, 14));
            b.movePawnOnBoard(b.players[0], new Position(2, 14));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        PlayerRule playerRule = new IllegalMovement();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 12));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 16));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 12));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 16));});
    }

    @Test
    public void testVerify10(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(0, 6));
            b.movePawnOnBoard(b.players[0], new Position(0, 4));
            b.movePawnOnBoard(b.players[0], new Position(0, 2));
            b.movePawnOnBoard(b.players[0], new Position(2, 2));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        PlayerRule playerRule = new IllegalMovement();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 0));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 0));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 4));});
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(4, 4));});
    }
}