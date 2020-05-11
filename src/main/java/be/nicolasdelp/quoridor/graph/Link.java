package be.nicolasdelp.quoridor.graph;

/**
 * La class Link represente un lien entre deux noeuds
 *
 * @author Delplanque Nicolas
 */
public class Link {

    private Node fromNode;
    private Node toNode;

    /**
     * Constructeur
     * 
     * @param fromNode le noeud de depart
     * @param toNode le noeud d'arrive
     */
    public Link(Node fromNode, Node toNode){
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    /**
     * Accesseur du noeud de depart du lien
     * 
     * @return le noeud de depart
     */
    public Node getFromNode(){
        return this.fromNode;
    }

    /**
     * Accesseur du noeud de d'arrivee du lien
     * 
     * @return le noeud d'arrive
     */
    public Node getToNode(){
        return this.toNode;
    }
}