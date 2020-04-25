package be.nicolasdelp.quoridor.objects;

import java.util.ArrayList;

public class Node {

    private ArrayList<Link> links;
    private boolean alreadyVisited;
    private Position nodePosition;
    private int G; //Cout déplacement
    private int H; //Distance de la case d'arrivée
    private int F; //= G+H
    private Node parent;


    public Node(Position position){
        this.nodePosition = position;
    }
     
    public ArrayList<Link> getLinks() {
        return links;
    }
     
    public void setLinks(Link link) {
        this.links.add(link);
    }

    public boolean isVisited() {
        return this.alreadyVisited;
    }
       
    public void setVisited(boolean value) {
        this.alreadyVisited = value;
    }

    public Position getNodePosition() {
        return nodePosition;
    }

    public void setG(int g) {
        this.G = g;
    }

    public void setH(int h) {
        this.H = h;
    }

    public int getF() {
        this.F = this.G + this.H;
        return this.F;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}