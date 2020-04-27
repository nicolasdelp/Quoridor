package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class WallAlreadyHereTest {

    @Test
    public void testVerify1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.players[0].getWalls()[b.players[0].getWallIndex()].setWallDirection(WallDirection.Horizontal);
            b.setWallOnBoard(b.players[0], b.players[0].getWalls()[b.players[0].getWallIndex()], b.players[0].getWalls()[b.players[0].getWallIndex()].getWallDirection(), new Position(7,3));
            b.players[1].getWalls()[b.players[1].getWallIndex()].setWallDirection(WallDirection.Horizontal);
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], b.players[0].getWalls()[b.players[0].getWallIndex()], new Position(7, 3));});
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.players[0].getWalls()[b.players[0].getWallIndex()].setWallDirection(WallDirection.Horizontal);
            b.setWallOnBoard(b.players[0], b.players[0].getWalls()[b.players[0].getWallIndex()], b.players[0].getWalls()[b.players[0].getWallIndex()].getWallDirection(), new Position(7,3));
            b.players[1].getWalls()[b.players[1].getWallIndex()].setWallDirection(WallDirection.Vertical);
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], b.players[0].getWalls()[b.players[0].getWallIndex()], new Position(7, 3));});
    }

    @Test
    public void testVerify3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.players[0].getWalls()[b.players[0].getWallIndex()].setWallDirection(WallDirection.Horizontal);
            b.setWallOnBoard(b.players[0], b.players[0].getWalls()[b.players[0].getWallIndex()], b.players[0].getWalls()[b.players[0].getWallIndex()].getWallDirection(), new Position(7,3));
            b.players[1].getWalls()[b.players[1].getWallIndex()].setWallDirection(WallDirection.Horizontal);
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], b.players[0].getWalls()[b.players[0].getWallIndex()], new Position(9, 3));});
    }

    @Test
    public void testVerify4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.players[0].getWalls()[b.players[0].getWallIndex()].setWallDirection(WallDirection.Horizontal);
            b.setWallOnBoard(b.players[0], b.players[0].getWalls()[b.players[0].getWallIndex()], b.players[0].getWalls()[b.players[0].getWallIndex()].getWallDirection(), new Position(7,3));
            b.players[1].getWalls()[b.players[1].getWallIndex()].setWallDirection(WallDirection.Horizontal);
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], b.players[0].getWalls()[b.players[0].getWallIndex()], new Position(5, 3));});
    }

    @Test
    public void testVerify5(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.players[0].getWalls()[b.players[0].getWallIndex()].setWallDirection(WallDirection.Vertical);
            b.setWallOnBoard(b.players[0], b.players[0].getWalls()[b.players[0].getWallIndex()], b.players[0].getWalls()[b.players[0].getWallIndex()].getWallDirection(), new Position(7,3));
            b.players[1].getWalls()[b.players[1].getWallIndex()].setWallDirection(WallDirection.Vertical);
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], b.players[0].getWalls()[b.players[0].getWallIndex()], new Position(7, 5));});
    }

    @Test
    public void testVerify6(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.players[0].getWalls()[b.players[0].getWallIndex()].setWallDirection(WallDirection.Vertical);
            b.setWallOnBoard(b.players[0], b.players[0].getWalls()[b.players[0].getWallIndex()], b.players[0].getWalls()[b.players[0].getWallIndex()].getWallDirection(), new Position(7,5));
            b.players[1].getWalls()[b.players[1].getWallIndex()].setWallDirection(WallDirection.Vertical);
        } catch (RuleViolated e) {
            Assertions.fail(e);
        }
        WallRule wallRule = new WallAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], b.players[0].getWalls()[b.players[0].getWallIndex()], new Position(7, 3));});
    }
}