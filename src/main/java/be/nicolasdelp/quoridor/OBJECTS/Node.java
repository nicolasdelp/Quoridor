package be.nicolasdelp.quoridor.objects;

import java.util.ArrayList;

public class Node {

    private ArrayList<Link> links;
    private boolean alreadyVisited;
    private Position nodePosition;

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
}