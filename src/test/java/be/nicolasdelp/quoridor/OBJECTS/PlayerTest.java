package be.nicolasdelp.quoridor.OBJECTS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

public class PlayerTest {

    @Test
    public void testAddEvent(){
        Player x = new Player("Humain", 0, Color.Rouge, new Pawn(Color.Rouge, new Position(4, 3)));
        x.addEvent("Test");
        assertEquals(x.getHistorique().size(), 1);
        assertEquals(x.getHistorique().get(x.getHistorique().size()-1), "Test");
    }

    @Test
    public void testNewPlayer(){
        Player x = new Player("Humain", 0, Color.Rouge, new Pawn(Color.Rouge, new Position(4, 3)));
        assertTrue(x.getHistorique().isEmpty());
    }

    @Test
    public void testAddEvent2(){
        Player x = new Player("Humain", 0, Color.Rouge, new Pawn(Color.Rouge, new Position(4, 3)));
        x.addEvent("Test");
        x.addEvent("Test2");
        assertEquals(x.getHistorique().size(), 2);
        assertEquals(x.getHistorique().get(x.getHistorique().size()-1), "Test2");
    }

    @Test
    public void testMovePawnOnBoard(){
        Player x = new Player("Humain", 0, Color.Rouge, new Pawn(Color.Rouge, new Position(4, 3)));
        x.movePawnOnBoard(new Position(7,8));
        assertEquals(x.getPawn().getPosition().getX(), 7);
        assertEquals(x.getPawn().getPosition().getY(), 8);
    }
}