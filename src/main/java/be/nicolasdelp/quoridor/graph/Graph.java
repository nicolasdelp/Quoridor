package be.nicolasdelp.quoridor.graph;

import java.util.ArrayList;

import be.nicolasdelp.quoridor.objects.*;

/**
 * La class Graph représent un Board sous forme de graphe
 *
 * @author Delplanque Nicolas
 */
public class Graph {

    private Board board;
    private Position wallPosition;
    private WallDirection wallDirection;
    public Node[][] Nodes = new Node[17][17]; //plateau quoridor
    private ArrayList<Link> Links = new ArrayList<Link>();
    private Node currentNode = new Node(new Position(0, 0));
    // private ArrayList<Node> path;
    private ArrayList<Node> closeList = new ArrayList<Node>(); //Liste des noeuds utilisés pour arriver à à destination

    /**
     * Constructeur
     * 
     */
    public Graph(Board board, Player otherPlayer){
        this.board = board;
        setNodes(otherPlayer);
    }

    public void setWall(WallDirection direction, Position position){
        this.wallDirection = direction;
        this.wallPosition = position;
        makeLinks();
    }

    public void pathForIA(){
        makeLinks();
    }

    /**
     * Création d'un un noeud par case du plateau sauf dans les cases où il y a un pion adverse
     * 
     */
    private void setNodes(Player otherPlayer){
        for(int i = 0; i<this.board.getLength(); i++){
            for(int j = 0; j <this.board.getWidth(); j++){
                if(this.board.getBoardBoxes()[i][j].getisPawnBox()){
                    this.Nodes[i][j] = new Node(new Position(i, j));
                } else{
                    this.Nodes[i][j] = null;
                }
            }
        }
        this.Nodes[otherPlayer.getPawn().getPosition().getX()][otherPlayer.getPawn().getPosition().getY()] = null; //On ne crée pas de noeud ou il y  un pion adverse
    }

    /**
     * Création de lien entre les noeuds si il n'y a pas de mur entre deux
     * 
     */
    private void makeLinks(){
        for(int j=0; j<17; j+=2){ //X    
            for(int i=1; i<17; i+=2){ //Y
                if(this.board.getBoardBoxes()[j][i].getisOccuped() == false){ //Si il n'y a pas de mur horizontal
                    if(this.Nodes[j][i-1] != null && this.Nodes[j][i+1] != null){ //Si il n'y a pas de pion dans les noeuds
                        this.Links.add(new Link(this.Nodes[j][i-1], this.Nodes[j][i+1])); //Lie 2 noeuds
                        this.Links.add(new Link(this.Nodes[j][i+1], this.Nodes[j][i-1])); //Lie 2 noeuds
                    }
                }
            }
        }
        for(int j=1; j<17; j+=2){ //X  
            for(int i=0; i<17; i+=2){ //Y 
                if(this.board.getBoardBoxes()[j][i].getisOccuped() == false){ //Si il n'y a pas de mur vertical
                    if(this.Nodes[j-1][i] != null && this.Nodes[j+1][i] != null){ //Si il n'y a pas de pion dans les noeuds
                        this.Links.add(new Link(this.Nodes[j-1][i], this.Nodes[j+1][i])); //Lie 2 noeuds
                        this.Links.add(new Link(this.Nodes[j+1][i], this.Nodes[j-1][i])); //Lie 2 noeuds
                    }
                }
            }
        }
        if(this.wallDirection == WallDirection.Horizontal){ //On supprime les lien entre les noeuds de part et d'autre du mur
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1]){
                    this.Links.remove(i);
                }
            }
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1]){
                    this.Links.remove(i);
                }
            }
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1]){
                    this.Links.remove(i);
                }
            }
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1]){
                    this.Links.remove(i);
                }
            }
        }
        if(this.wallDirection == WallDirection.Vertical){
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1]){
                    this.Links.remove(i);
                }
            }
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1]){
                    this.Links.remove(i);
                }
            }
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1]){
                    this.Links.remove(i);
                }
            }
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1]){
                    this.Links.remove(i);
                }
            }
        }
    }

    /**
     * PathFinding
     * 
     * @param source la position de départ
     * @param traget la position d'arrivée
     * @return true si il y a un chemin, false si il n'y en a pas
     */
    public boolean pathFinding(Position source, Position target){
        this.currentNode = this.Nodes[source.getX()][source.getY()]; //Noeud actuel (où est le pion)
        Node minimum;
        ArrayList<Node> openList = new ArrayList<Node>(); //Liste des noeuds ouvert
        boolean go = true;

        openList.add(this.currentNode); //On ajoute à l'openList le noeud actuel
        //closeList.add(this.currentNode); //On ajoute à la closeList le noeud de départ
        this.currentNode.setVisited(true); //Le noeud de départ a été visité

        while(go){
            for(int i=0; i<this.Nodes.length; i++){ //Pour chaque noeuds
                for(int j=0; j<this.Nodes.length; j++){
                    if(this.Nodes[i][j] != null){ //Si le noeud existe (cad si il n'est pas occupé)
                        if((this.Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()+2) && (this.Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY())){ //Si le noeud que l'on regarde est celui de droite
                            for(int x=0; x<this.Links.size(); x++){ //On regarde chaque lien créé entre tout les noeuds
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == this.Nodes[i][j]){ //Si il y a un lien entre les deux noeuds dans les 2 sens 
                                    if(this.Nodes[i][j].isVisited() == false){ //Si le noeud n'a pas déjà été visité
                                        this.Nodes[i][j].setParent(this.currentNode); //On lui assigne son noeud parent
                                        this.Nodes[i][j].setG(this.Nodes[i][j].getParent().getG()+1); //On lui donne un coup
                                        this.Nodes[i][j].setH(getNodeDistance(this.Nodes[i][j].getNodePosition(), target)); //On lui donne sa distance par rapport au noeud d'arrivé
                                        this.Nodes[i][j].setVisited(true); //Il a été visité
                                        openList.add(this.Nodes[i][j]); //On l'ajoute à l'openList
                                    }
                                }
                            }
                        }
                        if((this.Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()-2) && (this.Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY())){ //Si le noeud que l'on regarde est celui de gauche
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == this.Nodes[i][j]){
                                    if(this.Nodes[i][j].isVisited() == false){
                                        this.Nodes[i][j].setParent(this.currentNode);
                                        this.Nodes[i][j].setG(this.Nodes[i][j].getParent().getG()+1);
                                        this.Nodes[i][j].setH(getNodeDistance(this.Nodes[i][j].getNodePosition(), target));
                                        this.Nodes[i][j].setVisited(true);
                                        openList.add(this.Nodes[i][j]);
                                    }
                                }
                            }
                        }
                        if((this.Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()) && (this.Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY()-2)){ //Si le noeud que l'on regarde est celui d'en haut
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == this.Nodes[i][j]){
                                    if(this.Nodes[i][j].isVisited() == false){
                                        this.Nodes[i][j].setParent(this.currentNode);
                                        this.Nodes[i][j].setG(this.Nodes[i][j].getParent().getG()+1);
                                        this.Nodes[i][j].setH(getNodeDistance(this.Nodes[i][j].getNodePosition(), target));
                                        this.Nodes[i][j].setVisited(true);
                                        openList.add(this.Nodes[i][j]);
                                    }
                                }
                            }
                        }
                        if((this.Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()) && (this.Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY()+2)){ //Si le noeud que l'on regarde est celui d'en bas
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == this.Nodes[i][j]){
                                    if(this.Nodes[i][j].isVisited() == false){
                                        this.Nodes[i][j].setParent(this.currentNode);
                                        this.Nodes[i][j].setG(this.Nodes[i][j].getParent().getG()+1);
                                        this.Nodes[i][j].setH(getNodeDistance(this.Nodes[i][j].getNodePosition(), target));
                                        this.Nodes[i][j].setVisited(true);
                                        openList.add(this.Nodes[i][j]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(openList.size() > 0){ //Si il y a toujours un noeud dans l'openList
                minimum = openList.get(0); //Le minimum est le noeud de départ
            } else {
                return false; //Si il n'y a plus de posibilitées c'est qu'il n'y a pas de chemin
            }
            for(int i=1; i<openList.size(); i++){ 
                if(minimum.getF() > openList.get(i).getF()){ //On récupère le noeud ayant le F (G + H) minimum de l'openList
                    minimum = openList.get(i);
                }
            }
            for(int i=0; i<openList.size(); i++){ //On retire le noeud ayant le F minimum de l'openList
                if(minimum.equals(openList.get(i))){
                    openList.remove(i);
                }
            }
            closeList.add(minimum); //On ajoute le noeud à la closeList (le chemin à suivre)
            this.currentNode = closeList.get(closeList.size()-1); //Le noeud minimum devient le noeud courant

            if(currentNode.getNodePosition().getX() ==  target.getX() && currentNode.getNodePosition().getY() == target.getY()){ //Si on est arrivée au noeud de destination
                go = false;
                for(int i=1; i<closeList.size(); i++){
                    // System.out.println("(" + closeList.get(i).getNodePosition().getX() + "," + closeList.get(i).getNodePosition().getY() + ")");
                }
                closeList.remove(0); //On enlève le noeud de départ
                // System.out.println("----------------------");
                return true;
            }
        }
        return false;
    }

    /**
     * Distance de Manhattan
     * 
     * @param node un noeud
     * @param traget le noeud d'arrivé
     * @return la distance entre un noeud et le noeud d'arrivée
     */
    private int getNodeDistance(Position node, Position target){
        int res = Math.abs(target.getX()-node.getX()) + Math.abs(target.getY()-node.getY());
        return res;
    }

    public ArrayList<Node> getPath(){
        return this.closeList;
    }

    public static void main(String[] args){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        Graph g = new Graph(b, b.getPlayers()[1]);
        g.setWall(WallDirection.Vertical, new Position(13,7));
        for(int i=0; i<g.Nodes.length; i++){
            for(int j=0; j<g.Nodes.length; j++){
                if(g.Nodes[i][j] != null){
                    System.out.println("(" + g.Nodes[i][j].getNodePosition().getX() + "," + g.Nodes[i][j].getNodePosition().getY() + ")");
                }
            }
        }
        for(int i=0; i<g.Links.size(); i++){
            System.out.println("(" + g.Links.get(i).getFromNode().getNodePosition().getX() + "," + g.Links.get(i).getFromNode().getNodePosition().getY() + ")  -->  (" + g.Links.get(i).getToNode().getNodePosition().getX() + "," + g.Links.get(i).getToNode().getNodePosition().getY() + ")");
        }
    }
}