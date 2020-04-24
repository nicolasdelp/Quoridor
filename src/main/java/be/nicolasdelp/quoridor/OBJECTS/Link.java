package be.nicolasdelp.quoridor.objects;

public class Link {

    private Node fromNode;
    private Node toNode;
    private int cost;

    public Link(Node fromNode, Node toNode){
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.cost = 1;
    }

    public Node getFromNode(){
        return this.fromNode;
    }

    public Node getToNode(){
        return this.toNode;
    }

    public int getCost(){
        return this.cost;
    }
}