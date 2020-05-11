package be.nicolasdelp.quoridor.graph;

/**
 * La class Link représente un lien entre deux noeuds
 *
 * @author Delplanque Nicolas
 */
public class Link {

    private Node fromNode;
    private Node toNode;

    /**
     * Constructeur
     * 
     */
    public Link(Node fromNode, Node toNode){
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    /**
     * Accesseur du noeud de départ du lien
     * 
     * @return le noeud de départ
     */
    public Node getFromNode(){
        return this.fromNode;
    }

    /**
     * Accesseur du noeud de d'arrivée du lien
     * 
     * @return le noeud d'arrivé
     */
    public Node getToNode(){
        return this.toNode;
    }
}