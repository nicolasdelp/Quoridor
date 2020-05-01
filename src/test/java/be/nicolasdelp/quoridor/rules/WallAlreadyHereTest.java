package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class WallAlreadyHereTest {

    @Test
    public void testVerify1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(7,3));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        Wall x = new Wall();
        x.setWallDirection(WallDirection.Horizontal);
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], x, new Position(7, 3));});
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(7,3));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        Wall x = new Wall();
        x.setWallDirection(WallDirection.Vertical);
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], x, new Position(7, 3));});
    }

    @Test
    public void testVerify3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(7,3));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        Wall x = new Wall();
        x.setWallDirection(WallDirection.Horizontal);
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], x, new Position(9, 3));});
    }

    @Test
    public void testVerify4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(7,3));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        Wall x = new Wall();
        x.setWallDirection(WallDirection.Horizontal);
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], x, new Position(5, 3));});
    }

    @Test
    public void testVerify5(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,3));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        Wall x = new Wall();
        x.setWallDirection(WallDirection.Vertical);
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], x, new Position(7, 5));});
    }

    @Test
    public void testVerify6(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,5));
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        Wall x = new Wall();
        x.setWallDirection(WallDirection.Vertical);
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], x, new Position(7, 3));});
    }
}