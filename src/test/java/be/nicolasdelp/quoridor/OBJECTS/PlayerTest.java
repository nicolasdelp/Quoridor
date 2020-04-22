package be.nicolasdelp.quoridor.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void testAddEvent(){
        Player x = new Player("Humain", "Ordi1", 0, Color.Rouge, new Pawn());
        x.addEvent("Test");
        assertEquals(x.getHistorique().size(), 1);
        assertEquals(x.getHistorique().get(x.getHistorique().size()-1), "Test");
    }

    @Test
    public void testNewPlayer(){
        Player x = new Player("Ordinateur", "Ordi1", 0, Color.Rouge, new Pawn());
        assertEquals(x.getHistorique().isEmpty(), true);
    }

    @Test
    public void testAddEvent2(){
        Player x = new Player("Humain", "Ordi1", 0, Color.Rouge, new Pawn());
        x.addEvent("Test");
        x.addEvent("Test2");
        assertEquals(x.getHistorique().size(), 2);
        assertEquals(x.getHistorique().get(x.getHistorique().size()-1), "Test2");
    }

    @Test
    public void testMovePawn(){
        Player x = new Player("Ordinateur", "Ordi1", 0, Color.Rouge, new Pawn());
        x.movePawn(new Position(7,8));
        assertEquals(x.getPawn().getPosition().getX(), 7);
        assertEquals(x.getPawn().getPosition().getY(), 8);
    }
}