package be.nicolasdelp.quoridor.graph;

import be.nicolasdelp.quoridor.objects.*;

/**
 * La class Node représente un noeud
 * 
 * @author Delplanque Nicolas
 */
public class Node {

    private boolean alreadyVisited;
    private Position nodePosition;
    private int G; //Cout de déplacement
    private int H; //Distance de la case d'arrivée
    private int F; //= G+H
    private Node parent;

    /**
     * Constructeur
     * 
     */
    public Node(Position position){
        this.nodePosition = position;
    }

    /**
     * Accesseur de la valeur de isVisited
     * 
     * @return true ou false
     */
    public boolean isVisited() {
        return this.alreadyVisited;
    }
    
    /**
     * Mutateur de la valeur de isVisited
     * 
     * @param value true ou false
     */
    public void setVisited(boolean value) {
        this.alreadyVisited = value;
    }

    /**
     * Accesseur de la position d'un noeud
     * 
     * @return une position
     */
    public Position getNodePosition() {
        return nodePosition;
    }

    /**
     * Mutateur du coût de déplacement
     * 
     * @param g un entier
     */
    public void setG(int g) {
        this.G = g;
    }

    /**
     * Accesseur du coût de déplacement
     * 
     * @param g un entier
     */
    public int getG() {
        return this.G;
    }

    /**
     * Mutateur de la distance de la case d'arrivée
     * 
     * @param h un entier
     */
    public void setH(int h) {
        this.H = h;
    }

    /**
     * Accesseur de la valeur de G + H
     * 
     * @return la valeur de F
     */
    public int getF() {
        this.F = this.G + this.H;
        return this.F;
    }

    /**
     * Mutateur du noeud parent
     * 
     * @param parent le noeud parent
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Accesseur du noeud parent
     * 
     * @return le noeud parent
     */
    public Node getParent() {
        return this.parent;
    }
}