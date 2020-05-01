package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class IsAPawnBoxTest {

    @Test
    public void testVerify1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        WallRule wallRule = new IsAPawnBox();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[0], new Wall(), new Position(0, 0));});
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        WallRule wallRule = new IsAPawnBox();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[0], new Wall(), new Position(16, 16));});
    }

    @Test
    public void testVerify3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        WallRule wallRule = new IsAPawnBox();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[0], new Wall(), new Position(8, 8));});
    }

    @Test
    public void testVerify4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        WallRule wallRule = new IsAPawnBox();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[1], new Wall(), new Position(14, 2));});
    }
}