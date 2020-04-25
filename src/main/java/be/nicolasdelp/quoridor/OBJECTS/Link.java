package be.nicolasdelp.quoridor.objects;

public class Link {

    private Node fromNode;
    private Node toNode;
    private int cost;

    public Link(Node fromNode, Node toNode, int cost){
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.cost = cost;
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

    public int setCost(){
        return this.cost;
    }
}